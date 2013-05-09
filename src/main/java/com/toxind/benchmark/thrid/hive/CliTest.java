package com.toxind.benchmark.thrid.hive;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CliTest {

	public static void main(String[] args) throws IOException, InterruptedException {
//		runCommand(new String[]{"/home/admin/hive-0.7.0/bin/hive","-e","'select 1,a.* from pokes a'"});
		
//	  String[] execStr = new String[]{"hive","-e" ,"select 1,a.* from pokes a"};
//		String[] execStr = new String[]{"hive","-e" ,"set -v"};
//	  String[] execStr = new String[]{"ssh","admin@192.168.35.129","\"source /home/admin/.bash_profile;hive -e 'set hive.cli.print.header=true;select col_a_1,* from abc_test'\""};
	  String[] execStr = new String[]{"ssh","admin@192.168.35.129","source /home/admin/.bash_profile;hive -e \"set hive.cli.print.header=true;show tables\""};
//		String[] execStr = new String[]{"ssh","admin@192.168.35.129","\"source /home/admin/.bash_profile;hive \""};
//	  String[] command = {"select count(*) from abc_test1;","select count(*) from pokes"};
      Process proc = Runtime.getRuntime().exec(execStr);
      new StreamConsumer(proc.getErrorStream(), System.out , true).start();
      new StreamConsumer(proc.getInputStream(), System.out , false).start();
      Thread.sleep(5000);
      System.out.println("exit code : " + proc.waitFor());
//      System.out.println("------destroy---------");
//      proc.destroy();
//	  BufferedReader errReader = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
//	  BufferedReader stdReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//	  PrintWriter pw = new PrintWriter(proc.getOutputStream());
//	  for(String cmd : command){
//		  pw.println(cmd);
//		  pw.flush();
//		  String errStr = errReader.readLine();
//		  while(errStr != null){
//			  System.out.println(" --> " + errStr);
//			  errStr = errReader.readLine();
//		  }
//		  String stdStr = stdReader.readLine();
//		  while(errStr != null){
//			  System.out.println(stdStr);
//			  errStr = stdReader.readLine();
//		  }
//
//	  }
//      pw.println();
//      pw.flush();
//      pw.println("select count(*) from abc_test1;");
//      pw.flush();
//      pw.println("select *,1 from pokes;");
//      pw.flush();
//	  errReader.close();
//	  stdReader.close();
//      pw.close();
      System.out.println("---Q---");
	
	}

	  
	  static class StreamConsumer extends Thread {
private boolean isError;
		    StreamConsumer(InputStream in, OutputStream out , boolean isError) {
		      this.bin = new LineNumberReader(new BufferedReader(new InputStreamReader(in)));
		      this.isError = isError;
		      if (out != null) {
		        this.bout = new DataOutputStream(out);
		      }
		    }

		    public void run() {
		      try {
		        String line;
		        while ((line = bin.readLine()) != null) {
//		          if (bout != null) {
//		            bout.writeUTF(line); //writeChars
//		            bout.writeChar('\n');
		        	  System.out.println((isError?" ----> ":" ") + line);
//		          }
		        }
		        bout.flush();		        
		      } catch (IOException io) {
		      }
		    }

		    LineNumberReader bin;
		    DataOutputStream bout;
		  }
}
