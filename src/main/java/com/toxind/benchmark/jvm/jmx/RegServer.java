package com.toxind.benchmark.jvm.jmx;

import java.lang.management.ManagementFactory;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;


public class RegServer {

	public static void main(String[] args) throws MalformedObjectNameException, NullPointerException, InstanceAlreadyExistsException, NotCompliantMBeanException, InstanceNotFoundException, ReflectionException, MBeanException, InterruptedException, AttributeNotFoundException {
        // 创建MBeanServer  
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
          
        // 新建MBean ObjectName, 在MBeanServer里标识注册的MBean  
        ObjectName name = new ObjectName("org.alibaba.inc:type=Print111,id=123");            
        // 创建MBean  
        Print mbean = new Print("bean1");            
        // 在MBeanServer里注册MBean, 标识为ObjectName(com.tenpay.jmx:type=Echo)  
        mbs.registerMBean(mbean, name);  
  
          
        // 在MBeanServer里调用已注册的EchoMBean的print方法  
        //mbs.invoke(name, "something", new Object[] { "haitao.tu"}, new String[] {"java.lang.String"});  
        System.out.println(mbs.getAttribute(name, "Xxa").getClass());
        System.out.println(mbs.getAttribute(name, "Yy").getClass());
        
        //new mbean
        // 新建MBean ObjectName, 在MBeanServer里标识注册的MBean  
        ObjectName name1 = new ObjectName("org.alibaba.inc:type=Print111,id=223");            
        // 创建MBean  
        Print mbean1 = new Print("bean1");            
        // 在MBeanServer里注册MBean, 标识为ObjectName(com.tenpay.jmx:type=Echo)  
        mbs.registerMBean(mbean1, name1);  
        
        Thread.sleep(Long.MAX_VALUE);  
	}
}
