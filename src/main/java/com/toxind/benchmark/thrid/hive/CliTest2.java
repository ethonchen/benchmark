package com.toxind.benchmark.thrid.hive;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CliTest2 {

	public static void main(String[] args) throws IOException, InterruptedException {
	  String[] execStr = new String[]{"ssh","admin@192.168.35.129","source /home/admin/.bash_profile;hive -e \"set hive.cli.print.header=true;show tables\""};
System.out.println(System.getProperty("os.arch"));
//      Process proc = Runtime.getRuntime().exec("ssh admin@192.168.35.129 'source /home/admin/.bash_profile;hive -e \"add jar /home/admin/hiveUDF.jar;create temporary function zleng as \\'z.udf.Length\\';create table pokes2 as select *,\\'xxoo\\' from pokes;set hive.cli.print.header=true;select zleng(id),* from pokes2\"';");
	  Process proc = Runtime.getRuntime().exec("ssh admin@192.168.35.129 'source /home/admin/.bash_profile;hive -e \"set hive.cli.print.header=true;show tables \\'*ab*\\';\"'");
//	  System.out.println(Arrays.toString(execStr));
//	  Process proc = Runtime.getRuntime().exec(execStr);
      new StreamConsumer(proc.getErrorStream(), System.out , true).start();
      new StreamConsumer(proc.getInputStream(), System.out , false).start();
      System.out.println("exit code : " + proc.waitFor());

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
		        	  
		        	  if(!isError){
		        		  for(String s :line.split("\\t")){
		        			  System.out.print(s.concat(" <> "));
		        		  }
		        		  System.out.println();
		        	  }
		        	  else{
		        		  if(line.startsWith("Kill Command = ")){
		        			  System.out.println(" ===>>>>>" + line.substring("Kill Command = ".length()));
		        		  }
		        		  System.out.println((isError?" ----> ":" ") + line);
		        	  }
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
