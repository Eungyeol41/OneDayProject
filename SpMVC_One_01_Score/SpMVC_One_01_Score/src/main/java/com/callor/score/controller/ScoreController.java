package com.callor.score.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ListDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.ListService;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/score")
public class ScoreController {

	protected final StudentDao stDao;
	protected final ScoreDao scDao;
	protected final ListService listService;
	public ScoreController(ListService listService,ScoreDao scDao, StudentDao stDao) {
		this.stDao = stDao;
		this.scDao = scDao;
		this.listService = listService;
	}
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET )
	public String score(HttpSession hSession, Model model) {
		
		List<StudentVO> stVO = stDao.selectAll();
		
		model.addAttribute("STVO", stVO);
		
		return "/score/list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpSession hSession) {
		
		ScoreVO vo = (ScoreVO)hSession.getAttribute("vo");
		
		return "/score/insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ScoreVO vo) {
		
		scDao.insert(vo);
		
		return "redirect:/score";
	}
	
}
