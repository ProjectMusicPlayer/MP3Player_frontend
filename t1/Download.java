package test.yubei.com.app.t1;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.omg.CORBA.portable.InputStream;


public class Download {
	//https://git.h-00.com/a.txt
	public static void downLoadFromUrl(String urlStr,String username,int id,String temp1,String temp2) throws Exception{
		
			URL url = new URL(urlStr);
			String root = "E:\\Mp3Player\\local\\";
			String fileLocal = root+username+"\\my"+temp1+"\\"+id+"."+temp2;
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(6000);
			conn.setReadTimeout(6000);
			int code = conn.getResponseCode();
			if(code != 200) {
				throw new Exception("ÎÄ¼þ¶ÁÈ¡Ê§°Ü");
			}
			DataInputStream in = new DataInputStream(conn.getInputStream());
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fileLocal));
			byte[] buffer = new byte[2048];
			int count = 0;
			int i = 0;
			while((count = in.read(buffer))>0) {
				out.write(buffer,0,count);
				i++;
				System.out.println(i);
			}
			out.close();
			in.close();
	}
	

}
