package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class ScreenAboutUs {

	protected Shell MainAboutUs;
	private Text text_suggest;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ScreenAboutUs window = new ScreenAboutUs();
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
		MainAboutUs.open();
		MainAboutUs.layout();
		while (!MainAboutUs.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainAboutUs = new Shell(SWT.BORDER | SWT.CLOSE);
		MainAboutUs.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				ScreenController.f_aboutus=false;
			}
		});
		MainAboutUs.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainAboutUs.setSize(557, 524);
		MainAboutUs.setText("\u5173\u4E8E\u6211\u4EEC");
		
		Label Label_AboutUs = new Label(MainAboutUs, SWT.NONE);
		Label_AboutUs.setAlignment(SWT.CENTER);
		Label_AboutUs.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
		Label_AboutUs.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_AboutUs.setBounds(226, 29, 103, 25);
		Label_AboutUs.setText("\u5173\u4E8E\u6211\u4EEC");
		
		Label Label_img = new Label(MainAboutUs, SWT.NONE);
		Label_img.setText("\u56FE\u7247");
		Label_img.setBounds(313, 96, 179, 164);
		
		Label Label_intro = new Label(MainAboutUs, SWT.NONE);
		Label_intro.setBackground(SWTResourceManager.getColor(255, 230, 230));
		Label_intro.setBounds(29, 75, 227, 215);
		Label_intro.setText("\u56E2\u961F\u4ECB\u7ECD");
		
		text_suggest = new Text(MainAboutUs, SWT.BORDER);
		text_suggest.setBackground(SWTResourceManager.getColor(255, 230, 230));
		text_suggest.setBounds(29, 322, 463, 67);
		
		Label Label_suggest = new Label(MainAboutUs, SWT.NONE);
		Label_suggest.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		Label_suggest.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_suggest.setBounds(29, 299, 185, 17);
		Label_suggest.setText("\u8BF7\u5728\u6B64\u5199\u4E0B\u5BF9\u6211\u4EEC\u7684\u5EFA\u8BAE\uFF1A");
		
		Label Label_btn_submit = new Label(MainAboutUs, SWT.NONE);
		Label_btn_submit.setBounds(287, 405, 100, 36);
		Label_btn_submit.setText("New Label");
		BtnListener.btn_listen(Label_btn_submit, "SUBMIT");
		
		Label Label_btn_return = new Label(MainAboutUs, SWT.NONE);
		Label_btn_return.setBounds(393, 405, 100, 36);
		Label_btn_return.setText("New Label");
		BtnListener.btn_listen(Label_btn_return, "RETURN");

	}

}
