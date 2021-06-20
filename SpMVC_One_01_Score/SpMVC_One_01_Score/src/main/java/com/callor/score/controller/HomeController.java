package com.callor.score.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ListDTO;
import com.callor.score.service.ListService;

@Controller
public class HomeController {
	
	@Autowired(required=false)
	protected ListService listService;
	public HomeController(ListService listService) {
		this.listService = listService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<ListDTO> list = listService.viewList();
		
		model.addAttribute("LIST", list);
		
		return "home";
		
	}
	
}
