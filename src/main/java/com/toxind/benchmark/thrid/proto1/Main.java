package com.toxind.benchmark.thrid.proto1;
//package com.taobao.ethon.thrid.proto1;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.junit.Test;
//
//import com.proto.Person.Tom;
//
//public class Main {
//
//	@Test
//	public void testOutput() throws FileNotFoundException, IOException{
//		Tom.Builder t = Tom.newBuilder();
//		System.out.println(((int)'a')+" " + ((int)'@') + " " +((int)'b'));
//		System.out.println(Integer.toHexString(((int)'a'))+" " + Integer.toHexString(((int)'@')) + " " +Integer.toHexString(((int)'b')));
//		t.setEmail("a@b");
//		t.setId(1);
//		t.setName("xxxx");
//		Tom tom = t.build();
//		System.out.println(tom);
//		tom.writeTo(new FileOutputStream(new File("src/main/java/com/proto/tom2.prodata")));
//	}
//}
