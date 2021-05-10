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

	private Integer mf_seq;
	private String mf_date;
	private String mf_code;
	private String mf_name;
	private Integer mf_intake;
	private Integer mf_energy;
	private Integer mf_protein;
	private Integer mf_fat;	
	private Integer mf_car;	
	private Integer mf_sugar;
	
}
