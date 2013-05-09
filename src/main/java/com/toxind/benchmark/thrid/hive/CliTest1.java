package com.toxind.benchmark.thrid.hive;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;

public class CliTest1 {

	public static void main(String[] args) throws IOException {
		String[] execStr = new String[]{"ssh","admin@192.168.35.129","\"source /home/admin/.bash_profile;hive -e 'set hive.cli.print.header=true;show tables'\""};

		Process proc = Runtime.getRuntime().exec(execStr);
	  	
	  	
	}
		
 
}
