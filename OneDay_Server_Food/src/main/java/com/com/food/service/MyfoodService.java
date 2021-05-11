package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyfoodVO;
import com.com.food.model.TotalDTO;

public interface MyfoodService {

	public List<FoodDTO> selectAll();
	public List<FoodDTO> findByDate(String date);
	public List<TotalDTO> findByfName(String fd_fname);
	public int insert(MyfoodVO myfoodVO);
	
}
