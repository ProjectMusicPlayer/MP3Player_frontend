package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class ScreenForget {

	protected Shell MainForget;
	private Text text_user;
	private Text text_mail;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ScreenForget window = new ScreenForget();
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
		MainForget.open();
		MainForget.layout();
		while (!MainForget.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainForget = new Shell();
		MainForget.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				ScreenController.f_forget=false;
			}
		});
		MainForget.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainForget.setSize(557, 524);
		MainForget.setText("\u627E\u56DE\u5BC6\u7801");
		
		Label Label_user = new Label(MainForget, SWT.NONE);
		Label_user.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_user.setBounds(150, 148, 84, 28);
		Label_user.setText("\u8BF7\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		
		Label Label_mail = new Label(MainForget, SWT.NONE);
		Label_mail.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_mail.setBounds(139, 203, 96, 28);
		Label_mail.setText("\u8BF7\u8F93\u5165\u6CE8\u518C\u90AE\u7BB1\uFF1A");
		
		Label Label_forget = new Label(MainForget, SWT.NONE);
		Label_forget.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
		Label_forget.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_forget.setBounds(227, 74, 100, 42);
		Label_forget.setText("\u627E\u56DE\u5BC6\u7801");
		
		Label Label_btn_submit = new Label(MainForget, SWT.NONE);
		Label_btn_submit.setBounds(227, 304, 100, 36);
		Label_btn_submit.setText("New Label");
		BtnListener.btn_listen(Label_btn_submit, "SUBMIT");
		
		text_user = new Text(MainForget, SWT.NONE);
		text_user.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_user.setBounds(241, 145, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_user, "TEXTAREA");
		
		text_mail = new Text(MainForget, SWT.NONE);
		text_mail.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_mail.setBounds(241, 200, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_mail, "TEXTAREA");
		
	}
}
