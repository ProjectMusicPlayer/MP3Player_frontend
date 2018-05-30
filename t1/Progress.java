package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ProgressBar;

public class Progress {

	protected Shell MianProgress;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Progress window = new Progress();
			window.open("","",0,"","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String urlStr,String username,int id,String temp1,String temp2) {
		try {
			Progress window = new Progress();
			window.open(urlStr,username,id,temp1,temp2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(String urlStr,String username,int id,String temp1,String temp2) {
		Display display = Display.getDefault();
		ProgressBar p = createContents();
		MianProgress.open();
		MianProgress.layout();
		try {
			this.downLoadFromUrl(urlStr, username, id, temp1, temp2, p,this);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		while (!MianProgress.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
//String urlStr,String username,int id,String temp1,String temp2
	/*

		try {
			this.downLoadFromUrl(urlStr, username, id, temp1, temp2, progressBar);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	 * */
	/**
	 * Create contents of the window.
	 */
	protected ProgressBar createContents() {
		MianProgress = new Shell(SWT.BORDER | SWT.CLOSE);
		MianProgress.setSize(450, 176);
		MianProgress.setText("\u4E0B\u8F7D\u5668");
		MianProgress.setBackground(SWTResourceManager.getColor(255, 204, 204));
		
		Label Lable_download = new Label(MianProgress, SWT.NONE);
		Lable_download.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD | SWT.ITALIC));
		
		Lable_download.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Lable_download.setBounds(10, 28, 130, 28);
		Lable_download.setText("\u6B63\u5728\u4E0B\u8F7D......");
		
		ProgressBar progressBar = new ProgressBar(MianProgress, SWT.NONE);
		progressBar.setSelection(0);
		progressBar.setBounds(10, 81, 414, 22);
		return progressBar;
	}
	
	//https://git.h-00.com/a.txt
	public static void downLoadFromUrl(String urlStr,String username,int id,String temp1,String temp2,ProgressBar p,Progress pr) throws Exception{
			URL url = new URL(urlStr);
			String root = "E:\\Mp3Player\\local\\";
			String fileLocal = root+username+"\\my"+temp1+"\\"+id+"."+temp2;
			File file = new File(fileLocal);
			boolean flag = false; //标记是否下载成功
			if(file.exists()) {
				JOptionPane.showMessageDialog(null, "歌曲已存在！","提示", JOptionPane.WARNING_MESSAGE);
			}else {
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setConnectTimeout(6000);
				conn.setReadTimeout(6000);
				int code = conn.getResponseCode();
				if(code != 200) {
					JOptionPane.showMessageDialog(null, "下载失败","提示", JOptionPane.WARNING_MESSAGE);
				}
				p.setMaximum(conn.getContentLength());
				DataInputStream in = new DataInputStream(conn.getInputStream());
				DataOutputStream out = new DataOutputStream(new FileOutputStream(fileLocal));
				byte[] buffer = new byte[8192];
				int count = 0;
				int i = 0;
				while((count = in.read(buffer))>0) {
					out.write(buffer,0,count);
					i+=count;
					System.out.println(i);
					p.setSelection(i);
				}
				out.close();
				in.close();
				if(temp2=="wav") {
					DoFile.doWrite(username, id);
				}
				pr.MianProgress.close();
			}
			
	}
	
	
}
