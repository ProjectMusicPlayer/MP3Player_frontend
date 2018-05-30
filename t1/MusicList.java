package test.yubei.com.app.t1;

import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.List;
import org.json.JSONException;
import org.json.JSONObject;

import test.yubei.com.app.api.DoGet;

public class MusicList {
	static MusicInfo[] storege;
	static int[] storegeI;
	
	static MusicInfo[] playlist;
	static int[] playlistI;
	
	static MusicInfo playNow;
	static int playNowIndex;
	
	public static void creatStorage(int[] ii) {
		int len = ii.length;
		storege = new MusicInfo[len];
		storegeI = new int[len];
		for(int i=0;i<len;i++) {
			storege[i] = MusicInfo.creat(ii[i]);
			storegeI[i] = ii[i];
		}
		System.out.println("done");
	}

	public static void addMusicToPlayList(int index,List l) {
		if(MusicList.playlist==null) {
			MusicList.playlist = new MusicInfo[0];
		}
		MusicInfo[] temp = MusicList.playlist;
		MusicInfo[] newer = new MusicInfo[MusicList.playlist.length+1];
		int i;
		for(i=0;i<temp.length;i++) {
			if(index == temp[i].id) {
				return;//重复添加则退出
			}
			newer[i] = temp[i];
		}
		newer[i] = MusicList.storege[index];
		MusicList.playlist = newer;
		MusicList.refreshPlayList(l);
		
	}
	
	public static void refreshPlayList(List l) {
		l.removeAll();
		for(int i=0;i<MusicList.playlist.length;i++) {
			l.add(MusicList.playlist[i].name+";"+MusicList.playlist[i].singer);
		}
	}
}

class MusicInfo{
	int id;
	String name;
	String singer;
	String books;
	int length;
	
	public static MusicInfo creat(int id) {
		MusicInfo m = new MusicInfo();
		//从接口里抓数据，赋值给m
		String api = "https://api.mp3.h-00.com/v1/mp3/id?id="+id;
		JSONObject json = DoGet.doGetHJ(api, User.token);
		try {
			if(json.getInt("error")==0) {
				JSONObject js = json.getJSONObject("data");
				m.id = js.getInt("id");
				m.name = js.getString("name");
				m.singer = js.getString("singer");
				m.books = js.getString("books");
				m.length = js.getInt("length");
			}else {
				JOptionPane.showMessageDialog(null, json.getString("msg"),"提示", JOptionPane.WARNING_MESSAGE);
			}
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return m;
		
	}
	
	public static JSONObject getMusicInfoById(int id) {
		return null;
		
	}
	
}

