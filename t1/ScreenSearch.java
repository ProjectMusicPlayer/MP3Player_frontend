package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.json.JSONException;
import org.json.JSONObject;

import test.yubei.com.app.api.DoGet;
import test.yubei.com.app.api.DoPost;
import test.yubei.com.app.api.Error;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.ProgressBar;

public class ScreenSearch {

	protected Shell MainSearch;
	private Text text_search;
	boolean flag = false;	//标记是否选中
	int num = 0;	//记录是list中的第几首
	Mp3[] m;
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
		List_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				flag = true;
				num = List_list.getSelectionIndex();	
			}
		});
		List_list.setItems(new String[] {});
		List_list.setBackground(SWTResourceManager.getColor(255, 230, 230));
		List_list.setBounds(27, 116, 461, 310);
		
		Label Label_search = new Label(MainSearch, SWT.NONE);
		Label_search.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.BOLD));
		Label_search.setBackground(SWTResourceManager.getColor(255, 204, 204));
		Label_search.setAlignment(SWT.CENTER);
		Label_search.setBounds(204, 32, 105, 23);
		Label_search.setText("\u5728\u7EBF\u641C\u7D22");
		
		Label Label_btn_search = new Label(MainSearch, SWT.NONE);
		Label_btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				String search_content = text_search.getText();
				String api = "https://api.mp3.h-00.com/v1/mp3s?key="+search_content;
				JSONObject js = DoGet.doGetHJ(api,User.token);
				
				try {
					if(js.getInt("error")!=0) {
						JOptionPane.showMessageDialog(null, js.getString("msg"),"提示", JOptionPane.WARNING_MESSAGE);
					}else {
						int count= js.getInt("arrayLength");
						if(count==0) {
							JOptionPane.showMessageDialog(null, "无搜索结果","提示", JOptionPane.WARNING_MESSAGE);
						}else {
							m = new Mp3[count]; 
							//把结果显示在list上
							for(int i=0;i<count;i++) {
								m[i] = new Mp3();
								JSONObject json = js.getJSONObject("data").getJSONObject(String.valueOf(i));
								m[i].name  = json.getString("name");
								m[i].singer = json.getString("singer");
								m[i].books = json.getString("books");
								m[i].length = json.getInt("length");
								m[i].id = json.getInt("id");
								m[i].lrcAddress = json.getString("lrcaddress");
								m[i].mp3Address = json.getString("mp3address");
								List_list.add(String.format("%20s-%20s",m[i].name,m[i].singer));
							}
						}
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
		Label_btn_search.setBounds(408, 67, 100, 36);
		Label_btn_search.setText("New Label");
		BtnListener.btn_listen(Label_btn_search, "SEARCH");
		
		Label Label_btn_return = new Label(MainSearch, SWT.NONE);
		Label_btn_return.setText("New Label");
		Label_btn_return.setBounds(385, 432, 100, 36);
		BtnListener.btn_listen(Label_btn_return, "RETURN");
		
		Label Label_btn_download = new Label(MainSearch, SWT.NONE);
		Label_btn_download.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(flag) {
					try {
						Progress.main(m[num].lrcAddress, User.username,m[num].id,"mp3","wav");
						Progress.main(m[num].mp3Address, User.username,m[num].id,"lrc","txt");
						//Download.downLoadFromUrl(m[num].lrcAddress, User.username,m[num].id,"mp3","wav");
						//Download.downLoadFromUrl(m[num].mp3Address, User.username,m[num].id,"lrc","txt");
						JOptionPane.showMessageDialog(null,"下载完成","提示", JOptionPane.WARNING_MESSAGE);
						MainSearch.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		Label_btn_download.setText("New Label");
		Label_btn_download.setBounds(268, 432, 100, 36);
		BtnListener.btn_listen(Label_btn_download, "DOWNLOAD");
	}
}
