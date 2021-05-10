package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyfoodVO;
import com.com.food.model.TotalDTO;

public interface MyfoodService {

	public List<FoodDTO> selectAll();
	public List<TotalDTO> findByDate(String date);
	public List<TotalDTO> findByfName(String mf_name);
	public int insert(MyfoodVO myfoodVO);
	
}