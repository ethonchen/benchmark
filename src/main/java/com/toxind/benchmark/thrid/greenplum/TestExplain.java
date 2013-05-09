package com.toxind.benchmark.thrid.greenplum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExplain {

	private static String driverName = "org.postgresql.Driver";

	/**
	 * @param args
	 * @throws SQLException
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:postgresql://10.20.151.57:5432/aligputf8?charSet=UTF-8", "etl", "etl");
		Statement stmt = con.createStatement();

		String sql = null;
		ResultSet res = null;
		sql = "explain select * from pg_tables";

		System.out.println("Running: " + sql);

		res = stmt.executeQuery(sql);

		while(res.next()){
			System.out.println(res.getObject(1));
		}
	
	}
}
