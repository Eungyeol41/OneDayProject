package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	Scanner scan;
	List<ScoreVO> scoreList;

	int sumKor;
	int sumEng;
	int sumMath;
	int sumSci;
	int sumHis;

	int sumTotal;
	float floatAvg;
	
	int line = 80;

	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}

	public void inputMenu() {
		String strMenu = null;
		Integer intMenu = null;

		while (true) {
			System.out.println("=".repeat(line));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(line));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(line));
			System.out.print("업무선택 >> ");
			strMenu = scan.nextLine();

			if (strMenu.equals("QUIT")) {
				break;
			}

			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("메뉴선택 오류!");
				System.out.println("메뉴는 1, 2, QUIT만 입력가능합니다");
				continue;
			} // end try-catch

			if (intMenu == 1) {
				this.inputScore();
			} else if (intMenu == 2) {
				this.printList();
			} else {
				System.out.println("메뉴선택 오류!");
				System.out.println("메뉴는 1, 2, QUIT만 입력가능합니다");
			} // end if
		} // end while

		System.out.println("업무종료!");

	}// end inputMenu

	public void inputScore() {

		String name = null;
		Integer kor = 0;
		Integer eng = 0;
		Integer math = 0;
		Integer science = 0;
		Integer history = 0;

		while (true) {

			System.out.println("=".repeat(line));
			System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT)");
			System.out.println("=".repeat(line));
			System.out.print("이름 >> ");
			name = scan.nextLine();
			if (name.equals("QUIT")) {
				break;
			}

			System.out.println("=".repeat(line));
			System.out.println(name + " 학생의 성적을 입력하세요 ( 성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT )");
			System.out.println("-".repeat(line));

			System.out.print("국어 >> ");
			kor = this.exception();
			if(kor == null) {
				return;
			}

			System.out.print("영어 >> ");
			eng = this.exception();
			if(eng == null) {
				return;
			}

			System.out.print("수학 >> ");
			math = this.exception();
			if(math == null) {
				return;
			}
			
			System.out.print("과학 >> ");
			science = this.exception();
			if(science == null) {
				return;
			}

			System.out.print("역사 >> ");
			history = this.exception();
			if(history == null) {
				return;
			}

			ScoreVO vo = new ScoreVO();
			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			vo.setScience(science);
			vo.setHistory(history);
			scoreList.add(vo);

			this.scoreAdd(vo);

		} // end while

	}// end inputScore
	
	private Integer exception() {

		int num = 0;
		String strNum = null;

		while (true) {

			strNum = scan.nextLine();

			if (strNum.equals("QUIT")) {
				return null;
			}

			try {
				num = Integer.valueOf(strNum);
			} catch (Exception e) {
				System.out.println("숫자로 입력해주세요");
				continue;
			}

			if (num < 0 || num > 100) {
				System.out.println("숫자는 0 ~ 100까지입니다. 다시 입력해주세요");
				System.out.print(" >> ");
				continue;
			} else {
				break;
			} // end if
		} // end while
		return num;
	}// end ex

	public void totalAvg(ScoreVO vo) {

		int total = 0;
		float avg = 0;

		total = vo.getKor();
		total += vo.getEng();
		total += vo.getMath();
		total += vo.getScience();
		total += vo.getHistory();

		avg = (float) total / 5;

		vo.setTotal(total);
		vo.setAvg(avg);
//		scoreList.add(vo);

	}

	public void subtotalAvg(ScoreVO vo) {

		sumKor += vo.getKor();
		sumEng += vo.getEng();
		sumMath += vo.getMath();
		sumSci += vo.getScience();
		sumHis += vo.getHistory();

		sumTotal = sumKor;
		sumTotal += sumEng;
		sumTotal += sumMath;
		sumTotal += sumSci;
		sumTotal += sumHis;

		floatAvg = (float) sumTotal / 5;

	}

	public void scoreAdd(ScoreVO vo) {
		System.out.println("=".repeat(line));
		System.out.println(vo.getName() + " 학생의 성적이 추가되었습니다");
		System.out.println("=".repeat(line));
		System.out.println("국어 : " + vo.getKor());
		System.out.println("영어 : " + vo.getEng());
		System.out.println("수학 : " + vo.getMath());
		System.out.println("과학 : " + vo.getScience());
		System.out.println("역사 : " + vo.getHistory());
		this.totalAvg(vo);
		this.subtotalAvg(vo);
	}

	

	public void printList() {
		
		System.out.println("=".repeat(line));
		System.out.println("순번\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println("-".repeat(line));
		
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);

			System.out.printf("%d\t", (i + 1));
			System.out.printf("%d\t", vo.getKor());
			System.out.printf("%d\t", vo.getEng());
			System.out.printf("%d\t", vo.getMath());
			System.out.printf("%d\t", vo.getScience());
			System.out.printf("%d\t", vo.getHistory());
			System.out.printf("%d\t", vo.getTotal());
			System.out.printf("%3.2f\n", vo.getAvg());

		}
		System.out.println("=".repeat(line));
		System.out.print("총점\t");
		System.out.printf("%d\t", sumKor);
		System.out.printf("%d\t", sumEng);
		System.out.printf("%d\t", sumMath);
		System.out.printf("%d\t", sumSci);
		System.out.printf("%d\t", sumHis);
		System.out.printf("%d\t", sumTotal);
		System.out.printf("%3.2f\n", floatAvg);

	} // end printList

}
