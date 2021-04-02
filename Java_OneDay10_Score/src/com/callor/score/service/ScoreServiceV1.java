package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	Scanner scan;
	List<ScoreVO> intList;
	
	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		intList = new ArrayList<ScoreVO>();
	}
	
	public void inputScore() {
		String name;
		Integer kor;
		Integer eng;
		Integer math;
		Integer science;
		Integer history;
		System.out.println("=".repeat(70));
		System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT");
		System.out.println("=".repeat(70));
		System.out.println("이름 >> ");
		name = scan.next();
		System.out.println();
	}
	
	
}
