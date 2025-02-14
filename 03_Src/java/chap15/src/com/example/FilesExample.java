package com.example;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilesExample {
	// File class / Files class
	public static void main(String[] args) {
		File f = new File("object.bin");
		
		System.out.println(f.exists());		// file 존재 확인
		System.out.println(f.getName());	// file name 	
		System.out.println(f.getParent());	// file parant check
		System.out.println(f.getAbsolutePath());	// file 절대경로
		System.out.println(f.length());				// file 길이
		System.out.println(f.lastModified()); 	// 수정된날짜 epoch time 
		Date modifiled = new Date (f.lastModified());	// 수정된 날짜를 modifiled로 저장 . 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	// 포맷식 설정
		System.out.println(df.format(modifiled));	// 수정된 날짜를 포맷으로 출력. 
		
	}
}
