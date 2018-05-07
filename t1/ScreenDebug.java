package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ScreenDebug {
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args/* User user1 */) {
		try {
			//user = user1;
			ScreenDebug window = new ScreenDebug();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.login_DEBUG(null);
			}
		});
		btnNewButton.setBounds(37, 33, 80, 27);
		btnNewButton.setText("Login");
		
		Button btnRegister = new Button(shell, SWT.NONE);
		btnRegister.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.regisitor();
			}
		});
		btnRegister.setText("Register");
		btnRegister.setBounds(37, 78, 80, 27);
		
		Button btnList = new Button(shell, SWT.NONE);
		btnList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.list();
			}
		});
		btnList.setText("List");
		btnList.setBounds(37, 126, 80, 27);
		
		Button btnAboutus = new Button(shell, SWT.NONE);
		btnAboutus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.aboutus();
			}
		});
		btnAboutus.setText("AboutUs");
		btnAboutus.setBounds(37, 174, 80, 27);
		
		Button btnSearch = new Button(shell, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.search();
			}
		});
		btnSearch.setText("Search");
		btnSearch.setBounds(170, 33, 80, 27);
		
		Button btnPlayer = new Button(shell, SWT.NONE);
		btnPlayer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.player();
			}
		});
		btnPlayer.setText("Player");
		btnPlayer.setBounds(170, 78, 80, 27);

	}
	
	public void end() {
		shell.close();
	}

}
