package com.com.food;

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

import com.com.food.model.MyfoodVO;
import com.com.food.model.TotalDTO;
import com.com.food.service.MyfoodService;
import com.com.food.service.impl.MyfoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet{

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
			
		}else if(subPath.equals("/date")) {
			String strDate = req.getParameter("date");
			
			if(strDate == null || strDate.equals("")) {
				out.println("날짜가 없음");
				out.close();
			} else {
				List<TotalDTO> totalDTO = mfService.findByDate(strDate);
				ServletContext app = this.getServletContext();
				app.setAttribute("FOOD", totalDTO);
				
				RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/home.jsp");
				disp.forward(req, resp);
			}
			
		} else if(subPath.equals("/insert")) {
			String mf_date = req.getParameter("mf_date");
			String mf_ccode = req.getParameter("mf_ccode");
//			Integer mf_intake = Integer.parseInt(req.getParameter("mf_intake"));
			
			MyfoodVO mfVO = new MyfoodVO();
			mfVO.setMf_date(mf_date);
			mfVO.setMf_ccode(mf_ccode);
//			mfVO.setMf_intake(mf_intake);
			
			int result = mfService.insert(mfVO);
			if(result > 0) {
				out.println("섭취정보 등록 완료!");
				resp.sendRedirect("/food/");
			} else {
				out.println("섭취정보 등록 실패");
				resp.sendRedirect("/insert");
			}
			out.close();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}

	
}
