package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.common.CallbackAdapter;

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
public class GetCheckinCallbackHandler extends CallbackAdapter {

    /** チェックイン履歴情報. */
    private Checkin checkin;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetCheckinCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONObject root = new JSONObject(response);
            checkin = new Checkin(root);
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching check-in failed. " + e.getMessage());
        }
    }

    /**
     * チェックイン履歴情報を返します.
     * @return チェックイン履歴情報
     */
    public Checkin getCheckin() {
        return checkin;
    }

}
