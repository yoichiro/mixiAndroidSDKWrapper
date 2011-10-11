package jp.eisbahn.android.sdk.wrapper.checkin;


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
 * チェックイン履歴情報の取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetCheckinsCallbackHandler extends CallbackAdapter {

    /** 今回要求分に関する取得件数. */
    private int itemsPerPage;

    /** チェックイン履歴情報のコレクション. */
    private List<Checkin> checkins;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetCheckinsCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONObject root = new JSONObject(response);
            itemsPerPage = root.getInt("itemsPerPage");
            Object entry = root.get("entry");
            if (entry instanceof JSONObject) {
                JSONObject obj = (JSONObject) entry;
                checkins = new ArrayList<Checkin>();
                checkins.add(new Checkin(obj));
            } else {
                JSONArray array = (JSONArray) entry;
                checkins = new ArrayList<Checkin>();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    checkins.add(new Checkin(obj));
                }
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching check-ins failed. " + e.getMessage());
        }
    }

    /**
     * 今回要求分に関する取得件数を返します.
     * @return 今回要求分に関する取得件数
     */
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    /**
     * チェックイン履歴情報のコレクションを返します.
     * @return チェックイン履歴情報のコレクション
     */
    public List<Checkin> getCheckins() {
        return checkins;
    }

}
