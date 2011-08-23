package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.ArrayList;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * mixiボイスのつぶやきへのイイネの取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetUsersCallbackHandler extends CallbackAdapter {

    /** イイネをしたユーザ情報のコレクション. */
    private List<User> users;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetUsersCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONArray root = new JSONArray(response);
            users = new ArrayList<User>();
            for (int i = 0; i < root.length(); i++) {
                JSONObject obj = root.getJSONObject(i);
                users.add(new User(obj));
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching users failed. " + e.getMessage());
        }
    }

    /**
     * イイネをしたユーザ情報のコレクションを返します.
     * @return イイネをしたユーザ情報のコレクション
     */
    public List<User> getUsers() {
        return users;
    }

}
