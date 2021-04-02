package com.callor.score.model;

public class ScoreVO {

	private String name;
	private Integer kor;
	private Integer eng;
	private Integer math;
	private Integer science;
	private Integer history;
	private Integer total;
	private Float avg;
	private Integer sumtotal;
	private Float floatAvg;
	
	
	
	public Integer getSumtotal() {
		return sumtotal;
	}
	public void setSumtotal(Integer sumtotal) {
		this.sumtotal = sumtotal;
	}
	public Float getFloatAvg() {
		return floatAvg;
	}
	public void setFloatAvg(Float floatAvg) {
		this.floatAvg = floatAvg;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Float getAvg() {
		return avg;
	}
	public void setAvg(Float avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	public Integer getScience() {
		return science;
	}
	public void setScience(Integer science) {
		this.science = science;
	}
	public Integer getHistory() {
		return history;
	}
	public void setHistory(Integer history) {
		this.history = history;
	}
	
	
	
}
