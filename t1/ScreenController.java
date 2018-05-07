package test.yubei.com.app.t1;

public class ScreenController {

	public static boolean f_list = false;
	public static boolean f_search = false;
	public static boolean f_aboutus = false;
	public static boolean f_regisitor = false;
	public static boolean f_forget = false;
	
	
	public static void init() {
		//debug模式，开debug窗体
		ScreenDebug.main(null);
		//正常模式，开login
		//ScreenLogin.main(null);
	}
	
	public static void login(ScreenLogin s) {
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
	
	public static void list() {
		if(!f_list) {
			f_list = true;
			ScreenList.main(null);
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
//	
	public static void signout() {
		
	}
	
	public static void closeAll() {
		
	}
}
