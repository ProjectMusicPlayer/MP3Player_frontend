package test.yubei.com.app.t1;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class BtnListener {
	
	public static Label title;
	public static Label singer;
	public static int playNow;
	public static final String baseImgAddr = new String("C:\\Users\\Adminisator\\Desktop\\谁也不能阻止我学习\\java\\1\\APPTEST2\\img\\mp3\\ButtonTest\\");
	
	public static void btn_GOPASS(Label b,String s) {
		b.setImage(SWTResourceManager.getImage(baseImgAddr+s+"_GOPASS.jpg"));
	}
	public static void btn_ACTIVE(Label b,String s) {
		b.setImage(SWTResourceManager.getImage(baseImgAddr+s+"_ACTIVE.jpg"));
	}
	public static void btn_NORMAL(Label b,String s) {
		b.setImage(SWTResourceManager.getImage(baseImgAddr+s+"_NORMAL.jpg"));
	}
	public static void btn_LOAD_STATIC(Label b,String s) {
		b.setImage(SWTResourceManager.getImage(baseImgAddr+s+"_STATIC.jpg"));
	}
	public static void btn_LOAD_STATIC(Text b,String s) {
		b.setBackgroundImage(SWTResourceManager.getImage(baseImgAddr+s+"_STATIC.jpg"));
	}
	public static void btn_listen(Label b,String s) {
		btn_NORMAL(b,s);
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				btn_ACTIVE(b,s);}
			@Override
			public void mouseUp(MouseEvent e) {
				btn_NORMAL(b,s);
			}
		});
		b.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				btn_GOPASS(b,s);
			}
			public void mouseExit(MouseEvent e) {
				btn_NORMAL(b,s);
			}
		});		
	}
	public static boolean play_stus = true;
	public static void btn_listen_play(List l,Label b,String p,String s) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		btn_NORMAL(b,p);
		/*
		//1、创建一个音频输入流
		AudioInputStream ais= AudioSystem.getAudioInputStream(new File("E:\\KuGou\\test\\test1.wav"));
		//2、获取音频格式
		AudioFormat af = ais.getFormat();
		//3、设置数据输入
		DataLine.Info info = new DataLine.Info(Clip.class, af);
		Clip clip=(Clip) AudioSystem.getLine(info);
		clip.open(ais);
		ais.close();
*/
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				BtnListener.playNow = l.getSelectionIndex();
				MusicPlayer.play(l.getSelectionIndex());
			}
		});
		System.out.println("add listener success");
		b.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				String n = "";
				if(play_stus) {
					if(MusicPlayer.clip==null) {
						JOptionPane.showMessageDialog(null,"请先双击选择歌曲","提示", JOptionPane.WARNING_MESSAGE);	//错误提示
						return;
					}
					n = p;
					play_stus=false;
					LrcList.bp=false;
					ScreenPlayer.play_stus=false;
					MusicPlayer.replay();//播放在这里执行
				}else {
					n= s;
					play_stus=true;
					LrcList.bp=true;
					ScreenPlayer.play_stus=true;
					MusicPlayer.pause(); //
				}
				btn_ACTIVE(b,n);}
			@Override
			public void mouseUp(MouseEvent e) {
				String n = "";
				if(play_stus) {
					n = p;
				}else {
					n= s;
				}
				btn_NORMAL(b,n);
			}
		});
		b.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				String n = "";
				if(play_stus) {
					n = p;
				}else {
					n= s;
				}
				btn_GOPASS(b,n);
			}
			public void mouseExit(MouseEvent e) {
				String n = "";
				if(play_stus) {
					n = p;
				}else {
					n= s;
				}
				btn_NORMAL(b,n);
			}
		});		
	}
}
