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

public class CliTestStop {

	public static void main(String[] args) throws IOException, InterruptedException {
		String jobId = "job_201111132146_0106";
	  String[] execStr = new String[]{"ssh","admin@192.168.35.129","\"source /home/admin/.bash_profile;/home/admin/hadoop-0.20.2/bin/../bin/hadoop job  -Dmapred.job.tracker=node1:9001 -kill "+jobId+"\""};

      Process proc = Runtime.getRuntime().exec(execStr);
//      new StreamConsumer(proc.getErrorStream(), System.out , true).start();
//      new StreamConsumer(proc.getInputStream(), System.out , false).start();

      System.out.println(proc.waitFor());
      System.out.println("---STOP---");
      
	
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
