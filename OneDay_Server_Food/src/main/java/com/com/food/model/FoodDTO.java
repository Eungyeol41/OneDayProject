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
public class FoodDTO {

	private Integer mf_seq; // 일련번호
	private String mf_date; // 날짜
	private String mf_code; // 식품코드
	private String mf_name; // 식품명
	private Integer mf_intake; // 섭취량
	private Integer mf_total; // 총내용량
	private Integer mf_energy; // 에너지
	private Integer mf_protein; // 단백질
	private Integer mf_fat;	// 지방
	private Integer mf_car;	// 탄수화물
	private Integer mf_sugar; // 총당류
	
}
