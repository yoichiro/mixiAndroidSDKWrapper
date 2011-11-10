package jp.eisbahn.android.sdk.wrapper.voice;


import java.util.ArrayList;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.common.CallbackAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * mixiボイスのつぶやきの取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetStatusesCallbackHandler extends CallbackAdapter {

    /** つぶやき情報のコレクション. */
    private List<Status> statuses;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetStatusesCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONArray root = new JSONArray(response);
            statuses = new ArrayList<Status>();
            for (int i = 0; i < root.length(); i++) {
                JSONObject obj = root.getJSONObject(i);
                statuses.add(new Status(obj));
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching statuses failed. " + e.getMessage());
        }
    }

    /**
     * つぶやき情報のコレクションを返します.
     * @return つぶやき情報のコレクション
     */
    public List<Status> getStatuses() {
        return statuses;
    }

}
