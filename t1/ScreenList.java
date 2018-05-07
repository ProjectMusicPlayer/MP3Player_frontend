package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class ScreenList {

	protected Shell MainList;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			ScreenList window = new ScreenList();
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
		MainList.open();
		MainList.layout();
		while (!MainList.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainList = new Shell(SWT.BORDER | SWT.CLOSE);
		MainList.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				ScreenController.f_list=false;
			}
		});
		MainList.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainList.setSize(557, 524);
		MainList.setText("\u6211\u7684\u6B4C\u5355");
		
		Label Label_list = new Label(MainList, SWT.NONE);
		Label_list.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.BOLD));
		Label_list.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_list.setAlignment(SWT.CENTER);
		Label_list.setBounds(180, 25, 180, 29);
		Label_list.setText("\u6211\u7684\u66F2\u5E93");
		
		List List_list = new List(MainList, SWT.CLOSE);
		List_list.setBackground(SWTResourceManager.getColor(255, 230, 230));
		List_list.setBounds(124, 59, 301, 346);
		
		Label Label_btn_return = new Label(MainList, SWT.NONE);
		Label_btn_return.setBounds(325, 422, 100, 36);
		Label_btn_return.setText("New Label");
		BtnListener.btn_listen(Label_btn_return, "RETURN");

	}
	
	public void end() {
		MainList.close();
	}
}
