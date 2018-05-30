package test.yubei.com.app.api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.Header;
import org.apache.http.entity.mime.MinimalField;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DoPost {

	public static Error doPost(String api){

		try {
			//1������httpClient����
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//2������post����
			HttpPost post = new HttpPost(api);
			//3��ִ��post����
			CloseableHttpResponse response = httpClient.execute(post);
			/*
			 * 4��HttpResponse��getEntity()�����ɻ�ȡHttpEntity����
			 * �ö����װ�˷���������Ӧ���ݡ������ͨ���ö����ȡ����������Ӧ���ݡ�
			 */
			String str = EntityUtils.toString(response.getEntity());
			response.close();
			httpClient.close();
			JSONObject jsonObject = new JSONObject(str);	//ʵ����һ��JSON����
			if(jsonObject.getInt("error")==0) {
				return Error.makeErr(0, jsonObject.getString("msg"));
			}else {
				return Error.makeErr(jsonObject.getInt("error"), jsonObject.getString("msg"));
			}
		} catch (JSONException | IOException e) {
			return Error.makeErr(100,e.toString());
		}
	}
	
	public static JSONObject doPostJ(String api){

		try {
			//1������httpClient����
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//2������post����
			HttpPost post = new HttpPost(api);
			//3��ִ��post����
			CloseableHttpResponse response = httpClient.execute(post);
			/*
			 * 4��HttpResponse��getEntity()�����ɻ�ȡHttpEntity����
			 * �ö����װ�˷���������Ӧ���ݡ������ͨ���ö����ȡ����������Ӧ���ݡ�
			 */
			String str = EntityUtils.toString(response.getEntity());
			response.close();
			httpClient.close();
			return new JSONObject(str);//����JSON����
			
		} catch (JSONException | IOException e) {
			return null;
		}
	}

	public static Error doPostH(String api,String token){

		try {
			//1������httpClient����
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//2������post����
			HttpPost post = new HttpPost(api);
			//������ͷ�м���һ����ֵ��
			post.setHeader("Authorization",token);
			//3��ִ��post����
			CloseableHttpResponse response = httpClient.execute(post);
			/*
			 * 4��HttpResponse��getEntity()�����ɻ�ȡHttpEntity����
			 * �ö����װ�˷���������Ӧ���ݡ������ͨ���ö����ȡ����������Ӧ���ݡ�
			 */
			String str = EntityUtils.toString(response.getEntity());
			response.close();
			httpClient.close();
			JSONObject jsonObject = new JSONObject(str);
			if(jsonObject.getInt("error")==0) {
				return Error.makeErr(0, jsonObject.getString("msg"));
			}else {
				return Error.makeErr(jsonObject.getInt("error"), jsonObject.getString("msg"));
			}
		} catch (JSONException | IOException e) {
			return Error.makeErr(100,e.toString());
		}
	}

	public static JSONObject doPostHJ(String api,String token){

		try {
			//1������httpClient����
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//2������post����
			HttpPost post = new HttpPost(api);
			//������ͷ�м���һ����ֵ��
			post.setHeader("Authorization",token);
			//3��ִ��post����
			CloseableHttpResponse response = httpClient.execute(post);
			/*
			 * 4��HttpResponse��getEntity()�����ɻ�ȡHttpEntity����
			 * �ö����װ�˷���������Ӧ���ݡ������ͨ���ö����ȡ����������Ӧ���ݡ�
			 */
			String str = EntityUtils.toString(response.getEntity());
			response.close();
			httpClient.close();
			JSONObject jsonObject = new JSONObject(str);
			return jsonObject;
		} catch (JSONException | IOException e) {
			return null;
		}
	}
	
	public static Error func() {
		int code=2;
		String msg="";
		return Error.makeErr(code, msg);
	}
	
}
