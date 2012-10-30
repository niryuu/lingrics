package org.niryuu.lingrics;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;

import com.loopj.android.http.*;

public class Lingr {
	public Boolean mIsAuthenticated = false;
	protected String mSession = null;;
	protected ArrayList<HashMap<String, Room>> mRooms;
	protected JSONArray mChatData;

	public Lingr() {
	}

	public Boolean authenticate(String user, String password) {
		RequestParams params = new RequestParams();
		params.put("user", user);
		params.put("password", password);
		LingrClient.post("session/create", params,
				new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject result) {
						try {
							if ("ok" == result.getString("status")) {
								mSession = result.getString("session");
							} else {
								mSession = null;
							}
						} catch (JSONException e) {
							mSession = null;
						}
					}
				});
		return mSession == null;
	}

	public Boolean destroySession() {
		return false;
	}

	public ArrayList<Room> getRooms() {
		return null;
	}

	public ArrayList<Talk> getContents(String roomId) {
		return null;
	}
}
