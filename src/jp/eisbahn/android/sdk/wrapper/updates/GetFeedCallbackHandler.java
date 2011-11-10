package jp.eisbahn.android.sdk.wrapper.updates;

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
 * フィードの取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetFeedCallbackHandler extends CallbackAdapter {

    /** エントリ情報のコレクション. */
    private List<Entry> entries;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetFeedCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONObject root = new JSONObject(response);
            Object entriesObj = root.get("items");
            if (entriesObj instanceof JSONArray) {
                JSONArray array = (JSONArray) entriesObj;
                entries = new ArrayList<Entry>();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject entry = array.getJSONObject(i);
                    entries.add(new Entry(entry));
                }
            } else if (entriesObj instanceof JSONObject) {
                entries = new ArrayList<Entry>();
                entries.add(new Entry((JSONObject) entriesObj));
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching entries failed. " + e.getMessage());
        }
    }

    /**
     * エントリ情報のコレクションを返します.
     * @return エントリ情報のコレクション
     */
    public List<Entry> getEntries() {
        return entries;
    }

}
