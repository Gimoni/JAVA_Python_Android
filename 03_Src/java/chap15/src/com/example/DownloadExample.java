package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
// 인터넷에서의 텍스트 문서 다운로드. 
public class DownloadExample {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.w3schools.com");
		
		var conn = (HttpsURLConnection)url.openConnection();
		
		InputStream in = conn.getInputStream();
		
		FileOutputStream html = new FileOutputStream("img/w3.html");
		
		
	
		while(true) {
			int b = in.read();
			if (b<0)
				break;
			System.out.print((char)b);
			html.write(b);
		}
		html.close();
		
		conn.disconnect();
		System.out.println("End....");
	}
}
