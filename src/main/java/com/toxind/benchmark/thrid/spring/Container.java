package com.toxind.benchmark.thrid.spring;

import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Container {

	@Autowired
	private List<AInterface> aaa;
	
	@Autowired
	private BBCInterface b;
	
	@Autowired(required=false)
	private List<String> sss;
	
	public void ame(){
		for(AInterface a : aaa){
			System.out.println(a.me());
		}
	}
	
	public void a(){
		System.out.println(b);
		System.out.println(b.a());
	}
	
	public void sss(){
		System.out.println(sss.size());
		for(String s:sss){
			System.out.println(s.toString());
		}
	}
	@Autowired(required=false)
	@Qualifier("dataSourceProperties")
	private Properties pp;
	
	public void xxds(){
		System.out.println(pp);
		if(null!=pp)
			for(Entry<Object, Object> e : pp.entrySet()){
				System.out.println(e.getKey() + " == " + e.getValue()) ;
			}
	}
}
