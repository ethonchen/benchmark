package com.toxind.benchmark.jvm.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TestIO {

	public static void main(String[] args) throws InterruptedException {
//		File f = new File("d:/1.txt");
//		new WriteFile(f,"a").start();
//		new WriteFile(f,"b").start();
//		Thread.sleep(3500);
//		new ReadFile(f).start();
		
		String xx = "jdbc:hive://172.16.198.41:8080/default";
		String tmp = xx.substring(xx.indexOf("://")+3);
		System.out.println(xx.substring(xx.indexOf("://")+3));
		System.out.println(tmp.substring(0,tmp.indexOf(":")));
	}
	
	static class WriteFile extends Thread{
		File f;
		String bid;
		WriteFile(File f,String bid){
			this.f = f;
			this.bid = bid;
		}
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(f);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			for(int i=0;i<1000;i++){
//				System.out.print(" write : " + i);
				try {
					
					pw.print(i + bid);
					pw.flush();
//					pw.close();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	static class ReadFile extends Thread{
		File f;
		ReadFile(File f){
			this.f = f;
		}
		@Override
		public void run() {
			for(int i=0;i<1000;i++){		
//				System.out.print(" read : " + i);
				try {
					BufferedReader br = new BufferedReader(new FileReader(f));
					String line = br.readLine();
					while(line!=null){
						System.out.println(line);
						line = br.readLine();
					}
					br.close();
					Thread.sleep(500);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
