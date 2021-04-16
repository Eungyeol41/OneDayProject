package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;
import com.callor.word.service.WordService;

public class WordServiceImplV1 implements WordService {

	protected Random rnd;
	protected Scanner scan;
	protected List<WordVO> wordList;
	protected final int 영어 = 0;
	protected final int 한글 = 1;
	int line = 80;
	Integer retry;
	int winPoint = 0;
	int losePoint = 0;
	int point = 0;
	int nCount = 0;
	String name = null;

	public WordServiceImplV1() {
		rnd = new Random();
		scan = new Scanner(System.in);
		wordList = new ArrayList<WordVO>();

		this.loadWord();
	}

	@Override
	public Integer selectMenu() {
		// TODO 메뉴 출력

		while (true) {
			System.out.println("=".repeat(line));
			System.out.println("✨ 괴도 뤼팡의 '황금 열쇠 🔑' 찾기");
			System.out.println("=".repeat(line));
			System.out.println("( 맞으면 +5포인트, 틀리거나 힌트를 사용하면 -1포인트 )");
			System.out.println("-".repeat(line));
			System.out.println("1. Game start 🕹");
			System.out.println("2. 점수 불러오기");
			System.out.println("QUIT : Good Game");
			System.out.println("=".repeat(line));
			System.out.print("메뉴를 입력하세요 >> ");
			String strMenu = scan.nextLine();
			if (strMenu.equals("QUIT")) {
				System.out.print("이름을 입력하세요 >> ");
				name = scan.nextLine();
				this.loadPoint(point);
				continue;
			}

			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("❌ 업무는 1, 2, QUIT만 입력하세요 ❌");
			}
			if (intMenu < 1 || intMenu > 2) {
				System.out.println("❌ 업무는 1, 2, QUIT만 입력하세요 ❌");
				continue;
			}
			if (intMenu == 1) {
				this.viewWord();
				continue;
			} else if (intMenu == 2) {
				this.importPoint(name, point);
				
			}

			return intMenu;
		} // end while

	} // end selectMenu

	@Override
	public void loadWord() {
		// TODO word.txt 파일을 읽어서 wordList 데이터 생성
		String wordFile = "src/com/callor/word/word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(wordFile);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;
				String[] words = reader.split(":");

				WordVO wordVO = new WordVO();
				wordVO.setEnglish(words[영어]);
				wordVO.setKorea(words[한글]);
				wordList.add(wordVO);
			} // end while
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("파일을 여는동안 문제가 생겼습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("파일에서 데이터를 읽는 중에 문제가 생겼습니다.");
		} // end try - catch

	} // end loadWord

	@Override
	public WordVO getWord() {
		// TODO wordList에 담긴 데이터.

		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);

		WordVO wordVO = wordList.get(num);

		return wordVO;
	} // end getWord

	@Override
	public void viewWord() {
		// TODO 단어 알파벳 단위로 끊어서 화면에 단어 출력

		while (true) {

			WordVO wordVO = this.getWord();

			String strEng = wordVO.getEnglish();
			String[] wordSp = strEng.split("");

			for (int i = 0; i < strEng.length(); i++) {
				int spell1 = rnd.nextInt(wordSp.length);
				int spell2 = rnd.nextInt(wordSp.length);

				String temp = wordSp[spell1];
				wordSp[spell1] = wordSp[spell2];
				wordSp[spell2] = temp;
			} // end for

			while (true) {
				System.out.println("=".repeat(line));
				System.out.println("제시된 알파벳들을 영단어에 맞게 바르게 배열하세요. ( Quit : 게임 종료 )");
				System.out.println(Arrays.toString(wordSp));
				System.out.println("=".repeat(line));
				System.out.print(" >> ");
				String answer = scan.nextLine();
				if (answer.equals("Quit")) {
					return;
				} // end if
				if (answer.equalsIgnoreCase(wordVO.getEnglish())) {
					System.out.println("정답입니다!");
					System.out.println(" + 5point ");
					point += 5;
					System.out.println("현재 포인트 : " + point);
					break;

				} else {
					this.wrong(wordVO);
					nCount++;
					if(nCount >= 3) {
						break;
					}
					continue;
				} // end if-else
			}

		} // end while

	} // end viewWord

	@Override
	public void wrong(WordVO word) {
		// TODO 첫 번째 틀렸을 경우 - 재도전, hint, skip 선택 가능

		System.out.println("=".repeat(line));
		System.out.println(" 틀렸습니다.! ");
		System.out.println("-".repeat(line));

		while (true) {
			System.out.println("1. 재도전 🔁");
			System.out.println("2. Skip ⏩");
			System.out.println("3. Hint");
			System.out.println("=".repeat(line));
			System.out.print(" >> ");
			String strNum = scan.nextLine();
			Integer intNum = Integer.valueOf(strNum);

			if (intNum == 1) {
				if (nCount < 3) {
					return;
				}
				break;
			} else if (intNum == 2) { // Skip
				
				point -= 1;
				System.out.println("포인트 : " + point);
				
				return; // skip은 다음 문제로
				
			} else if (intNum == 3) {
				System.out.println("Hint 입력 시 보여드립니다. - 포인트 감점 예정");
				System.out.print(" >> ");
				String strHint = scan.nextLine();
				if (strHint.equals("Hint")) {
					System.out.println("Hint : " + word.getKorea());
					point -= 1;
					System.out.println("포인트 : " + point);
				}
			} else {
				System.out.println(" ❌ 1, 2만 입력하세요 ❌");
				continue;
			}
		} // while end
	}

	@Override
	public void loadPoint(int point) {
		// TODO 포인트 점수 파일을 저장하기

		String pointFile = "src/com/callor/word/" + name + "point.txt";

		FileWriter fileWriter = null;
		PrintWriter out = null;

		try {
			fileWriter = new FileWriter(pointFile);
			out = new PrintWriter(fileWriter);

			for (int i = 0; i < wordList.size(); i++) {
				WordVO vo = wordList.get(i);
				out.println(point);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void importPoint(String name, int point) {
		// TODO point.txt 파일 읽기.. 불러오기
		
		System.out.print("이름 입력 >> ");
		name = scan.nextLine();
		
		String pointFile = "src/com/callor/word/" + name + "point.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(pointFile);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;
				point = Integer.valueOf(reader);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
