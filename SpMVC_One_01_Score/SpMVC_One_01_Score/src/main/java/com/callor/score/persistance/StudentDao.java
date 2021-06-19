package com.callor.score.persistance;

import java.util.List;

import com.callor.score.model.StudentVO;

public interface StudentDao extends GenericDao<StudentVO, String>{

	public List<StudentVO> findByName(String name);
	
	public String findByMaxCode();
}
