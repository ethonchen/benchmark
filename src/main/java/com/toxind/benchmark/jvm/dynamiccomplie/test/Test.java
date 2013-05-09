/*
 * Copyright 2013 dxp.alibaba-inc.com All right reserved. This software is the
 * confidential and proprietary information of dxp.alibaba-inc.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with dxp.alibaba-inc.com.
 */
package com.toxind.benchmark.jvm.dynamiccomplie.test;

import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

import com.toxind.benchmark.jvm.dynamiccomplie.CharSequenceCompiler;
import com.toxind.benchmark.jvm.dynamiccomplie.CharSequenceCompilerException;

/**
 * 类Test.java的实现描述：TODO 类实现描述 
 * @author ethon.chenf 2013-2-19 上午10:33:52
 */
public class Test {
    private final static CharSequenceCompiler<A> compiler = new CharSequenceCompiler<A>(
            null, Arrays.asList(new String[] { "-target", "1.5" }));
    /**
     * @param args
     * @throws CharSequenceCompilerException 
     * @throws ClassCastException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static void main(String[] args) throws ClassCastException, CharSequenceCompilerException, InstantiationException, IllegalAccessException {
            // generate semi-secure unique package and class names
            final String packageName = "com.pack";
            final String className = "Main1Xfffffff";
            final String qName = packageName + '.' + className;
            // generate the source class as String
            final String source = "package com.pack;public class Main1Xfffffff implements javaxtools.compiler.test.A  { public void abc() {System.out.println(\"Hello World!\");} }";
            // compile the generated Java source
            final DiagnosticCollector<JavaFileObject> errs = new DiagnosticCollector<JavaFileObject>();
            Class<A> compiledFunction = compiler.compile(qName, source, errs,
                                                         new Class<?>[] { A.class });
            A a = compiledFunction.newInstance();
            a.abc();
    }

}
