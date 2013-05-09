package com.toxind.benchmark.thrid.hive;
//package com.taobao.ethon.thrid.hive;
//
//import java.lang.reflect.Field;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//public class HiveJdbcClient1 {
//	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
//
//	/**
//	 * @param args
//	 * @throws SQLException
//	 */
//	@SuppressWarnings("rawtypes")
//	public static void main(String[] args) throws SQLException {
//		try {
//			Class.forName(driverName);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.exit(1);
//		}
//		Connection con = DriverManager.getConnection("jdbc:hive://172.16.198.41:8080/default", "root", "root");
//		Statement stmt = con.createStatement();
//		String tableName = "testHiveDriverTable";
//		
////		stmt.addBatch("drop table toxind_test_tab1");
////		stmt.addBatch("create table toxind_test_tab1 as select * from tests_contact_2011_9_21");
////		stmt.executeBatch();
//		
//		// regular hive query
//		String sql = null;
//		ResultSet res = null;
//		sql = "select count(1) from " + tableName;
//		sql = "show tables";
//		sql = "describe testHiveDriverTable";
//		sql = "select * from toxind_test_tab1 limit 0";
//		sql = "select '啊好哦' from dual";
//		System.out.println("Running: " + sql);
////		stmt.execute("add jar /home/dwdev/hiveUDF.jar");
////		stmt.execute("create temporary function zleng as 'z.udf.Length'");
//		sql = "select zleng(not_exist) from dual";
//		sql = "explain select count(*) from yongwei_order_by";
////		sql = "list jar";
//		res = stmt.executeQuery(sql);
////		ExplainSemanticAnalyzer.
//		System.out.println(res.getClass());
//		HiveQueryResultSet hrs = (HiveQueryResultSet)res;
//		System.out.println(hrs.wasNull());
//		System.out.println(hrs.next());
//		
//		try {
//			
//			Field fetchedRows = hrs.getClass().getDeclaredField("fetchedRows");
//			fetchedRows.setAccessible(true);
//			List list = (List)fetchedRows.get(hrs);
//			for(Object o : list){
//				System.out.println(o);
//			}
//			
////			System.out.println(Arrays.toString(list.toArray()));
//			
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		System.out.println(hrs.getRow());
////		while (res.next()) {
//			
////			System.out.println(res.getObject(1));
////		}
//		
//		ResultSetMetaData rsmd = res.getMetaData();
////		System.out.println(rsmd.getColumnCount());
////		System.out.println(rsmd.getColumnTypeName(1));
//	}
//}