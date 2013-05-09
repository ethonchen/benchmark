package com.toxind.benchmark.thrid.httpcomponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NameParser;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;

public class RenRen {  
    // The configuration items  
    private static String userName = "glad952006@yahoo.com.cn";  
    private static String password = "2006329";  
    private static String redirectURL = "http://www.renren.com/home"; 
    private static String createWordsURL="http://zhan.renren.com/chuangyestory/word/create";
    private static String redirectLocation = null;
    // Don't change the following URL  
    private static String renRenLoginURL = "http://www.renren.com/PLogin.do";  
    
    // The HttpClient is used in one session  
    private static HttpResponse response;  
    private DefaultHttpClient httpclient = new DefaultHttpClient();  
  
    private boolean login() {  
        HttpPost httpost = new HttpPost(renRenLoginURL);  
        // All the parameters post to the web site  
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
        nvps.add(new BasicNameValuePair("origURL", redirectURL));  
        nvps.add(new BasicNameValuePair("domain", "renren.com"));  
        nvps.add(new BasicNameValuePair("isplogin", "true"));  
        nvps.add(new BasicNameValuePair("formName", ""));  
        nvps.add(new BasicNameValuePair("method", ""));  
        nvps.add(new BasicNameValuePair("submit", "登录"));  
        nvps.add(new BasicNameValuePair("email", userName));  
        nvps.add(new BasicNameValuePair("password", password));  
        try {  
            httpost.setEntity(new UrlEncodedFormEntity(nvps));  
            response = httpclient.execute(httpost);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        } finally {  
            httpost.abort();  
        }  
        return true;  
    }  
  
    private String getRedirectLocation() {  
        Header locationHeader = response.getFirstHeader("Location");  
        if (locationHeader == null) {  
            return null;  
        }  
        return locationHeader.getValue();  
    }  
    
    private String backHome(String redirectLocation){
    	 HttpGet get = new HttpGet(redirectLocation);  
         ResponseHandler<String> responseHandler = new BasicResponseHandler();  
         String txt = null;  
         try {  
             txt = httpclient.execute(get, responseHandler);  
         } catch (ClientProtocolException e) {  
             e.printStackTrace();  
         } catch (IOException e) {  
             e.printStackTrace();  
         } finally {  
             get.abort();  
         }  
         return txt;  
    }
  
    public boolean writeBlog(String title,String content) {  
        if (true) {  
            HttpPost post = new HttpPost(  
                    "http://blog.renren.com/NewEntry.do");  
            List<NameValuePair> cp = new ArrayList<NameValuePair>();  
            cp.add(new BasicNameValuePair("title", title));  
            cp.add(new BasicNameValuePair("body", content));  
            cp.add(new BasicNameValuePair("categoryId","0"));  
            cp.add(new BasicNameValuePair("blogControl", "99"));  
            cp.add(new BasicNameValuePair("editBlogControl","99"));  
            cp.add(new BasicNameValuePair("postFormId", "-256581784"));              
            cp.add(new BasicNameValuePair("isVip","false"));  
            cp.add(new BasicNameValuePair("jf_vip_em", "-true"));             
            cp.add(new BasicNameValuePair("requestToken", "-256581784"));  
            try {  
                post.setEntity(new UrlEncodedFormEntity(cp));  
                response = httpclient.execute(post);  
                System.out.println(response.getStatusLine());  
                  
            } catch (Exception e) {  
                e.printStackTrace();  
                return false;  
            } finally {  
                post.abort();  
            }  
            return true;  
        }  
        return false;  
    }  
      
    public boolean status(String status) {  
        if (true) {  
            HttpPost post = new HttpPost(  
                    "http://status.renren.com/doing/update.do?");  
            List<NameValuePair> cp = new ArrayList<NameValuePair>();  
            cp.add(new BasicNameValuePair("c", status));  
            cp.add(new BasicNameValuePair("isAtHome", "1"));  
            cp.add(new BasicNameValuePair("publisher_form_ticket",""));  
            cp.add(new BasicNameValuePair("raw", status));  
            cp.add(new BasicNameValuePair("requestToken", ""));  
            cp.add(new BasicNameValuePair("statusPage", "1"));  
            try {  
                post.setEntity(new UrlEncodedFormEntity(cp));  
                response = httpclient.execute(post);                  
                System.out.println(response.getStatusLine());  
                  
            } catch (Exception e) {  
                e.printStackTrace();  
                return false;  
            } finally {  
                post.abort();  
            }  
            return true;  
        }  
        return false;  
    }  
    
    private String zhan(String redirectLocation) {  
    	redirectLocation = createWordsURL;
        HttpPost httpPost = new HttpPost(redirectLocation);
        // Create a response handler  
        //ResponseHandler<String> responseHandler = new BasicResponseHandler();  
        //String responseBody = "";  
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("subject", "again again again test text"));
        params.add(new BasicNameValuePair("body", "<p>this is again test text.you can ignore it .thank you!</p>"));
        params.add(new BasicNameValuePair("tag", "创业历程"));
        params.add(new BasicNameValuePair("toSiteUrl", "chuangyestory"));
        params.add(new BasicNameValuePair("syncDouban", "false"));
        params.add(new BasicNameValuePair("syncQqweibo", "false"));
        params.add(new BasicNameValuePair("syncRenren", "false"));
        params.add(new BasicNameValuePair("syncSina", "false"));
        try { 
        	httpPost.setEntity(new UrlEncodedFormEntity(params));
        	response = httpclient.execute(httpPost);  
        } catch (Exception e) {  
            e.printStackTrace();  
            response = null;  
            return "not okay";
        } finally {  
        	httpPost.abort();  
        }  
        return "okay";  
    }  
  
    public void printText() {  
        if (login()) {  
            redirectLocation = getRedirectLocation();  
           /* if (redirectLocation != null) {  
                System.out.println(zhan(redirectLocation));  
            }  */
        }  
    }  
  
    public static void main(String[] args) {  
        RenRen renRen = new RenRen();  
        renRen.printText();
        renRen.backHome(redirectLocation);
        System.out.println(renRen.writeBlog("test", "testing"));
 //       System.out.println(renRen.status("test renren"));
      /*  System.out.println(response.getLocale());
        System.out.println(response.getStatusLine());
        Header[] headers = response.getAllHeaders();
        int i=1;
        for(Header header:headers){
        	System.out.println("i="+header);
        	i++;
        }
        System.out.println(renRen.notify(redirectLocation));*/
    }  
    
    private String notify(String url) {  
        HttpGet get = new HttpGet(url);  
        ResponseHandler<String> responseHandler = new BasicResponseHandler();  
        String txt = null;  
        try {  
            txt = httpclient.execute(get, responseHandler);  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            get.abort();  
        }  
        return txt;  
    } 
    
}  
