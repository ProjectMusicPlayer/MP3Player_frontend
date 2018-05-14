package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.jface.viewers.ListViewer;




public class ScreenPlayer {
	protected Shell MainPlayer;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	
///*
	public static void main(String[] args) throws Exception {
		
		try {
			ScreenPlayer window = new ScreenPlayer();
			window.open();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
//**/
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		MainPlayer.open();
		MainPlayer.layout();
		while (!MainPlayer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		String strdk1 = new String();
		MainPlayer = new Shell(SWT.BORDER | SWT.CLOSE);
		MainPlayer.setAlpha(255);
		MainPlayer.setBackgroundMode(SWT.INHERIT_DEFAULT);
		MainPlayer.setBackground(SWTResourceManager.getColor(255, 204, 204));
		MainPlayer.setSize(557, 524);
		MainPlayer.setText("»¶Ó­,"+User.username+"!");
		
		Menu menu = new Menu(MainPlayer, SWT.BAR);
		MainPlayer.setMenuBar(menu);
		
		MenuItem Menu_main_user = new MenuItem(menu, SWT.CASCADE);
		Menu_main_user.setText("\u7528\u6237");
		
		Menu menu_1 = new Menu(Menu_main_user);
		Menu_main_user.setMenu(menu_1);
		
		MenuItem Menu_change = new MenuItem(menu_1, SWT.NONE);
		Menu_change.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.pswd();
			}
		});
		Menu_change.setText("\u4FEE\u6539\u5BC6\u7801");
		
		MenuItem Menu_signout = new MenuItem(menu_1, SWT.NONE);
		Menu_signout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		Menu_signout.setText("\u6CE8\u9500");
		
		MenuItem Menu_main_listen = new MenuItem(menu, SWT.CASCADE);
		Menu_main_listen.setText("\u542C\u6B4C");
		
		Menu menu_2 = new Menu(Menu_main_listen);
		Menu_main_listen.setMenu(menu_2);
		
		MenuItem Menu_list = new MenuItem(menu_2, SWT.NONE);
		Menu_list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.list();
			}
		});
		Menu_list.setText("\u6211\u7684\u6B4C\u5355");
		
		MenuItem Menu_search = new MenuItem(menu_2, SWT.NONE);
		Menu_search.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.search();
			}
		});
		Menu_search.setText("\u5728\u7EBF\u641C\u7D22");
		
		MenuItem Menu_main_more = new MenuItem(menu, SWT.CASCADE);
		Menu_main_more.setText("\u66F4\u591A\u529F\u80FD");
		
		Menu menu_3 = new Menu(Menu_main_more);
		Menu_main_more.setMenu(menu_3);
		
		MenuItem Menu_web = new MenuItem(menu_3, SWT.NONE);
		Menu_web.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.openWebsite("https://www.baidu.com");
			}
		});
		Menu_web.setText("\u5B98\u7F51");
		
		MenuItem Menu_aboutUs = new MenuItem(menu_3, SWT.NONE);
		Menu_aboutUs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ScreenController.aboutus();
			}
		});
		Menu_aboutUs.setText("\u5173\u4E8E\u6211\u4EEC");
		
		Label Label_playing = new Label(MainPlayer, SWT.NONE);
		Label_playing.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label_playing.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_playing.setAlignment(SWT.CENTER);
		Label_playing.setBounds(32, 25, 98, 28);
		Label_playing.setText("\u64AD\u653E\u5217\u8868");
		
		List List_playlist = new List(MainPlayer, SWT.NONE);
		List_playlist.setBackground(SWTResourceManager.getColor(255, 230, 230));
		List_playlist.setItems(new String[] {"AAAA", "BBB", "CCCC", "SSSS"});
		
		List_playlist.setBounds(10, 64, 132, 294);
		
		Label Label_song = new Label(MainPlayer, SWT.NONE);
		Label_song.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_song.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
		Label_song.setAlignment(SWT.CENTER);
		Label_song.setBounds(199, 23, 267, 28);
		Label_song.setText("\u6B4C\u66F2\u540D");
		
		Label Label_singer = new Label(MainPlayer, SWT.NONE);
		Label_singer.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_singer.setAlignment(SWT.CENTER);
		Label_singer.setBounds(280, 68, 109, 17);
		Label_singer.setText("\u6B4C\u624B-\u4E13\u8F91");
		
		Label Label_poster = new Label(MainPlayer, SWT.NONE);
		Label_poster.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Label_poster.setImage(SWTResourceManager.getImage("C:\\Users\\Adminisator\\Desktop\\\u70AB\u821E\u5927\u4E16\u754C\\\u5934\u50CF\\40A57222538CCAC8097F90F4753BF8A3.jpg"));
		Label_poster.setBounds(174, 146, 150, 150);
		
		Label lblNewLabel_4 = formToolkit.createLabel(MainPlayer, "New Label", SWT.NONE);
		lblNewLabel_4.setBounds(411, 119, -26, -18);
		
		Combo combo = new Combo(MainPlayer, SWT.READ_ONLY);
		combo.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		combo.setBackground(SWTResourceManager.getColor(255, 204, 204));
		combo.setItems(new String[] {"\u987A\u5E8F\u64AD\u653E", "\u5355\u66F2\u5FAA\u73AF", "\u5217\u8868\u5FAA\u73AF"});
		combo.setBounds(354, 428, 88, 25);
		formToolkit.adapt(combo);
		formToolkit.paintBordersFor(combo);
		combo.setText("\u64AD\u653E\u6A21\u5F0F");
		
		Label Label_btn_PLAY = new Label(MainPlayer, SWT.NONE);
		Label_btn_PLAY.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		Label_btn_PLAY.setBounds(230, 415, 50, 51);
		formToolkit.adapt(Label_btn_PLAY, true, true);
		BtnListener.btn_listen_play(Label_btn_PLAY,"PLAY","PAUSE");
		Label Label_btn_LAST = new Label(MainPlayer, SWT.NONE);
		Label_btn_LAST.setBounds(174, 418, 50, 51);
		formToolkit.adapt(Label_btn_LAST, true, true);
		BtnListener.btn_listen(Label_btn_LAST,"LAST");
		Label Label_btn_NEXT = new Label(MainPlayer, SWT.NONE);
		Label_btn_NEXT.setBounds(287, 418, 50, 51);
		formToolkit.adapt(Label_btn_NEXT, true, true);
		BtnListener.btn_listen(Label_btn_NEXT,"NEXT");
		
		ListViewer listViewer = new ListViewer(MainPlayer, SWT.NONE | SWT.V_SCROLL);
		List List_lyrics = listViewer.getList();
		List_lyrics.setItems(new String[] {"1111", "2222"});
		List_lyrics.setBackground(SWTResourceManager.getColor(255, 230, 230));
		List_lyrics.setBounds(354, 115, 169, 243);
		
		Slider slider = new Slider(MainPlayer, SWT.BORDER);
		slider.setPageIncrement(0);
		slider.setMaximum(255);
		slider.setMinimum(200);
		slider.setSelection(255);
		slider.setForeground(SWTResourceManager.getColor(255, 204, 255));
		slider.setBackground(SWTResourceManager.getColor(255, 204, 255));
		slider.setBounds(10, 381, 513, 17);
		formToolkit.adapt(slider, true, true);

	}
	
	public void end() {
		MainPlayer.close();
	}
}
