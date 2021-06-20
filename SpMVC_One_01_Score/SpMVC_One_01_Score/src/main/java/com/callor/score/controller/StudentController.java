package com.callor.score.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/student")
public class StudentController {

	protected StudentDao studentDao;
	protected ScoreDao scoreDao;
	
	public StudentController(StudentDao studentDao, ScoreDao scoreDao) {
		this.studentDao = studentDao;
		this.scoreDao = scoreDao;
	}
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String student(HttpSession hSession, Model model) {
		
		Object obj = hSession.getAttribute("STUDENTVO");
		StudentVO stVO = (StudentVO)obj;

		return "student/list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		
		return "student/insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(String name, String dept, String del, String addr, Integer grade) {
		
		
		
		return "student/insert";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(Model model, String st_num) {
		
		StudentVO stVO = studentDao.findById(st_num);
		List<ScoreVO> scList = scoreDao.findByStNum(st_num);
		
		model.addAttribute("ST", stVO);
		model.addAttribute("SC", scList);
		
		return "student/studentInfo";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(StudentVO vo) {
		
		studentDao.update(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String st_num) {
		
		studentDao.delete(st_num);
		
		return "redirect:/";
	}
}
