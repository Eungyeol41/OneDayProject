package com.callor.score.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

public class StudentServiceImplV1 implements StudentService{
	
	protected final JdbcTemplate JdbcTemplate;
	public StudentServiceImplV1(JdbcTemplate jdbcTemplate) {
		this.JdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO 학생 정보 추가하기
		
		String sql = " INSERT INTO tbl_student(st_num, st_name, st_dept, st_grade, st_tel, st_addr)";
		sql += " VALUES (?, ?, ?, ?, ?, ?) ";
		
		Object[] params = new Object[] {
				vo.getSt_num(),
				vo.getSt_name(),
				vo.getSt_dept(),
				vo.getSt_grade(),
				vo.getSt_tel(),
				vo.getSt_addr()
		};
		
		return JdbcTemplate.update(sql, params);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO 학생 정보 수정하기
		return 0;
	}

	@Override
	public int delete(String st_num) {
		// TODO 학생 정보 삭제하기
		
		String sql = " DELETE FROM tbl_student ";
		sql += " WHERE st_num = ? ";
		
		return JdbcTemplate.update(sql, st_num);
	}

}
