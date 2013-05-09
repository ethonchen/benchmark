package com.toxind.benchmark.thrid.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbcClient2 {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:hive://172.16.198.41:8080/default", "root", "root");
		Statement stmt = con.createStatement();
		String tableName = "testHiveDriverTable";
		


		// regular hive query
		String sql = null;
		ResultSet res = null;
//		sql = "create table test_ttt_zw_1 (a int , b string)";
		sql = "insert into test_ttt_zw_1 valuse (1,'aaa')";
//		sql = "select count(1) from " + tableName;
//		sql = "show tables 't*'";
//		sql = "describe testHiveDriverTable";
//		sql = "select t.*,1 from tests_contact_2011_10_10 t limit 10";
		System.out.println("Running: " + sql);
		
		stmt.execute(sql);
		
//		res = stmt.executeQuery(sql);
//		
//		while (res.next()) {
//			System.out.println(res.getString(1));
//			stmt.close();
//		}
	}
}