package com.toxind.benchmark.jvm.menifest;

public class Test {

	public static void main(String[] args) {
		Class cls = new Test().getClass();
        // 首先查找MANIFEST.MF规范中的版本号  
        String version = cls.getPackage().getImplementationVersion();  
        System.out.println(version);
        if (version == null || version.length() == 0) {  
            version = cls.getPackage().getSpecificationVersion();  
            System.out.println(version);
        }  
        System.out.println(cls.getPackage());
        if (version == null || version.length() == 0) {  
            // 如果MANIFEST.MF规范中没有版本号，基于jar包名获取版本号  
            String file = cls.getProtectionDomain().getCodeSource().getLocation().getFile();  
            System.out.println(file);
        } 
	}

}
