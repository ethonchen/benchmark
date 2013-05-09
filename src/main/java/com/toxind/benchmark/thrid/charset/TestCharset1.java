package com.toxind.benchmark.thrid.charset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class TestCharset1 {

	public static void main(String[] args) throws IOException {
		char c = '是';
		System.out.println(c);
		System.out.println((char)(c+"").getBytes()[0]);
		System.out.println(Arrays.toString((c+"").getBytes()));
		byte[] b = {};
		
		
	}

}
