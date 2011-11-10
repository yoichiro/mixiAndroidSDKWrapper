package jp.eisbahn.android.sdk.wrapper.common;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * ユーザ情報の取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetUsersCallbackHandler extends CallbackAdapter {

    /** 総取得可能件数. */
    private int totalResults;

    /** 今回要求分に関する取得件数. */
    private int itemsPerPage;

    /** 開始インデックス. */
    private int startIndex;

    /** ユーザ情報のコレクション. */
    private List<User> users;

    /**
     * このインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetUsersCallbackHandler(final Context newContext) {
        super(newContext);
    }

    @Override
    public void onComplete(final Bundle values) {
        try {
            String response = values.getString("response");
            JSONObject root = new JSONObject(response);
            totalResults = root.getInt("totalResults");
            itemsPerPage = root.getInt("itemsPerPage");
            startIndex = root.getInt("startIndex");
            Object entry = root.get("entry");
            if (entry instanceof JSONObject) {
                JSONObject obj = (JSONObject) entry;
                users = new ArrayList<User>();
                users.add(new User(obj));
            } else {
                JSONArray array = (JSONArray) entry;
                users = new ArrayList<User>();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    users.add(new User(obj));
                }
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching photos failed. " + e.getMessage());
        }
    }

    /**
     * 総取得可能件数を返します.
     * @return 総取得可能件数
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * 今回要求分に関する取得件数を返します.
     * @return 今回要求分に関する取得件数
     */
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    /**
     * 開始インデックスを返します.
     * @return 開始インデックス
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * ユーザ情報のコレクションを返します.
     * @return ユーザ情報のコレクション
     */
    public List<User> getUsers() {
        return users;
    }

}
