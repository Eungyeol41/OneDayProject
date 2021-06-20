package com.callor.score.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ListDTO;
import com.callor.score.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/score")
public class ScoreController {

	protected ListService listService;
	public ScoreController(ListService listService) {
		this.listService = listService;
	}
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET )
	public String score(HttpSession hSession, Model model) {
		
		List<ListDTO> listDTO = listService.viewList();
		
		model.addAttribute("LISTDTO", listDTO);
		return "/score/list";
	}
	
}
