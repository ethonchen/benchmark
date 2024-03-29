package com.toxind.benchmark.thrid.ibatis.ibatis.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public final class SqlMapConfigUtils {
	
	@SuppressWarnings("unchecked")
	public static List <FileDesc> readSqlMapFileMapping(String sqlMapConfig) {
		try {
			File f = new File(sqlMapConfig);
			InputStream is = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			SAXBuilder builder = new SAXBuilder();
			builder.setEntityResolver(new NoOpEntityResolver());
			Document doc = builder.build(isr);
			Element root = doc.getRootElement();
			List list = root.getChildren("sqlMap");
			List <FileDesc> retList = new ArrayList<FileDesc>();
			for(Iterator it = list.listIterator(); it.hasNext(); ) {
				Element e = (Element) it.next();
				String loc = e.getAttribute("resource").getValue();
				URL url = SqlMapConfigUtils.class.getClassLoader().getResource(loc);
				File file= new File(url.getFile());
				long lastTm = file.lastModified();
				FileDesc fd = new FileDesc(file.getAbsolutePath(), lastTm);
				retList.add(fd);
			}
			return retList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<FileDesc>();
	}
	
	public static List <String> readSqlMap(FileDesc fd) {
		try {
			String path = fd.getPath();
			InputStream is = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			SAXBuilder builder = new SAXBuilder();
			builder.setEntityResolver(new NoOpEntityResolver());
			Document doc = builder.build(isr);
			Element root = doc.getRootElement();
			String namespace = null;
			if ( root.getAttribute("namespace") != null) {
				namespace =  root.getAttribute("namespace").getValue();
			}
			List list = root.getChildren();
			List <String> retList = new ArrayList<String>();
			for(Iterator it = list.listIterator(); it.hasNext(); ) {
				Element e = (Element) it.next();
				String tagName = e.getName();
				if ("statement".equals(tagName) || "insert".equals(tagName)
						|| "update".equals(tagName) || "delete".equals(tagName)
						|| "select".equals(tagName)
						|| "procedure".equals(tagName)) {
					String id = e.getAttribute("id").getValue();
					if ( namespace != null ) {
						id = namespace + "." + id;
					}
					retList.add(id);
				}
			}
			return retList;
		} catch (UnsupportedEncodingException e) {
		} catch (JDOMException e) {
		} catch (IOException e) {e.printStackTrace();
		}
		
		return new ArrayList<String>();
	}
}
