package com.callor.score.service;

import com.callor.score.model.StudentVO;

public interface StudentService {

	public int insert(StudentVO vo);
	public int update(StudentVO vo);
	public int delete(String st_num);
	
}
