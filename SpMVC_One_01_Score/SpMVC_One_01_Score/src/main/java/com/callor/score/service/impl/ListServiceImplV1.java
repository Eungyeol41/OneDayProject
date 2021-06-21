package com.callor.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.score.model.ListDTO;
import com.callor.score.persistance.ListDao;
import com.callor.score.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("listServiceV1")
public class ListServiceImplV1 implements ListService{

	protected ListDao listDao;
	public ListServiceImplV1(ListDao listDao) {
		this.listDao = listDao;
	}
	
	@Override
	public List<ListDTO> viewList() {
		// TODO Auto-generated method stub

		return listDao.selectAll();
		
	}

}
