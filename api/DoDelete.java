package test.yubei.com.app.api;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DoDelete {
	public static Error doDelete(String api){

		try {
			//1、创建httpClient对象
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//2、创建delete对象
			HttpDelete delete = new HttpDelete(api);
			//3、执行delete请求
			CloseableHttpResponse response = httpClient.execute(delete);
			/*
			 * 4、HttpResponse的getEntity()方法可获取HttpEntity对象，
			 * 该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。
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
}
