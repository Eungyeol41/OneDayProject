package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListDTO {
	
	private String v_num; 			// 학번
	private String v_name; 			// 이름
	private String v_dept; 			// 전공
	private Integer v_grade = 0; 	// 학년
	private Long v_subject = 0L; 	// 응시과목
	private Integer v_total = 0; 	// 총점
	private Float v_avg = 0F; 		// 평균

}
