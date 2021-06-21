package com.callor.score.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ListDTO;
import com.callor.score.persistance.ListDao;

@Controller
public class HomeController {
	
	protected final ListDao listDao;
	public HomeController(ListDao listDao) {
		this.listDao = listDao;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<ListDTO> listDTO = listDao.selectAll();
		model.addAttribute("LISTDTO", listDTO);
		
		return "home";
		
	}
	
}
