package test.yubei.com.app.t1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

public class DoFile {
	public static String rootdir = "E:\\Mp3Player\\local\\";
	public static void doWrite(String username,int id) {
		String fileLocal = rootdir+username+"\\mylist\\mysong.txt";
		try {
			FileWriter writer=new FileWriter(fileLocal,true);
			writer.write("\r\n"+id);
			writer.close();
			readConfig();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
    public static void fileChannelCopy(String ss, String ts) {
    	File s = new File(ss);
    	File t = new File(ts);
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
	
	public static void readConfig() throws FileNotFoundException {
		File dir = new File(rootdir+User.username);
		if(!dir.exists()) {
			dir.mkdirs();
			dir = new File(rootdir+User.username+"\\mylist\\");
			dir.mkdirs();
			dir = new File(rootdir+User.username+"\\mylrc\\");
			dir.mkdirs();
			dir = new File(rootdir+User.username+"\\mymp3\\");
			dir.mkdirs();
			fileChannelCopy(rootdir+"default\\mylist\\mysong.txt",rootdir+User.username+"\\mylist\\mysong.txt");
			fileChannelCopy(rootdir+"default\\mylrc\\4.txt",rootdir+User.username+"\\mylrc\\4.txt");
			fileChannelCopy(rootdir+"default\\mymp3\\4.wav",rootdir+User.username+"\\mymp3\\4.wav");
		}
		//打开文件
		File file = new File(rootdir+User.username+"\\mylist\\mysong.txt");
		//创建文件字节读取流
		FileInputStream fs = new FileInputStream(file);
		//创建字节流通向字符流的桥梁
		InputStreamReader reader = new InputStreamReader(fs);
		int temp;
		try {
			char[] data = new char[500];
			temp = reader.read(data);
			String datas = new String(data);
			String[] datasa = datas.split("\r\n");
			int[] ii = new int[datasa.length];
			for (int i = 0;i<datasa.length;i++) {
				datasa[i] = datasa[i].trim();
				ii[i] = Integer.valueOf(datasa[i]);
			}
			MusicList.creatStorage(ii);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
}
