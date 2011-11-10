package jp.eisbahn.android.sdk.wrapper.common;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * 生成結果のIDを受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetIdCallbackHandler extends CallbackAdapter {

    /** ID. */
    private String id;

    /**
     * このインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetIdCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONObject root = new JSONObject(response);
            id = root.getString("id");
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching ID failed. " + e.getMessage());
        }
    }

    /**
     * IDを返します.
     * @return ID
     */
    public String getId() {
        return id;
    }

}
