package com.callor.word;

import com.callor.word.service.WordService;
import com.callor.word.service.impl.WordServiceImplV1;

public class WordEx {

	public static void main(String[] args) {
		
		WordService word = new WordServiceImplV1();
		word.selectMenu();
	}
}
