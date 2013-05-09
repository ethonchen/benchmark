/*
 * Copyright 2013 dxp.alibaba-inc.com All right reserved. This software is the
 * confidential and proprietary information of dxp.alibaba-inc.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with dxp.alibaba-inc.com.
 */
package com.toxind.benchmark.jvm.dynamiccomplie.other;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;



public class TestDyCompile {

    /**
     * 
     * @author ZhangXiang
     * @param args
     * 2011-4-7
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws SecurityException 
     * @throws IllegalArgumentException 
     */
    public static void main(String[] args) throws IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {
        
        StringBuilder classStr = new StringBuilder("package dyclass;public class Foo{");
        classStr.append("public void test(){");
        classStr.append("System.out.println(\"Foo2\");}}");
        
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = jc.getStandardFileManager(null, null, null);
        Location location = StandardLocation.CLASS_OUTPUT;
        File[] outputs = new File[]{new File("D:/CodeProject/ToxinD/test-export/target/classes")};
        try {
            fileManager.setLocation(location, Arrays.asList(outputs));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JavaFileObject jfo = new JavaSourceFromString("dyclass.Foo", classStr.toString());
        JavaFileObject[] jfos = new JavaFileObject[]{jfo};
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(jfos);
        boolean b = jc.getTask(null, fileManager, null, null, null, compilationUnits).call();
        if(b){//如果编译成功
            try {
                Object c =  Class.forName("dyclass.Foo").newInstance();
                Class.forName("dyclass.Foo").getMethod("test").invoke(c);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}



 class JavaSourceFromString extends SimpleJavaFileObject {

    /**
     *  源码
     */
    final String code;

    /**
     * 构造方法：从字符串中构造一个FileObject
     * @param name the name of the compilation unit represented by this file object
     * @param code the source code for the compilation unit represented by this file object
     */
    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),
              Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}



