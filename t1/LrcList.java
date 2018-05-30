package test.yubei.com.app.t1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;

public class LrcList {
	
	public static Timer timer;
	public static boolean bb;
	public static boolean bp;
	public static int ms;
	public static String decode(FileInputStream fis) {
		try {
			InputStreamReader reader = new InputStreamReader(fis,"UTF-8"); 
			BufferedReader br = new BufferedReader(reader); 
			String line = new String(); 
			String temp = new String(); 
			while ((temp = br.readLine()) != null) {
				if(temp=="\n") {
					continue;
				}
				line+=("\r\n"+temp);
			} 
			br.close(); 
			reader.close(); 
			return line;
		} catch (Exception e) { 
			e.printStackTrace(); 
		} finally {
			if (fis != null) {
				try { 
					fis.close(); 
				} catch (IOException e) {
					e.printStackTrace(); 
				} 
			} 
		}
		return "";
	}
	
	Lrc[] lines;
	public static void PlayLrc(int id) {
		
		File f = new File(DoFile.rootdir+User.username+"\\mylrc\\"+id+".txt");
		try {
			FileInputStream fis =new FileInputStream(f);
			/*
			byte[] all =new byte[(int) f.length()];
			fis.read(all);
			
			String allLrc = new String(all);	//所有歌词
			Charset chs = Charset.forName("utf-8");
			ByteBuffer bf = chs.encode(allLrc);
			CharBuffer cf = chs.decode(bf);
			char[] c = cf.array();
			allLrc = new String(c);
			
			char[] lrcChar = allLrc.toCharArray();	//所有歌词字符数组
			*/
			String lrcl = decode(fis);
			if(lrcl.indexOf("[")!=0) {
				lrcl = lrcl.substring(lrcl.indexOf("["));
			}
			char[] lrcChar = lrcl.toCharArray();
			int num = 0;	//记录行数
			int k = 0;	//记录换行符下标
			String[] lrcLines = new String[500];	//单句歌词字符串数组，以换行符为分隔符
			int start = 0;
			//将歌词拆成单句字符串数组
			for(int i=0;i<lrcChar.length;i++) {
				if(lrcChar[i]=='\r') {
					lrcChar[i]=' ';
				}
			}
			for(int i=0;i<lrcChar.length;i++) {
				if(lrcChar[i]=='\n') {
					k=i;
					for(int j=start;j<k-1;j++) {
						lrcLines[num] += lrcChar[j];
					}
					if(lrcLines[num].indexOf("null")!=-1) {
						lrcLines[num]=lrcLines[num].substring(4);
					}
					start = i+1;
					num++;
				}
			}
			String[] tempsa = new String[num];
			for(int i=0;i<num;i++) {
				tempsa[i] = lrcLines[i];
			}
			//将时间和歌词分开
			Lyric.creatLines(tempsa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		PlayLrc(ms);
	}
	
	public static void startTimer() {
		LrcList.timer = new Timer();
        Lyric.tsk = new TimerTask (){
        	public int index = BtnListener.playNow;
	        public void run() {
	    		if(!MusicPlayer.clip.isRunning()&&!ScreenPlayer.play_stus||this.index!=BtnListener.playNow) {
					//Runnable runnable=new Runnable(){
					//	public void run() {
					//		MusicPlayer.playNext();
		    		//	};
					//};
					//ScreenPlayer.dp.syncExec(runnable);//关键在这一句上（同步调用，等待主界面线程处理完成之后）
					cancel();
	    		}
	    		if(!LrcList.bb) {
		    		Lyric.indexnow=0;
		        	Lyric.nexttimer=Lyric.lines[1].time;
		        	LrcList.bb=true;
	    		}
			    if(!ScreenPlayer.play_stus) {		    						    		
			    	LrcList.ms = (int) MusicPlayer.clip.getMicrosecondPosition()/10000;
			    	Lyric.refreshLyric(LrcList.ms); 
			    	//*
					Runnable runnable=new Runnable(){
						public void run() {
							ScreenPlayer.sli.setSelection((int) MusicPlayer.clip.getMicrosecondPosition());
						}
				    	
					};
					
					ScreenPlayer.dp.syncExec(runnable);//关键在这一句上（同步调用，等待主界面线程处理完成之后）
			    }
	        }
        };
        timer.schedule(Lyric.tsk, 100,100);
	}
	
}

class Lrc{
	int lrctime;
	String lrc;
}



