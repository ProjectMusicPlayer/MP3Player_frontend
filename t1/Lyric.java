package test.yubei.com.app.t1;

import java.awt.List;
import java.util.TimerTask;

import org.eclipse.jface.viewers.ListViewer;

public class Lyric {
	public static Line[] lines;
	public static TimerTask tsk;
	public static org.eclipse.swt.widgets.List list;
	
	public static int indexnow;
	public static int nexttimer;
	
	public static void creatLines(String[] strs) {
		int len = strs.length;
		Lyric.lines = new Line[len];
		for(int i=0;i<len;i++) {
			String temp = strs[i];
			String tempt1 = temp.substring(1, 3);
			String tempt2 = temp.substring(4, 6);
			String tempt3 = temp.substring(7, 9);
			String lrcs = temp.substring(10);
			int m = Integer.valueOf(tempt1);
			int s = Integer.valueOf(tempt2);
			int ms = Integer.valueOf(tempt3);
			int timems = ms+s*100+m*6000;
			Lyric.lines[i] = new Line();
			Lyric.lines[i].str=lrcs;
			Lyric.lines[i].time=timems;
		}
	}
	
	public static void refreshLyric(int ms) {
		int now=0;
		int len=Lyric.lines.length;
		for(int i=0;i<len;i++) {
			if(i==len-1) {
				now = len-1;
			}else {
				if(lines[i].time>ms) {
					if(i==0) {
						now=0;
					}else {
						now=i;
					}
					if(now!=Lyric.indexnow) {
						Lyric.indexnow=now;
						Lyric.refreshScreen(Lyric.indexnow);
					}
					break;
				}
			}
		}
		
		/*
		
		if(ms>Lyric.nexttimer) {
			Lyric.indexnow++;
			if(Lyric.lines[Lyric.indexnow]!=null) {
				Lyric.nexttimer = Lyric.lines[Lyric.indexnow].time;
				Lyric.refreshScreen(Lyric.indexnow);
			}
		}
		*/
	}
	
	public static void refreshScreen(int index) {
			Runnable runnable=new Runnable(){
				public void run(){
					ScreenPlayer.cllrc();
					for(int i=((Lyric.indexnow==0)?0:Lyric.indexnow-1);i<Lyric.lines.length;i++) {
						Lyric.list.add(Lyric.lines[i].str);
					}
				}
			};
			ScreenPlayer.dp.syncExec(runnable);//关键在这一句上（同步调用，等待主界面线程处理完成之后）

	}
	
}

class Line{
	String str;
	int time;
}

