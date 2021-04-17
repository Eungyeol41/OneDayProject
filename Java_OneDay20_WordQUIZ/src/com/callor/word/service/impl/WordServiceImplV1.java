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
	public void selectMenu() {
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
				System.out.println("게임이 종료됩니다");
				break;
			}

			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("❌ 메뉴는 1, 2, QUIT만 입력하세요 ❌");
				continue;
			}
			if (intMenu < 1 || intMenu > 2) {
				System.out.println("❌ 업무는 1, 2, QUIT만 입력하세요 ❌");
				continue;
			}
			if (intMenu == 1) {
				try {
					this.viewWord(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (intMenu == 2) {
				Integer loadPoint = this.importPoint(); // 파일에서 point 불러오기
				try {
					this.viewWord(point); // point 넣어서 게임 시작
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
	public void viewWord(int point) {
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
					System.out.println("게임을 끝냅니다.");
					System.out.println("저장을 하시겠습니까?");
					System.out.println("1을 누르면 저장하기 / 2를 누르면 그냥 끝냅니다.");
					System.out.print(" >> ");
					Integer endNum = scan.nextInt();
					if(endNum == 1) { // 1 : 이름 저장 후 point 저장 method로 이동  / 2 : 끝내기
						System.out.println("저장할 이름을 입력해주세요");
						System.out.print(" >> ");
						name = scan.nextLine();
						this.loadPoint(name, point);
						System.out.println("저장이 완료되었습니다.");
						return;
					} else return;
				
				} // end if
				if (answer.equalsIgnoreCase(wordVO.getEnglish())) {
					System.out.println("정답입니다!");
					System.out.println(" + 5point ");
					point += 5;
					System.out.println("현재 포인트 : " + point);
					break;

				} else {
					System.out.println(" 틀렸습니다.");
					Integer wNum = this.wrong(wordVO, point);
					if (wNum == 1) {
						nCount++;
						if (nCount >= 3) {
							break;
						}
						continue;
					} else if (wNum == 2) {
						point -= 2;
						break;
					} else if (wNum == 3) {
						continue;
					}

				} // end 정답 / 오답
			} // end while

		} // end while (알파벳 무작위 배열 및 문제 출제)

	} // end viewWord

	@Override
	public Integer wrong(WordVO word, int point) {
		// TODO 첫 번째 틀렸을 경우 - 재도전, hint, skip 선택 가능

		while (true) {
			System.out.println("1. 재도전 🔁 ( 3번 가능하고 point -1 ) ");
			System.out.println("2. Skip ⏩ ( point -2 )");
			System.out.println("3. Hint ( point -1 )");
			System.out.println("=".repeat(line));
			System.out.print(" >> ");
			String strNum = scan.nextLine();
			Integer intNum = Integer.valueOf(strNum);

			if (intNum == 1) {
				if (nCount == 3) {
					System.out.println("재도전은 3번까지! 가능합니다.");
					continue;
				} else if (nCount < 3) {
					return 1;
				} else if (point <= 0) {
					System.out.println("point가 부족합니다..");
					continue;
				} // 재도전일 경우 ( 횟수가 3이면 불가 문구 나타내고 3보다 작으면 1을 return해서 viewWord() method에서 이용
					// point가 0 이하일 경우 도전 불가 문구
			} else if (intNum == 2) {

				if (point <= 0) {
					System.out.println("point가 부족합니다..");
					continue;
				}
				return 2; // Skip다음 문제로 넘어가기 / point가 없으면 불가능.

			} else if (intNum == 3) {
				System.out.println("Hint 입력 시 보여드립니다. - 포인트 감점 예정");
				System.out.print(" >> ");
				String strHint = scan.nextLine();
				if (point <= 0) {
					System.out.println("💣 0포인트 이하는 Hint를 보여드릴 수 없습니다 💣");
					continue;
				} else if (strHint.equals("Hint")) {
					System.out.println("Hint : " + word.getKorea());
					point -= 1;
					System.out.println("포인트 : " + point);
				} // Hint
			} else {
				System.out.println(" ❌ 1, 2만 입력하세요 ❌");
				continue;
			}
		} // while end
	}

	@Override
	public void loadPoint(String name, int point) {
		// TODO 포인트 점수 파일을 저장하기

		String pointFile = "src/com/callor/word/" + name + "point.txt";

		FileWriter fileWriter = null;
		PrintWriter out = null;

		try {
			fileWriter = new FileWriter(pointFile);
			out = new PrintWriter(fileWriter);

			out.print(point);
			
			out.flush();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer importPoint() {
		String name;
		// TODO point.txt 파일 읽기.. 불러오기

		System.out.print("이름 입력 >> ");
		name = scan.nextLine();

		String pointFile = "src/com/callor/word/" + name + "point.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(pointFile);
			buffer = new BufferedReader(fileReader);

			String point = buffer.readLine();
			
			buffer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer intPoint = Integer.valueOf(point);
		
		System.out.println(name + "님의 현재 보유 포인트 : " + point);
		
		return intPoint;

	}

}
