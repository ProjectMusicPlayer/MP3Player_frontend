package test.yubei.com.app.api;

public class Error {
	public int errorCode;
	public String errorMsg;
	
	public static Error makeErr(int code,String msg) {
		Error e = new Error();
		e.errorCode = code;
		e.errorMsg = msg;
		return e;
	}
	
}
