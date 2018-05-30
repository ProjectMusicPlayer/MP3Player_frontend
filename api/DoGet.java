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
			//1������httpClient����
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//2������post����
			HttpGet get = new HttpGet(api);
			//������ͷ�м���һ����ֵ��
			get.setHeader("Authorization",token);
			//3��ִ��post����
			CloseableHttpResponse response = httpClient.execute(get);
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
}
