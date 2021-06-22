package com.callor.score.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.ListService;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/student")
public class StudentController {

	protected final StudentDao studentDao;
	protected final ScoreDao scoreDao;
	protected final StudentService studentService;
	
	public StudentController(StudentDao studentDao, ScoreDao scoreDao, StudentService studentService) {
		this.studentDao = studentDao;
		this.scoreDao = scoreDao;
		this.studentService = studentService;
	}
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String student(HttpSession hSession, Model model) {

		List<StudentVO> stList = studentDao.selectAll();
		
		model.addAttribute("STLIST", stList);
		return "student/list";
		
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(Model model, String st_num) {
		
		StudentVO vo = studentDao.findById(st_num);
		List<ScoreVO> scList = scoreDao.findByStNum(st_num);
		
		model.addAttribute("ST", vo);
		model.addAttribute("SC", scList);
		
		return "student/studentInfo";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpSession hSession, Model model) {
		
		StudentVO vo = (StudentVO)hSession.getAttribute("vo");
		
		return "student/insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(String name, String dept, Integer grade, String tel, String addr, StudentVO vo) {

		vo.setSt_name(name);
		vo.setSt_dept(dept);
		vo.setSt_grade(grade);
		vo.setSt_tel(tel);
		vo.setSt_addr(addr);
		
		studentService.insert(vo);
		log.debug(vo.toString());
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update (HttpSession hSession, Model model) {
		
		StudentVO vo = (StudentVO)hSession.getAttribute("vo");
		model.addAttribute("STVO", vo);
		
		return "student/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(String num, String name, String dept, Integer grade, String tel, String addr, StudentVO vo) {
		
		vo.setSt_addr(addr);
		vo.setSt_dept(dept);
		vo.setSt_grade(grade);
		vo.setSt_name(name);
		vo.setSt_tel(tel);
		
		studentDao.update(vo);
		
		return "redirect:/info?num=" + num;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String st_num, Model model) {
		
		studentDao.delete(st_num);
		
		return "redirect:/";
	}
}
