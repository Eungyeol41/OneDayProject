package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("scoreDaoV1")
public class ScoreDaoImplV1 implements ScoreDao{
	
	protected JdbcTemplate jdbcTemplate;
	public ScoreDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_score ";
		
		List<ScoreVO> scList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		log.debug("SELECT {}", scList.toString());
		
		return scList;
	}

	@Override
	public ScoreVO findById(String pk) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_stnum = ? ";
		
		ScoreVO scVO = (ScoreVO) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ScoreVO.class));
		log.debug("FINDBYID {}", scVO.toString()); 
		
		return scVO;
	}
	
	@Override
	public List<ScoreVO> findByStNum(String sc_stnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
