package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class ScreenSearch {

	protected Shell MainSearch;
	private Text text_search;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			ScreenSearch window = new ScreenSearch();
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
		MainSearch.open();
		MainSearch.layout();
		while (!MainSearch.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainSearch = new Shell(SWT.BORDER | SWT.CLOSE);
		MainSearch.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				ScreenController.f_search=false;
			}
		});
		MainSearch.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainSearch.setSize(557, 524);
		MainSearch.setText("\u5728\u7EBF\u641C\u7D22");
		
		text_search = new Text(MainSearch, SWT.NONE);
		text_search.setBackground(SWTResourceManager.getColor(255, 230, 230));
		text_search.setBounds(27, 74, 365, 23);
		BtnListener.btn_LOAD_STATIC(text_search, "TEXTAREA_LONG");
		
		List List_list = new List(MainSearch, SWT.BORDER);
		List_list.setItems(new String[] {"\u5566\u5566\u5566", "\u54C8\u54C8\u54C8", "\u56AF\u56AF\u56AF"});
		List_list.setBackground(SWTResourceManager.getColor(255, 230, 230));
		List_list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		List_list.setBounds(27, 116, 461, 310);
		
		Label Label_search = new Label(MainSearch, SWT.NONE);
		Label_search.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.BOLD));
		Label_search.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_search.setAlignment(SWT.CENTER);
		Label_search.setBounds(204, 32, 105, 23);
		Label_search.setText("\u5728\u7EBF\u641C\u7D22");
		
		Label Label_btn_search = new Label(MainSearch, SWT.NONE);
		Label_btn_search.setBounds(408, 67, 100, 36);
		Label_btn_search.setText("New Label");
		BtnListener.btn_listen(Label_btn_search, "SEARCH");
		
		Label Label_btn_return = new Label(MainSearch, SWT.NONE);
		Label_btn_return.setText("New Label");
		Label_btn_return.setBounds(385, 432, 100, 36);
		BtnListener.btn_listen(Label_btn_return, "RETURN");
		
		Label Label_btn_download = new Label(MainSearch, SWT.NONE);
		Label_btn_download.setText("New Label");
		Label_btn_download.setBounds(268, 432, 100, 36);
		BtnListener.btn_listen(Label_btn_download, "DOWNLOAD");
	}
}
