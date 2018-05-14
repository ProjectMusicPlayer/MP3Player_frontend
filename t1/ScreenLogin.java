package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.json.JSONException;

import net.sf.json.JSONObject;
import test.yubei.com.app.api.*;
import test.yubei.com.app.api.Error;

public class ScreenLogin {

	protected Shell MainLogin;
	private Text text_user;
	private Text text_pswd;

	/**
	 * Launch the application.
	 * @param args
	 */
	
//**
	
	
	public static void main(String[] args) {
		try {
			ScreenLogin window = new ScreenLogin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
//*/
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		MainLogin.open();
		MainLogin.layout();
		while (!MainLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainLogin = new Shell(SWT.BORDER | SWT.CLOSE);
		MainLogin.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainLogin.setSize(557, 524);
		MainLogin.setText("JMP");
		
		Button btnNewButton = new Button(MainLogin, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openMainScreen("test");
			}
		});
		btnNewButton.setBounds(361, 431, 61, 23);
		btnNewButton.setText("\u767B\u5F55");
		
		Label Label_user = new Label(MainLogin, SWT.NONE);
		Label_user.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_user.setAlignment(SWT.RIGHT);
		Label_user.setBounds(135, 173, 61, 17);
		Label_user.setText("\u8D26\u6237");
		
		text_user = new Text(MainLogin, SWT.NONE);
		text_user.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_user.setBounds(202, 170, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_user, "TEXTAREA");
		
		Label Label_pswd = new Label(MainLogin, SWT.NONE);
		Label_pswd.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_pswd.setAlignment(SWT.RIGHT);
		Label_pswd.setBounds(137, 206, 61, 17);
		Label_pswd.setText("\u5BC6\u7801");
		
		text_pswd = new Text(MainLogin, SWT.PASSWORD);
		text_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_pswd.setBounds(202, 203, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_pswd, "TEXTAREA");
		
		Label Label_musicplayer = new Label(MainLogin, SWT.NONE);
		Label_musicplayer.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.BOLD));
		Label_musicplayer.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_musicplayer.setAlignment(SWT.CENTER);
		Label_musicplayer.setBounds(195, 117, 134, 27);
		Label_musicplayer.setText("MusicPlayer");
		
		Label Label_btn_login = new Label(MainLogin, SWT.NONE);
		Label_btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String user = text_user.getText();
				String pswd = text_pswd.getText();
				String api = "https://api.mp3.h-00.com/v1/user/token?username="+user+"&password="+pswd;
				try {
					org.json.JSONObject Json = DoPost.doPostJ(api);
					if(Json.getInt("error")==0) {
						String token = Json.getString("token");
						User.token = token;
						User.username = user;
						openMainScreen(user);
					}else {
						JOptionPane.showMessageDialog(null, Json.getString("msg"),"提示", JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		Label_btn_login.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_btn_login.setBounds(89, 281, 100, 36);
		Label_btn_login.setText("\u767B\u5F55");
		BtnListener.btn_listen(Label_btn_login,"LOGIN");
		
		
		Label Label_btn_register = new Label(MainLogin, SWT.NONE);
		ScreenLogin thi = this;
		Label_btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ScreenController.regisitor();
			}
		});
		Label_btn_register.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_btn_register.setText("\u767B\u5F55");
		Label_btn_register.setBounds(221, 281, 100, 36);
		BtnListener.btn_listen(Label_btn_register,"REGISITOR");
		
		Label Label_btn_forget = new Label(MainLogin, SWT.NONE);
		Label_btn_forget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ScreenController.forget();
				
			}
		});
		Label_btn_forget.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_btn_forget.setText("\u767B\u5F55");
		Label_btn_forget.setBounds(348, 281, 100, 36);
		BtnListener.btn_listen(Label_btn_forget,"FORGET");

	}
	
	public void openMainScreen(String username) {
		ScreenController.login(this,username);
	}
	
	public void end() {
		MainLogin.close();
	}
	
}
