package test.yubei.com.app.t1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import test.yubei.com.app.mp3player.MusicUtil;

import javazoom.jl.player.Player;
public class MusicPlayer {
	public static boolean transferStus = false;
	public static Clip clip;
	public static int length;
	public static int playMode = 0;
	public static Thread timet;
	public static boolean[] ttbb = new boolean[100];
	public static int ttbbindex = 0;
	public static void play(int id) {
		MusicPlayer.transferStus = false;
		LrcList.ms=0;
        LrcList.bb = false;
		BtnListener.title.setText(MusicList.playlist[id].name);
		BtnListener.singer.setText(MusicList.playlist[id].singer);
		System.out.println("nowPlay:"+id);
		ScreenPlayer.sp.setSelection(id);
		id = MusicList.playlist[id].id;
		AudioInputStream ais;
		try {
			if(MusicPlayer.clip!=null) {
				MusicPlayer.clip.stop();
			}
			//1、创建一个音频输入流
			ais = AudioSystem.getAudioInputStream(new File("E:\\Mp3Player\\local\\"+User.username+"\\mymp3\\"+id+".wav"));
			//2、获取音频格式
			AudioFormat af = ais.getFormat();
			//3、设置数据输入
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			MusicPlayer.clip=(Clip) AudioSystem.getLine(info);
			MusicPlayer.clip.open(ais);
			MusicPlayer.length = (int)MusicPlayer.clip.getMicrosecondLength();
			ScreenPlayer.sli.setMaximum(MusicPlayer.length);
			LrcList.PlayLrc(id);
			BtnListener.play_stus = false;
			ScreenPlayer.play_stus=false;
			LrcList.bp = false;
			
			
			
			MusicPlayer.clip.start();
			LrcList.startTimer();
			ais.close();
		} catch (UnsupportedAudioFileException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		BtnListener.play_stus = false;
		ScreenPlayer.play_stus = false;
		LrcList.bp=false;
	}
	
	public  static void pause() {
		BtnListener.play_stus = true;
		ScreenPlayer.play_stus = true;
		LrcList.bp=true;
		//Thread.sleep(1);
		MusicPlayer.clip.stop();
	}
	
	public static void replay() {
		BtnListener.play_stus = false;
		ScreenPlayer.play_stus = false;
		LrcList.bp=false;
		MusicPlayer.clip.start();
		LrcList.startTimer();
		
		
	}
	
	public static void moveTo(int timestamp) {
		MusicPlayer.clip.setMicrosecondPosition(timestamp);
		BtnListener.play_stus = false;
		ScreenPlayer.play_stus = false;
		LrcList.bp=false;
	}
	
	public static void refreshProcess(int timestamp) {
		ScreenPlayer.sli.setSelection(timestamp*10000);
	}
	
	public static void playNext() {
		//Thread.interrupted();
		MusicPlayer.clip.stop();
		if(BtnListener.playNow<MusicList.playlist.length-1) {
			BtnListener.playNow++;
		}
		if(!MusicPlayer.transferStus) {
			MusicPlayer.transferStus = true;
			Runnable runnable=new Runnable(){
				public void run(){
					MusicPlayer.play(BtnListener.playNow);
				}
			};
			ScreenPlayer.dp.syncExec(runnable);//关键在这一句上（同步调用，等待主界面线程处理完成之后
		}

		
	}
	
	public static void playLast() {
		MusicPlayer.clip.stop();
		if(BtnListener.playNow>=1) {
			BtnListener.playNow--;
		}
		if(!MusicPlayer.transferStus) {
			MusicPlayer.transferStus = true;
			Runnable runnable=new Runnable(){
				public void run(){
					MusicPlayer.play(BtnListener.playNow);
				}
			};
			ScreenPlayer.dp.syncExec(runnable);//关键在这一句上（同步调用，等待主界面线程处理完成之后
		}
	}
}


