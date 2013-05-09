package com.toxind.benchmark.thrid.ora;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleClient2 {
public static Statement stmt;
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.20.151.54:1521:ctrtest", "dwarch", "dwarch");
System.out.println(System.getProperty("file.encoding"));
		String sql = null;
		sql = "insert into a_a1 values (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, new String("斯发".getBytes("gbk"),"ISO-8859-1"));
		ps.execute();
		System.out.println("Running: " + sql);
		
		ResultSet rs = con.prepareStatement("select * from a_a1").executeQuery();
		while(rs.next()){
			System.out.println(new String(rs.getString(1).getBytes("ISO-8859-1"),"gbk"));
		}

	}
}
