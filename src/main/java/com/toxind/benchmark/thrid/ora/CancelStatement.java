package com.toxind.benchmark.thrid.ora;

import java.sql.SQLException;

public class CancelStatement extends Thread{

	@Override
	public void run() {
		System.out.println("============Cancel===============");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true){
			System.out.println("===============Loop===========");
			try {
				OracleClient.stmt.cancel();
				break;
			} catch (SQLException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
