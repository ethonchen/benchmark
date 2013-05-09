package com.toxind.benchmark.thrid.proto1;
/*package com.taobao.ethon.thrid.proto1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.proto.Bean.Obj;

public class TestBean {

	@Test
	public void testOutput() throws FileNotFoundException, IOException{
		Bean.Obj.Builder build = Obj.newBuilder();
		System.out.println(((int)'a')+" " + ((int)'@') + " " +((int)'b'));
		System.out.println(Integer.toHexString(((int)'a'))+" " + Integer.toHexString(((int)'@')) + " " +Integer.toHexString(((int)'b')));
		int id = 15;
		System.out.println(Integer.toHexString(id));
		build.setId(id);
		build.setName("a@x");
		Obj obj = build.build();
		System.out.println(obj);
		obj.writeTo(new FileOutputStream(new File("src/main/java/com/proto/obj.prodata")));
	}
}
*/