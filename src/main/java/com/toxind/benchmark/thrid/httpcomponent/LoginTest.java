package com.toxind.benchmark.thrid.httpcomponent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class LoginTest {
	   public static void main(String[] args) throws Exception {

	        DefaultHttpClient httpclient = new DefaultHttpClient();
	        
	        httpclient.getParams().setParameter(HTTP.USER_AGENT,
					"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)"); //$NON-NLS-1$
			
	        try {
//	            HttpGet httpget = new HttpGet("http://www.czqq.com/login.php?nowtime="+new Date().getTime()+"&verify=518a5e76");
//
//	            HttpResponse response = httpclient.execute(httpget);
//	            HttpEntity entity = response.getEntity();
//
//	            System.out.println("Login form get: " + response.getStatusLine());
//	            EntityUtils.consume(entity);
//
//	            System.out.println("Initial set of cookies:");
//	            List<Cookie> cookies = httpclient.getCookieStore().getCookies();
//	            if (cookies.isEmpty()) {
//	                System.out.println("None");
//	            } else {
//	                for (int i = 0; i < cookies.size(); i++) {
//	                    System.out.println("- " + cookies.get(i).toString());
//	                }
//	            }

	            HttpPost httpost = new HttpPost("http://www.czqq.com/login.php?");//nowtime="+new Date().getTime()+"&verify=518a5e76");

	            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
	            nvps.add(new BasicNameValuePair("jumpurl", "http://www.czqq.com/read.php?tid=1305693"));
	            nvps.add(new BasicNameValuePair("step", "2"));
//	            nvps.add(new BasicNameValuePair("ajax", "1"));
	            nvps.add(new BasicNameValuePair("pwuser", "sdfc23"));
	            nvps.add(new BasicNameValuePair("pwpwd", "111111"));
	            nvps.add(new BasicNameValuePair("lgt", "0"));

	            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

	            HttpResponse response = httpclient.execute(httpost);
	            HttpEntity entity = response.getEntity();
	            BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(),"gbk"));
	            String brStr = null;
	            while((brStr = br.readLine())!=null){
	            	System.out.println(" --> " + brStr);
	            }
	            br.close();

	            System.out.println("Login form get: " + response.getStatusLine());
//	            EntityUtils.consume(entity);
	            
	            //http://www.czqq.com/read.php?tid=1305693&page=33
System.out.println("===========######==============");



				HttpGet get = new HttpGet("http://www.czqq.com/read.php?tid=1305693&page=33");
				response = httpclient.execute(get);
				entity = response.getEntity();
	            br = new BufferedReader(new InputStreamReader(entity.getContent(),"gbk"));
	            brStr = null;
	            String vrf = null;
	            while((brStr = br.readLine())!=null){
	            	System.out.println(" --> " + brStr);
	            	
	            	if(brStr.trim().matches("<input type=\"hidden\" value=\"\\w+\" name=\"verify\">")){
	            		Pattern p = Pattern.compile("<input type=\"hidden\" value=\"(\\w+)\" name=\"verify\">");
	            		Matcher m = p.matcher(brStr.trim());
	            		if(m.matches()){
	            			vrf = m.group(1);
	            			break;
	            		}
	            		
	            	}
	            }
	            br.close();

	            System.out.println(vrf + " ****************************************");
	            

System.out.println("===========######==============");
	            httpost = new HttpPost("http://www.czqq.com/post.php?fid=7&nowtime="+new Date().getTime()+"&verify="+vrf);
	            nvps = new ArrayList <NameValuePair>();
	            nvps.add(new BasicNameValuePair("atc_usesign","1"));
	            nvps.add(new BasicNameValuePair("atc_convert","1"));
	            nvps.add(new BasicNameValuePair("atc_autourl","1"));
	            nvps.add(new BasicNameValuePair("step","2"));
	            nvps.add(new BasicNameValuePair("type","ajax_addfloor"));
	            nvps.add(new BasicNameValuePair("action","reply"));
	            nvps.add(new BasicNameValuePair("fid","7 "));
	            nvps.add(new BasicNameValuePair("cyid"," "));
	            nvps.add(new BasicNameValuePair("tid","1305693 "));
	            nvps.add(new BasicNameValuePair("stylepath","newyear "));
	            nvps.add(new BasicNameValuePair("ajax","1"));
	            nvps.add(new BasicNameValuePair("verify",vrf));
	            nvps.add(new BasicNameValuePair("_hexie","05738739"));
	            nvps.add(new BasicNameValuePair("iscontinue","0"));
	            nvps.add(new BasicNameValuePair("isformchecked","1"));
	            nvps.add(new BasicNameValuePair("atc_title",""));
	            nvps.add(new BasicNameValuePair("atc_content","[s:320] ..."));
	            nvps.add(new BasicNameValuePair("usernames",""));
	            
	            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

//		        httpclient.getParams().setParameter("Referer",
//						"http://www.czqq.com/read.php?tid=1305693&page=33"); //$NON-NLS-1$
				
		        
	            response = httpclient.execute(httpost);
	            entity = response.getEntity();

	            br = new BufferedReader(new InputStreamReader(entity.getContent(),"gbk"));
	            brStr = null;
	            while((brStr = br.readLine())!=null){
	            	System.out.println(" --> " + brStr);
	            }
	            br.close();
	            
//	            System.out.println("POST form get: " + response.getStatusLine());
//	            EntityUtils.consume(entity);
	            
	            
//	            System.out.println("Post logon cookies:");
//	            List<Cookie> cookies = httpclient.getCookieStore().getCookies();
//	            if (cookies.isEmpty()) {
//	                System.out.println("None");
//	            } else {
//	                for (int i = 0; i < cookies.size(); i++) {
//	                    System.out.println("- " + cookies.get(i).toString());
//	                }
//	            }

	        } finally {
	            // When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }
	    }
}
