package test.yubei.com.app.t1;

import java.io.IOException;

import org.eclipse.swt.widgets.List;

public class ScreenController {

	public static boolean f_list = false;
	public static boolean f_search = false;
	public static boolean f_aboutus = false;
	public static boolean f_regisitor = false;
	public static boolean f_forget = false;
	public static boolean f_pswd = false;
	
	
	public static void init() {
		//正常模式，开login
		ScreenLogin.main(null);
	}
	
	public static void login(ScreenLogin s,String user) {
		s.end();
		try {
			ScreenPlayer.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void login_DEBUG(ScreenLogin s) {
		try {
			ScreenLogin.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void list(List s) {
		if(!f_list) {
			f_list = true;
			ScreenList.main(s);
		}

	}
	
	public static void search() {
		if(!f_search) {
			f_search = true;
			ScreenSearch.main(null);			
		}

	}

	public static void aboutus() {
		if(!f_aboutus) {
			f_aboutus = true;
			ScreenAboutUs.main(null);	
		}

	}
	
	public static void regisitor() {
		if(!f_regisitor) {
			f_regisitor = true;
			ScreenRegister.main(null);
		}
		
	}
	
	public static void player() {
		try {
			ScreenPlayer.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void forget() {
		if(!f_forget) {
			f_forget = true;
			ScreenForget.main(null);
		}
	}
	
	public static void pswd() {
		if(!f_pswd) {
			f_pswd = true;
			ScreenPswd.main(null);
		}
	}
	
	public static void openWebsite(String url) {
		if(java.awt.Desktop.isDesktopSupported()) {
			java.net.URI uri = java.net.URI.create(url);
			java.awt.Desktop dp = java.awt.Desktop.getDesktop();
			if(dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					dp.browse(uri);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
//	
	public static void signout() {
		ScreenLogin.main(null);
	}
	
	public static void closeAll() {
		
	}
}
