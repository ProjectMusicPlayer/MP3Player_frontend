package test.yubei.com.app.api;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DoGet {
	public static JSONObject doGetHJ(String api,String token){

		try {
			//1、创建httpClient对象
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//2、创建post对象
			HttpGet get = new HttpGet(api);
			//往请求头中加入一个键值对
			get.setHeader("Authorization",token);
			//3、执行post请求
			CloseableHttpResponse response = httpClient.execute(get);
			/*
			 * 4、HttpResponse的getEntity()方法可获取HttpEntity对象，
			 * 该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。
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
}
