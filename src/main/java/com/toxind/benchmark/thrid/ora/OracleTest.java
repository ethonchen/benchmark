package com.toxind.benchmark.thrid.ora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest {
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

		
		// regular hive query
		String sql = null;
		ResultSet res = null;
//		sql = "update t_tab1 set var1 = 'abc' where var2='var235'";
		sql = "select * from t_tab3;drop table t_tab3";
		System.out.println("Running: " + sql);
		
//		stmt.execute(sql);
		res = stmt.executeQuery(sql);	

		
		ResultSetMetaData rsmd = res.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnTypeName(1));
		
		while (res.next()) {
			System.out.println(res.getString(1));
		}
	}

}
