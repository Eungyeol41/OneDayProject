package com.callor.score.persistance;

import java.util.List;

import com.callor.score.model.ScoreVO;

public interface ScoreDao extends GenericDao<ScoreVO, String>{

	public List<ScoreVO> findByStNum(String st_num);
	public String findByMaxCode();
	
}
