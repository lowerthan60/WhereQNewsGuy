package com.whereq.component.httpclient;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientHelper {

	public static String post(String url, Map<String, String> parameters) throws IOException {

		StringBody stringValue = null;
	
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);

		MultipartEntity reqEntity = new MultipartEntity();
		Iterator<String> keys = parameters.keySet().iterator();
		String key = null;
		try {
			while(keys.hasNext()){
				key = keys.next();
				stringValue = new StringBody(URLEncoder.encode(parameters.get(key), "UTF-8"));
				reqEntity.addPart(key, stringValue);
			}
			
		} catch (UnsupportedEncodingException e) {
			
		}

		httppost.setEntity(reqEntity);

		HttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
		} catch (ClientProtocolException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		
		HttpEntity resEntity = response.getEntity();
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		resEntity.writeTo(byteArrayOutputStream);
		httpclient.getConnectionManager().shutdown();
		
		String result = byteArrayOutputStream.toString();
		
		byteArrayOutputStream.flush();
		byteArrayOutputStream.close();
		byteArrayOutputStream = null;
		
		return result;
	}
	

}
