package com.callor.word.service;

import com.callor.word.model.WordVO;

public interface WordService {
	
	public Integer selectMenu();
	public void loadWord();
	public WordVO getWord();
	public void viewWord();
	public void wrong(WordVO vo);
	public void loadPoint(int point);
	public void importPoint(String name, int point);
	
}
