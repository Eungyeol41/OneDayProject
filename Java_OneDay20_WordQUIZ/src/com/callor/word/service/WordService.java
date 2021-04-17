package com.callor.word.service;

import com.callor.word.model.WordVO;

public interface WordService {
	
	public void selectMenu(); // 메뉴 출력
	public void loadWord(); // word.txt에서 단어 가져오기
	public WordVO getWord(); // wordList에 담긴 단어
	public void viewWord(int point); // 게임 화면
	public Integer wrong(WordVO vo, int point); // 게임 시 틀렸을 때
	public void loadPoint(String name, int point); // 이름과 포인트 점수 저장
	public Integer importPoint(); // 포인트 점수 불러오기
	
}
