package com.com.food.model;

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
public class MyfoodVO {

	private Integer mf_seq; // 일련번호
	private String mf_date; // 날짜
	private String mf_fcode; // 식품코드
	private Integer mf_intake; // 섭취량
	
}
