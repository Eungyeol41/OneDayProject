package com.callor.word.model;

public class WordVO {

	private Integer point;
	private String English;
	private String Korea;
	
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getEnglish() {
		return English;
	}
	public void setEnglish(String english) {
		English = english;
	}
	public String getKorea() {
		return Korea;
	}
	public void setKorea(String korea) {
		Korea = korea;
	}
	
	@Override
	public String toString() {
		return "WordVO [point=" + point + ", English=" + English + ", Korea=" + Korea + "]";
	}
	
	
}
