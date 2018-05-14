package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class ScreenPswd {

	protected Shell MainPswd;
	private Text text_pri_pswd;
	private Text text_new_pswd;
	private Text text_confir_pswd;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ScreenPswd window = new ScreenPswd();
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
		MainPswd.open();
		MainPswd.layout();
		while (!MainPswd.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainPswd = new Shell();
		MainPswd.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				ScreenController.f_pswd = false;
			}
		});
		MainPswd.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainPswd.setSize(557, 524);
		MainPswd.setText("\u4FEE\u6539\u5BC6\u7801");
		
		Label Label_pri_swd = new Label(MainPswd, SWT.NONE);
		Label_pri_swd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		Label_pri_swd.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_pri_swd.setBounds(105, 147, 105, 33);
		Label_pri_swd.setText("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801\uFF1A");
		
		text_pri_pswd = new Text(MainPswd, SWT.PASSWORD);
		text_pri_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_pri_pswd.setBounds(214, 144, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_pri_pswd, "TEXTAREA");
		
		text_new_pswd = new Text(MainPswd, SWT.PASSWORD);
		text_new_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_new_pswd.setBounds(214, 193, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_new_pswd, "TEXTAREA");
		
		text_confir_pswd = new Text(MainPswd, SWT.PASSWORD);
		text_confir_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_confir_pswd.setBounds(214, 240, 142, 30);
		BtnListener.btn_LOAD_STATIC(text_confir_pswd, "TEXTAREA");
		
		Label Label_new_pswd = new Label(MainPswd, SWT.NONE);
		Label_new_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		Label_new_pswd.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_new_pswd.setText("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		Label_new_pswd.setBounds(105, 196, 105, 33);
		
		Label Label_confir_pswd = new Label(MainPswd, SWT.NONE);
		Label_confir_pswd.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		Label_confir_pswd.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_confir_pswd.setBounds(105, 243, 105, 29);
		Label_confir_pswd.setText("\u8BF7\u786E\u8BA4\u5BC6\u7801\uFF1A");
		
		Label Label_btn_submit = new Label(MainPswd, SWT.NONE);
		Label_btn_submit.setBounds(214, 320, 100, 36);
		Label_btn_submit.setText("New Label");
		BtnListener.btn_listen(Label_btn_submit, "SUBMIT");

	}
}
