package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.ListDTO;
import com.callor.score.persistance.ListDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("listDaoV1")
public class ListDaoImplV1 implements ListDao {

	@Autowired(required=false)
	protected final JdbcTemplate jdbcTemplate;
	public ListDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ListDTO> selectAll() {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM view_리스트 ";

		List<ListDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ListDTO>(ListDTO.class));
		log.debug("SELECT {}", list.toString());
		
		return list;
	}

	@Override
	public ListDTO findById(String pk) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM view_리스트 ";
		sql += " WHERE 학번 = ? ";
		
		ListDTO listDTO = (ListDTO) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ListDTO.class));
		log.debug("FINDBYID {}", listDTO.toString());
		
		return listDTO;
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
