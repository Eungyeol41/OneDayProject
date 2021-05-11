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
public class TotalDTO {

	private String fd_fcode; // 식품코드
	private String fd_fname; // 식품명
	private Integer fd_year; // 출시연도
	private String cp_code; // 제조사코드
	private String cp_com; // 제조사명
	private String it_code; // 분류코드
	private String it_name; // 분류명
	private Integer fd_one; // 1회제공량
	private Integer fd_total; // 총내용량(g)
	private Integer fd_energy; // 에너지(kcal)
	private Integer fd_protein; // 단백질(g)
	private Integer fd_fat; // 지방(g)
	private Integer fd_car; // 탄수화물(g)
	private Integer fd_sugar; // 총당류(g)
	
}
