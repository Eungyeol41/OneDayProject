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

	private Integer mf_seq; // number
	private String mf_date; // varchar2(10 byte)
	private String mf_ccode; // char(7 byte)
	private Integer mf_intake; // number
	
}
