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
public class ScoreVO {

	private String sc_seq; 		// SEQ
	private String sc_stnum; 	// 학번
	private String sc_subject; 	// 응시과목
	private Integer sc_score; 	// 점수
	
}
