package com.com.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.TotalDTO;
import com.com.food.service.MyfoodService;
import com.com.food.service.impl.MyfoodServiceImplV1;


@WebServlet("/")
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected MyfoodService mfService;
	public HomeController() {
		mfService = new MyfoodServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<TotalDTO> totalList = mfService.selectAll();
		req.setAttribute("TOTALLIST", totalList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
	}

	
}
