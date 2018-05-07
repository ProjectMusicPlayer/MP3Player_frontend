package test.yubei.com.app.t1;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class BtnListener {
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
	protected static boolean play_stus = true;
	public static void btn_listen_play(Label b,String p,String s) {
		btn_NORMAL(b,p);
		b.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				String n = "";
				if(play_stus) {
					n = p;
					play_stus=false;
					//播放在这里执行
				}else {
					n= s;
					play_stus=true;
					//暂停在这里执行
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
