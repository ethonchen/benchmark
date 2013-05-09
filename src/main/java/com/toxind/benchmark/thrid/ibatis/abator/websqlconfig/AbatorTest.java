package com.toxind.benchmark.thrid.ibatis.abator.websqlconfig;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.dao.DwWebsqlDatasourceConfigDAO;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.dao.DwWebsqlSqllogDAO;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.dao.XxXx1DAO;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.DwWebsqlDatasourceConfig;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.DwWebsqlDatasourceConfigExample;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.DwWebsqlSqllog;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.DwWebsqlSqllogExample;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.XxXx1;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.XxXx1Example;

public class AbatorTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ibatis/abator/websqlconfig/application.xml");
	private static Random random = new Random();
	private static volatile String tmp = "";
	
	public static void main(String[] args) {
//		DragoonClient.setUriStatEnable(false);     //用于 web访问中的 uri，默认关闭
//		DragoonClient.setLog4jStatEnable(true);    //用于Exception监控项的采集
//		DragoonClient.setNapoliStatEnable(false);  //napoli统计，如果使用了napoli的客户端，请开启
//		DragoonClient.setNapoliMQServerStatEnable(false); //napoli统计,如果使用了napoli客户端，请开启
//		DragoonClient.start("dy_sql");
		
		for(int i = 0 ; i < 1 ; i++){
			new Thread(new DataSourceConfig()).start();
			new Thread(new SQLlog()).start();
			new Thread(new XX()).start();
		}
	}

	static class DataSourceConfig implements Runnable{
		@Override
		public void run() {
			while(true){
				DwWebsqlDatasourceConfigDAO dao = (DwWebsqlDatasourceConfigDAO)ctx.getBean("dwWebsqlDatasourceConfigDAOImpl");
				DwWebsqlDatasourceConfigExample example = new DwWebsqlDatasourceConfigExample();
				example.createCriteria().andDsIdGreaterThan(new BigDecimal(random.nextInt()));
				List list = dao.selectByExample(example);
				for (Object o : list){
					DwWebsqlDatasourceConfig dsc = (DwWebsqlDatasourceConfig)o;
					tmp = dsc.getDsDisName();
					System.out.println(tmp);
				}
			}
		}		
	}
	static class SQLlog implements Runnable{
		@Override
		public void run() {
			while(true){
				DwWebsqlSqllogDAO dao = (DwWebsqlSqllogDAO)ctx.getBean("dwWebsqlSqllogDAOImpl");
				DwWebsqlSqllogExample example = new DwWebsqlSqllogExample();
				example.createCriteria().andDsIdGreaterThan(new BigDecimal(random.nextLong()));
				
				List list = dao.selectByExampleWithBLOBs(example);
				for (Object o : list){
					DwWebsqlSqllog dsc = (DwWebsqlSqllog)o;
					tmp = dsc.getDsName();
				}
			}
		}		
	}
	static class XX implements Runnable{
		@Override
		public void run() {
			while(true){
				XxXx1DAO dao = (XxXx1DAO)ctx.getBean("xxXx1DAOImpl");
				XxXx1Example example = new XxXx1Example();
				example.createCriteria().andCGreaterThan(new Date(random.nextLong()));
				
				List list = dao.selectByExample(example);
				for (Object o : list){
					XxXx1 dsc = (XxXx1)o;
					tmp = dsc.getD();
				}
			}
		}		
	}
}
