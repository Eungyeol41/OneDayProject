package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyfoodVO;
import com.com.food.model.TotalDTO;
import com.com.food.service.MyfoodService;
import com.com.food.service.impl.MyfoodServiceImplV1;

@WebServlet("/inform/*")
public class FoodController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected MyfoodService mfService;
	
	public FoodController() {
		mfService = new MyfoodServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/list")) {
			mfService.selectAll();
			out.println("섭취정보 확인");
			
		} else if(subPath.equals("/date")) {
			String strDate = req.getParameter("date");
			
			if(strDate == null || strDate.equals("")) {
				out.println("날짜를 입력해주세요.");
				out.close();
				
			} else {
				List<FoodDTO> foodDTO = mfService.findByDate(strDate);
				ServletContext app = this.getServletContext();
				app.setAttribute("FOODDTO", foodDTO);
				
				RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/date.jsp");
				disp.forward(req, resp);
			}
		} else if(subPath.equals("/selectName")) {
			// 식품명 검색창
			RequestDispatcher rDisp = req.getRequestDispatcher("/WEB-INF/views/selectName.jsp");
			rDisp.forward(req, resp);
			
		} else if(subPath.equals("/nameSelect")) {
			// 식품명으로 검색한 결과창
			String name = req.getParameter("name");
			List<TotalDTO> totalList = mfService.findByfName(name);
			
			req.setAttribute("TLIST", totalList);
			RequestDispatcher rDisp = req.getRequestDispatcher("/WEB-INF/views/nameSelect.jsp");
			rDisp.forward(req, resp);
			
		} else if(subPath.equals("/insert")) {
			String mf_ccode = req.getParameter("code");
			req.setAttribute("CODE", mf_ccode);
			RequestDispatcher rDisp = req.getRequestDispatcher("/WEB-INF/views/insert.jsp");
			rDisp.forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String mf_date = req.getParameter("date");
		String mf_fcode = req.getParameter("code");
		Integer mf_intake = Integer.parseInt(req.getParameter("intake"));
		
		MyfoodVO mfVO = new MyfoodVO();
		mfVO.setMf_date(mf_date);
		mfVO.setMf_fcode(mf_fcode);
		mfVO.setMf_intake(mf_intake);
		
		int result = mfService.insert(mfVO);
		
		if(result > 0) {
			out.println("섭취정보 등록 완료!");
			resp.sendRedirect("/OneDay_Server_Food");
		} else {
			out.println("섭취정보 등록 실패");
			resp.sendRedirect("/food");
		}
		out.close();
	}

	
}
