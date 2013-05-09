package com.toxind.benchmark.thrid.ibatis.dynamic;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.util.ObjectUtils;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapParser;
import com.ibatis.sqlmap.engine.builder.xml.XmlParserState;

public class DynamicSqlMapClientFactoryBean extends SqlMapClientFactoryBean implements ApplicationContextAware{
	private SqlMapParser mapParser = null;
	private ApplicationContext applicationContext;
	
	public DynamicSqlMapClientFactoryBean() {
		super();
	}

	@Override
	protected SqlMapClient buildSqlMapClient(Resource[] configLocations,
			Resource[] mappingLocations, Properties properties)
			throws IOException {
		if (ObjectUtils.isEmpty(configLocations)) {
			throw new IllegalArgumentException(
					"At least 1 'configLocation' entry is required");
		}
		SqlMapClient client = null;
		SqlMapConfigParser configParser = new SqlMapConfigParser();
		
		for (int i = 0; i < configLocations.length; i++) {
			InputStream is = configLocations[i].getInputStream();
			try {
				client = configParser.parse(is, properties);
			} catch (RuntimeException ex) {
				throw new NestedIOException("Failed to parse config resource: "
						+ configLocations[i], ex.getCause());
			}
		}
		mapParser = SqlMapParserFactory.createSqlMapParser(configParser);
		client = new DynamicSqlMapClient(client, mapParser,configParser,configLocations,applicationContext);
		return client;
	}
	/**
	 * Inner class to avoid hard-coded iBATIS 2.3.2 dependency (XmlParserState class).
	 */
	private static class SqlMapParserFactory {

		public static SqlMapParser createSqlMapParser(SqlMapConfigParser configParser) {
			// Ideally: XmlParserState state = configParser.getState();
			// Should raise an enhancement request with iBATIS...
			XmlParserState state = null;
			try {
				Field stateField = SqlMapConfigParser.class.getDeclaredField("state");
				stateField.setAccessible(true);
				state = (XmlParserState) stateField.get(configParser);
			}
			catch (Exception ex) {
				throw new IllegalStateException("iBATIS 2.3.2 'state' field not found in SqlMapConfigParser class - " +
						"please upgrade to IBATIS 2.3.2 or higher in order to use the new 'mappingLocations' feature. " + ex);
			}
			return new SqlMapParser(state);
		}
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
