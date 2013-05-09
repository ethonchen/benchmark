package com.toxind.benchmark.thrid.httpcomponent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class HttpsTest {
	   public static void main(String[] args) throws Exception {
		   sendMsg("3" ,"1",200);
	    }
	   
	   public static void sendMsg(String fid,String tid,int replayCount) throws Exception {
		   int sleepTime = 1;
	       
			ThreadSafeClientConnManager tcm = new ThreadSafeClientConnManager();
			tcm.setMaxTotal(10);
			//**
			SSLContext ctx = SSLContext.getInstance("TLS"); //$NON-NLS-1$
			X509TrustManager tm = new X509TrustManager() {
				
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType)
						throws java.security.cert.CertificateException {

				}

				public void checkServerTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType)
						throws java.security.cert.CertificateException {
				}
				
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx,
					SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			Scheme sch = new Scheme("https", 443, ssf); //$NON-NLS-1$
			tcm.getSchemeRegistry().register(sch);
			// */
			HttpClient httpclient = new DefaultHttpClient(tcm);
			
		   
	        httpclient.getParams().setParameter(HTTP.USER_AGENT,
					"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)"); //$NON-NLS-1$			
	        try {
	            HttpPost httpost = new HttpPost("https://www.ubpq.com/bbs/login.php?");//nowtime="+new Date().getTime()+"&verify=518a5e76");
	            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
	            nvps.add(new BasicNameValuePair("jumpurl", "https://www.ubpq.com/bbs/read.php?tid="+tid));
	            nvps.add(new BasicNameValuePair("step", "2"));
	            nvps.add(new BasicNameValuePair("pwuser", "abc"));
	            nvps.add(new BasicNameValuePair("pwpwd", "111111"));
	            nvps.add(new BasicNameValuePair("lgt", "0"));

	            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

	            HttpResponse response = httpclient.execute(httpost);
	            HttpEntity entity = response.getEntity();
	            BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(),"utf-8"));
	            String brStr = null;
	            while((brStr = br.readLine())!=null){
	            	System.out.println(" --> " + brStr);
	            }
	            br.close();

	            
	            System.out.println("===========######==============");



				HttpGet get = new HttpGet("https://www.ubpq.com/bbs/read.php?tid="+tid+"&page=1");
				response = httpclient.execute(get);
				entity = response.getEntity();
				br = new BufferedReader(new InputStreamReader(entity.getContent(),"gbk"));
				brStr = null;
	            String vrf = null;
	            while((brStr = br.readLine())!=null){	            	
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

	            if(vrf == null){
	            	System.err.println("error......");
	            	System.exit(-1);
	            }
	            System.out.println(vrf + " ****************************************");
	            

System.out.println("===========######==============");
for(int i = 0  ; i < replayCount ; i++){
	            httpost = new HttpPost("https://www.ubpq.com/bbs/post.php?fid="+fid+"&nowtime="+new Date().getTime()+"&verify="+vrf);
	            nvps = new ArrayList <NameValuePair>();
	            nvps.add(new BasicNameValuePair("atc_usesign","1"));
	            nvps.add(new BasicNameValuePair("atc_convert","1"));
	            nvps.add(new BasicNameValuePair("atc_autourl","1"));
	            nvps.add(new BasicNameValuePair("step","2"));
	            nvps.add(new BasicNameValuePair("type","ajax_addfloor"));
	            nvps.add(new BasicNameValuePair("action","reply"));
	            nvps.add(new BasicNameValuePair("fid",fid));
	            nvps.add(new BasicNameValuePair("cyid"," "));
	            nvps.add(new BasicNameValuePair("tid",tid));
	            nvps.add(new BasicNameValuePair("stylepath","newyear "));
	            nvps.add(new BasicNameValuePair("ajax","1"));
	            nvps.add(new BasicNameValuePair("verify",vrf));
	            nvps.add(new BasicNameValuePair("_hexie","05738739"));
	            nvps.add(new BasicNameValuePair("iscontinue","0"));
	            nvps.add(new BasicNameValuePair("isformchecked","1"));
	            nvps.add(new BasicNameValuePair("atc_title",""));
	            nvps.add(new BasicNameValuePair("atc_content","[s:"+(117 + i)+"] ......" + i));
	            nvps.add(new BasicNameValuePair("usernames",""));
	            
	            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

//		        httpclient.getParams().setParameter("Referer",
//						"http://www.czqq.com/read.php?tid=1305693&page=33"); //$NON-NLS-1$
				
		        
	            response = httpclient.execute(httpost);
	            entity = response.getEntity();

	            br = new BufferedReader(new InputStreamReader(entity.getContent(),"gbk"));
	            brStr = null;
	            while((brStr = br.readLine())!=null){
	     		   Pattern patternGuan = Pattern.compile("灌水预防机制已经打开，在(\\d*)秒内不能发帖");
	    		   //String guanShui = " <?xml version=\"1.0\" encoding=\"gbk\"?><ajax><![CDATA[灌水预防机制已经打开，在15秒内不能发帖]]></ajax>";
	       		
	    		   Matcher matcherGuan = patternGuan.matcher(brStr);
	    		   if(matcherGuan.find()){
	    			   System.out.println(brStr);
	    			   int sleepms = Integer.parseInt(matcherGuan.group(1));
	    			   sleepTime = sleepms + 3;
	    		   }
	            }
	            br.close();
	            
	            Thread.sleep(sleepTime * 1000);
}

	        } finally {
	            // When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }
	   }
}
