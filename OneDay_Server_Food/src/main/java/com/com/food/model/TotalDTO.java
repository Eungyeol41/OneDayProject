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

	private String fd_fcode; // char(7 byte)
	private String fd_fname; // nvarchar2(125 char)
	private Integer fd_year; // number
	private String cp_code; // char(6 byte)
	private String cp_com; // nvarchar2(125 char)
	private String it_code; // char(6 byte)
	private String it_name; // nvarchar2(50 char)
	private Integer fd_one; // number
	private Integer fd_total; // number
	private Integer fd_energy; // number
	private Integer fd_protein; // number
	private Integer fd_fat; // number
	private Integer fd_car; // number
	private Integer fd_sugar; // number
	
}
