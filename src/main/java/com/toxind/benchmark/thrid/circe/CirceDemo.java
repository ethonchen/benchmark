package com.toxind.benchmark.thrid.circe;
//package com.circe;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.alibaba.circe.client.CirceData;
//import com.alibaba.circe.client.CirceDigestData;
//import com.alibaba.circe.client.CirceDigestService;
//import com.alibaba.circe.client.CirceService;
//import com.alibaba.circe.client.CirceSignData;
//import com.alibaba.circe.client.CirceSignService;
//
//public class CirceDemo {
//    static CirceService circeService;
//    static CirceSignService   circeSignService;
//    static CirceDigestService circeDigestService;
// 
//    private static void init() throws Exception {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "classpath*:com/circe/circe_client_demo.xml");
// 
//        circeService = (CirceService) applicationContext.getBean("circeService");
//        circeDigestService = (CirceDigestService) applicationContext.getBean("circeDigestService");
//        circeSignService = (CirceSignService) applicationContext.getBean("circeSignService");
//    }
// 
//    public static void main(String[] args) throws Exception {
//        init();
// 
//        System.out.println("===================CirceService sample======================");
// 
//        test_commonUse_circeService();
//        test_dataWithVersion_circeService();
// 
//        System.out.println("===================CirceSignService sample======================");
// 
//        test_commonUse_circeSignService();
//        test_dataWithVersion_circeSignService();
// 
//        System.out.println("==================CirceDigestService sample=====================");
//        test_commonUse_circeDigestService();
// 
//    }
// 
//    public static void test_commonUse_circeService() throws Exception {
//        // 准备数据
//        CirceData data1 = new CirceData();
//        data1.setKeyName("aeskey1");
//        data1.setText("PlainText");
// 
//        // 加密操作
//        CirceData encrypt = circeService.encrypt(data1);
//        System.out.printf("Key Name: %s, Secret Text: %s, Version: %d.\n", encrypt.getKeyName(),
//                encrypt.getText(), encrypt.getVersion());
// 
//        // 准备数据
//        CirceData data2 = new CirceData();
//        data2.setKeyName("aeskey1");
//        data2.setBytes(encrypt.getBytes());
//        data2.setVersion(encrypt.getVersion());
// 
//        // 解密操作
//        CirceData decrypt = circeService.decrypt(data2);
//        System.out.printf("Key Name: %s, Secret Text: %s, Version: %d.\n", decrypt.getKeyName(),
//                decrypt.getText(), decrypt.getVersion());
// 
//    }
// 
//    public static void test_dataWithVersion_circeService() throws Exception {
//        // 准备数据
//        CirceData data1 = new CirceData();
//        data1.setKeyName("aeskey1");
//        data1.setText("PlainText");
//        data1.setDataWithVersion(true);
// 
//        // 加密操作
//        CirceData encrypt = circeService.encrypt(data1);
//        System.out.printf("Key Name: %s, Secret Text: %s, Version: %d.\n", encrypt.getKeyName(),
//                encrypt.getText(), encrypt.getVersion());
// 
//        // 准备数据
//        CirceData data2 = new CirceData();
//        data2.setKeyName("aeskey1");
//        data2.setBytes(encrypt.getBytes());
//        // 没有进行设置版本的操作
//        data2.setDataWithVersion(true);
// 
//        // 解密操作
//        CirceData decrypt = circeService.decrypt(data2);
//        System.out.printf("Key Name: %s, Secret Text: %s, Version: %d.\n", decrypt.getKeyName(),
//                decrypt.getText(), decrypt.getVersion());
//    }
// 
//    public static void test_commonUse_circeSignService() throws Exception {
//        // 准备数据
//        CirceSignData data1 = new CirceSignData();
//        data1.setKeyName("dsakey1");
//        data1.setContentText("content text");
// 
//        // 签名操作
//        circeSignService.sign(data1);
//        System.out.printf("Key Name: %s, Signature Text: %s, Version: %d.\n", data1.getKeyName(),
//                data1.getSignatureText(), data1.getVersion());
// 
//        // 准备数据
//        CirceSignData data2 = new CirceSignData();
//        data2.setKeyName("dsakey1");
//        data2.setContentText("content text");
//        data2.setSignatureBytes(data1.getSignatureBytes());
// 
//        // 验证操作
//        boolean result = circeSignService.verify(data2);
//        System.out.printf("Key Name: %s, verify result: %b, Version: %d.\n", data2.getKeyName(),
//                result, data2.getVersion());
// 
//    }
// 
//    public static void test_dataWithVersion_circeSignService() throws Exception {
//        // 准备数据
//        CirceSignData data1 = new CirceSignData();
//        data1.setKeyName("dsakey1");
//        data1.setContentText("content text");
//        data1.setDataWithVersion(true);
// 
//        // 签名操作
//        circeSignService.sign(data1);
//        System.out.printf("Key Name: %s, Signature Text: %s, Version: %d.\n", data1.getKeyName(),
//                data1.getSignatureText(), data1.getVersion());
// 
//        // 准备数据
//        CirceSignData data2 = new CirceSignData();
//        data2.setKeyName("dsakey1");
//        data2.setContentText("content text");
//        data2.setSignatureBytes(data1.getSignatureBytes());
//        // 没有进行设置版本的操作
//        data2.setDataWithVersion(true);
// 
//        // 验证操作
//        boolean result = circeSignService.verify(data2);
//        System.out.printf("Key Name: %s, verify result: %b, Version: %d.\n", data2.getKeyName(),
//                result, data2.getVersion());
//    }
// 
//    public static void test_commonUse_circeDigestService() throws Exception {
//        // 准备数据
//        CirceDigestData data1 = new CirceDigestData();
//        data1.setKeyName("md5key1");
//        data1.setText("PlainText");
// 
//        // 摘要
//        CirceDigestData data2 = circeDigestService.digest(data1);
//        System.out.printf("Key Name: %s, Version: %d, digest result: %s. \n", data2.getKeyName(),
//                data2.getVersion(), data2.getText());
//    }
//}