package test.yubei.com.app.mp3player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicUtil{
	public static Player player;
	public static int length;
	public static int playnow;
	
	public static void newPlay(String filePos) {
		try {
			BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filePos));
			MusicUtil.player = new Player(buffer);
			MusicUtil.length = MusicUtil.getLength(filePos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void play(int totime) {
		try {
			MusicUtil.player.play(totime);
		} catch (JavaLayerException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void play() {
		try {
			MusicUtil.player.play();
		} catch (JavaLayerException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void pause() {
		try {
			MusicUtil.player.wait();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static int getLength(String position) {
		int length = 0;
		try {
			MP3File mp3File = (MP3File) AudioFileIO.read(new File(position));
			MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();
			// 单位为秒
			length = audioHeader.getTrackLength();
			return length;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return length;
	}	
	
	
}