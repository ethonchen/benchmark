package com.toxind.benchmark.thrid.ora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleClient {
public static Statement stmt;
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.20.151.54:1521:ctrtest", "dwarch", "dwarch");
		stmt = con.createStatement();
//		new CancelStatement().start();
//		stmt.addBatch("drop table toxind_test_tab1");
//		stmt.addBatch("create table toxind_test_tab1 as select * from tests_contact_2011_9_21");
//		stmt.executeBatch();
		
		// regular hive query
		String sql = null;
		ResultSet res = null;
//		sql = "update t_tab1 set var1 = 'abc' where var2 like 'var%'";
		sql = "select * from t_tab1";
		System.out.println("Running: " + sql);
		boolean bid = stmt.execute(sql);
		
		sql = "update t_tab1 set var1 = 'abc' where var2 like 'var%'";
		System.out.println("Running: " + sql);
		bid = stmt.execute(sql);	

		if(bid){
			res = stmt.getResultSet();
			while(res.next()){
				System.out.println(res.getObject(2));
			}
		}else{
			System.out.println("effected : " + stmt.getUpdateCount());
		}
		
		
//		ResultSetMetaData rsmd = res.getMetaData();
//		System.out.println(rsmd.getColumnCount());
//		System.out.println(rsmd.getColumnTypeName(1));
		
//		while (res.next()) {
//			System.out.println(res.getString(1));
//		}
	}

}
