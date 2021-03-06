package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.ScoreVO;
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
		
		ScoreVO scVO = (ScoreVO)jdbcTemplate.queryForObject(sql, new Object[] {pk}, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		log.debug("FINDBYID {}", scVO.toString()); 
		
		return scVO;
	}
	
	@Override
	public List<ScoreVO> findByStNum(String sc_stnum) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_stnum = ? ";
		
		Object[] params = new Object[] { sc_stnum };
		
		List<ScoreVO> scList = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		log.debug("list {}", scList.toString());
		
		return scList;
	}

	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT MAX(st_num) FROM tbl_score ";
		String scStNum = (String) jdbcTemplate.queryForObject(sql, String.class);
		
		return scStNum;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		
		String sql = " INSERT INTO tbl_score ";
		sql += " ( sc_stnum, sc_subject, sc_score )";
		sql += " VALUES(?, ?, ?) ";
		
		Object[] params = new Object[] {
		
				vo.getSc_stnum(),
				vo.getSc_subject(),
				vo.getSc_score()
		};
		
		return jdbcTemplate.update(sql, params);
		
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		
		String sql = " UPDATE tbl_score SET ";
		sql += " sc_stnum = ?, sc_subject = ?, sc_score = ? ";
		sql += " WHERE sc_seq = ? ";
		
		Object[] params = new Object[] {
				vo.getSc_stnum(),
				vo.getSc_subject(),
				vo.getSc_score(),
				vo.getSc_seq()
		};
		return jdbcTemplate.update(sql,params);
		
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		
		String sql = " DELETE FROM tbl_score ";
		sql += " WHERE sc_seq = ? ";
	
		return jdbcTemplate.update(sql,pk);

	}

}
