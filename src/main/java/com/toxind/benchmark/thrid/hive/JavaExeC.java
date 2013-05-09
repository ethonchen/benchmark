package com.toxind.benchmark.thrid.hive;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaExeC {
	public static void main(String args[]) {
	    try {
	    	System.out.println(System.getProperty("file.encoding"));
	      Runtime rt = Runtime.getRuntime();
	      Process proc = rt.exec("ipconfig");
	      InputStream stderr = proc.getInputStream();
	      InputStreamReader isr = new InputStreamReader(stderr);
	      BufferedReader br = new BufferedReader(isr);
	      String line = null;
	      System.out.println("<ERROR>");
	      while ((line = br.readLine()) != null)
	        System.out.println(line);
	      System.out.println("</ERROR>");
	      int exitVal = proc.waitFor();
	      br.close();
	      System.out.println(stderr == null);
	      System.out.println(br == null);
	      
	      System.out.println("Process exitValue: " + exitVal);
	    } catch (Throwable t) {
	      t.printStackTrace();
	    }
	}
}
