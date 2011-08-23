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
 * mixiボイスのつぶやきへのコメントの取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetCommentsCallbackHandler extends CallbackAdapter {

    /** コメント情報のコレクション. */
    private List<Comment> comments;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetCommentsCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONArray root = new JSONArray(response);
            comments = new ArrayList<Comment>();
            for (int i = 0; i < root.length(); i++) {
                JSONObject obj = root.getJSONObject(i);
                comments.add(new Comment(obj));
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching comments failed. " + e.getMessage());
        }
    }

    /**
     * コメント情報のコレクションを返します.
     * @return コメント情報のコレクション
     */
    public List<Comment> getComments() {
        return comments;
    }

}
