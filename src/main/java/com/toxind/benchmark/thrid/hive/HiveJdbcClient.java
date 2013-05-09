package com.toxind.benchmark.thrid.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbcClient {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:hive://10.16.14.64:10000/default", "root", "root");
		Statement stmt = con.createStatement();
		String tableName = "testHiveDriverTable";
		
//		stmt.execute("insert into testHiveDriverTable values (111,'abc1')");
//		stmt.execute("insert into testHiveDriverTable values (112,'abc2')");
//		stmt.execute("insert into testHiveDriverTable values (113,'abc3')");
		
		
//		stmt.executeQuery("drop table " + tableName);
//		ResultSet res = stmt.executeQuery("create table " + tableName
//				+ " (key int , value string)");
//		// show tables
////		String sql = "show tables '" + tableName + "'";
//		String sql = "show tables ";
//		System.out.println("Running: " + sql);
//		res = stmt.executeQuery(sql);
//		if (res.next()) {
//			System.out.println(res.getString(1));
//		}
//		// describe table
//		sql = "describe " + tableName;
//		System.out.println("Running: " + sql);
//		res = stmt.executeQuery(sql);
//		while (res.next()) {
//			System.out.println(res.getString(1) + "\t" + res.getString(2));
//		}
//
//		// load data into table
//		// NOTE: filepath has to be local to the hive server
//		// NOTE: /tmp/a.txt is a ctrl-A separated file with two fields per line
//		// String filepath = "c:/a.txt";
//		// sql = "load data local inpath '" + filepath + "' into table " +
//		// tableName;
//		// System.out.println("Running: " + sql);
//		// res = stmt.executeQuery(sql);
//
//		// select * query
//		sql = "select * from " + tableName;
//		System.out.println("Running: " + sql);
//		res = stmt.executeQuery(sql);
//		while (res.next()) {
//			System.out.println(String.valueOf(res.getInt(1)) + "\t"
//					+ res.getString(2));
//		}

		// regular hive query
		String sql = null;
		ResultSet res = null;
		sql = "select count(1) from " + tableName;
		sql = "show tables";
		sql = "describe testHiveDriverTable";
//		sql = "select t.*,1 from tests_contact_2011_10_10 t limit 10";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		
		
		while (res.next()) {
			System.out.println(res.getString(1));
			stmt.close();
		}
	}
}