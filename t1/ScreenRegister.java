package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

import test.yubei.com.app.api.*;
import test.yubei.com.app.api.Error;

public class ScreenRegister {

	protected Shell MainRegister;
	private Text text_user;
	private Text text_pswd;
	private Text text_confirm_pswd;
	private Text text_mail;
	private Label Label_register;

	/**
	 * Launch the application.
	 * @param args
	 */
	private Label Label_btn_register;
	private Label Label_user;
	

	public static void main(String[] args) {
		try {
			ScreenRegister window = new ScreenRegister();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		MainRegister.open();
		MainRegister.layout();
		while (!MainRegister.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainRegister = new Shell(SWT.CLOSE);
		MainRegister.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				ScreenController.f_regisitor = false;
			}
		});
		MainRegister.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainRegister.setSize(557, 524);
		MainRegister.setText("\u65B0\u7528\u6237\u6CE8\u518C");
		
		Label_user = new Label(MainRegister, SWT.NONE);
		Label_user.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_user.setBounds(125, 128, 84, 17);
		Label_user.setText("\u8BF7\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		
		Label Label_pswd = new Label(MainRegister, SWT.NONE);
		Label_pswd.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_pswd.setBounds(137, 175, 72, 17);
		Label_pswd.setText("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		
		Label Label_confirm_pswd = new Label(MainRegister, SWT.NONE);
		Label_confirm_pswd.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_confirm_pswd.setBounds(148, 219, 61, 17);
		Label_confirm_pswd.setText("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		
		Label Label_mail = new Label(MainRegister, SWT.NONE);
		Label_mail.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_mail.setBounds(137, 264, 72, 17);
		Label_mail.setText("\u8BF7\u8F93\u5165\u90AE\u7BB1\uFF1A");
		
		text_user = new Text(MainRegister, SWT.NONE);
		text_user.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_user.setBounds(215, 128, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_user, "TEXTAREA");
		
		text_pswd = new Text(MainRegister, SWT.PASSWORD);
		text_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_pswd.setBounds(215, 175, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_pswd, "TEXTAREA");
		
		text_confirm_pswd = new Text(MainRegister, SWT.PASSWORD);
		text_confirm_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_confirm_pswd.setBounds(215, 216, 143, 30);
		BtnListener.btn_LOAD_STATIC(text_confirm_pswd, "TEXTAREA");
		
		text_mail = new Text(MainRegister, SWT.NONE);
		text_mail.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_mail.setBounds(215, 258, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_mail, "TEXTAREA");
		
		Label_register = new Label(MainRegister, SWT.NONE);
		Label_register.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
		Label_register.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_register.setAlignment(SWT.CENTER);
		Label_register.setBounds(222, 69, 84, 40);
		Label_register.setText("\u6CE8\u518C");
		
		Label_btn_register = new Label(MainRegister, SWT.NONE);
		Label_btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String user = text_user.getText();
				String pswd = text_pswd.getText();
				String confirm_pswd = text_confirm_pswd.getText();
				String mail = text_mail.getText();
				if(!confirm_pswd.equals(pswd)) {		//对比两次密码输入
					JOptionPane.showMessageDialog(null, "两次密码输入不一致！","提示", JOptionPane.WARNING_MESSAGE);
				}else if(mail==""){			//邮箱不能为空
					JOptionPane.showMessageDialog(null, "邮箱地址不能为空！","提示", JOptionPane.WARNING_MESSAGE);
				}else {
					String api = "https://api.mp3.h-00.com/v1/user/regisitor?username="+user+"&password="+pswd+"&email="+mail;
					Error err = DoPost.doPost(api);		//向服务器发送POST请求，返回error对象
					if(err.errorCode==0) {
						JOptionPane.showMessageDialog(null, "已发送邮件至您的邮箱！请在1个小时内完成验证！","提示", JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, err.errorMsg,"提示", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		Label_btn_register.setBounds(215, 327, 100, 36);
		Label_btn_register.setText("New Label");
		BtnListener.btn_listen(Label_btn_register,"REGISITOR");

	}
	public void end() {
		MainRegister.close();
		
	}

}
