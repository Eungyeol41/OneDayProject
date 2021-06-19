package com.callor.score.service.impl;

import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("studentServiceV1")
public class StudentServiceImplV1 implements StudentService{
	
	protected final StudentDao studentDao;
	public StudentServiceImplV1(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO 학생 정보 추가하기
		
		String st_num = studentDao.findByMaxCode();
		log.debug("STNUM {}", st_num);
		
		if(st_num == null || st_num.equals("")) {
			
			st_num = String.format("2021%04d", 1); // 20210001 형식
			
		} else {
			
			String _num = st_num.substring(4); // 2021 자르기 (뒤에 4자리만)
			Integer intNum = Integer.valueOf(_num) + 1; // 위에서 자른 4자리 숫자에 1 추가
			st_num = String.format("2021%04d", intNum); // 추가한 숫자를 다시 20210002 형식으로 변환
			
		}
		
		vo.setSt_num(st_num);
		studentDao.insert(vo);
		
		return 0;
	}

}
