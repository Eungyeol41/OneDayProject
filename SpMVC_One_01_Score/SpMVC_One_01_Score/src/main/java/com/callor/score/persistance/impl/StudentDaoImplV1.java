package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("studentDaoV1")
public class StudentDaoImplV1 implements StudentDao{
	
	protected JdbcTemplate jdbcTemplate;
	public StudentDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub 
		
		String sql = " SELECT * FROM tbl_student ";
		
		List<StudentVO> stList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		log.debug("SELECT {}", stList.toString());
		
		return stList;
	}

	@Override
	public StudentVO findById(String pk) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_num = ? ";
		
		StudentVO stVO = (StudentVO) jdbcTemplate.query(sql, new Object[] { pk }, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		log.debug("FINDBYID {}", stVO.toString());
		
		return stVO;
	}
	
	@Override
	public List<StudentVO> findByName(String name) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_name = ? ";
		
		List<StudentVO> stList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		log.debug("list {}", stList.toString());
		
		return null;
	}
	
	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT MAX(st_num) FROM tbl_student ";
		String stNum = (String) jdbcTemplate.queryForObject(sql, String.class);
		
		return stNum;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		
		String sql = " INSERT INTO tbl_student ";
		sql += " (st_num, st_name, st_dept, st_grade, st_tel, st_addr )";
		sql += " VALUES(?, ?, ?, ?, ?, ?) ";
		
		log.debug(vo.toString());
		Object[] params = new Object[] {
				vo.getSt_num(),
				vo.getSt_name(),
				vo.getSt_dept(),
				vo.getSt_grade(),
				vo.getSt_tel(),
				vo.getSt_addr()
		};
		return jdbcTemplate.update(sql, params);
		
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		
		String sql = " UPDATE tbl_student SET ";
		sql += " st_name = ?, st_dept = ?, st_grade = ?, st_tel = ?, st_addr = ? ";
		sql += " WHERE st_num = ? ";
		
		Object[] params = new Object[] {
				vo.getSt_name(),
				vo.getSt_dept(),
				vo.getSt_grade(),
				vo.getSt_tel(),
				vo.getSt_addr(),
				vo.getSt_num()
		};
		return jdbcTemplate.update(sql, params);
		
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		
		String sql = " DELETE FROM tbl_student ";
		sql += " WHERE st_num = ? ";
		
		return jdbcTemplate.update(sql, pk);
		
	}

}
