package com.callor.score.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/student")
public class StudentController {

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
}
