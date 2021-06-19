package com.callor.score.persistance.impl;

import java.util.List;

import com.callor.score.model.ListDTO;
import com.callor.score.persistance.ListDao;

public class ListDaoImplV1 implements ListDao{

	@Override
	public List<ListDTO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM view_리스트 ";
		
		return null;
	}

	@Override
	public ListDTO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ListDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ListDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
