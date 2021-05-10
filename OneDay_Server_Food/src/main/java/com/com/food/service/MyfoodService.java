package com.com.food.service;

import java.util.List;

import com.com.food.model.MyfoodVO;
import com.com.food.model.TotalDTO;

public interface MyfoodService {

	public List<TotalDTO> selectAll();
	public List<TotalDTO> findByDate(String date);
	public int insert(MyfoodVO myfoodVO);
	
}
