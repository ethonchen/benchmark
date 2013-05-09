package com.toxind.benchmark.thrid.charset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestCharset {

	public static void main(String[] args) throws IOException {
		String str = "这是一段中文";
		
		BufferedWriter bwToGbk = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk"));
		bwToGbk.write(str);
		bwToGbk.close();
		
		BufferedReader brFromGbk = new BufferedReader(new InputStreamReader(new FileInputStream("gbk.txt"),"gbk"));
		String gbkStr = brFromGbk.readLine();
		System.out.println(gbkStr);
		brFromGbk.close();
		
		BufferedWriter bwToUTF8 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("utf-8.txt"), "utf-8"));
		bwToUTF8.write(gbkStr);
		bwToUTF8.close();
		
		BufferedReader brFromUTF8 = new BufferedReader(new InputStreamReader(new FileInputStream("utf-8.txt"),"utf-8"));
		String gbkUtf8 = brFromUTF8.readLine();
		System.out.println(gbkUtf8);
		brFromUTF8.close();
		
	}

}
