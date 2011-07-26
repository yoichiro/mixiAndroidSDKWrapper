package jp.eisbahn.android.sdk.wrapper.groups;

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
 * グループ情報の取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetGroupsCallbackHandler extends CallbackAdapter {

    /** 総取得可能件数. */
    private int totalResults;

    /** 今回要求分に関する取得件数. */
    private int itemsPerPage;

    /** 開始インデックス. */
    private int startIndex;

    /** グループ情報のコレクション. */
    private List<Group> groups;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetGroupsCallbackHandler(final Context newContext) {
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
                groups = new ArrayList<Group>();
                groups.add(new Group(obj));
            } else {
                JSONArray array = (JSONArray) entry;
                groups = new ArrayList<Group>();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    groups.add(new Group(obj));
                }
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching groups failed. " + e.getMessage());
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
     * グループ情報のコレクションを返します.
     * @return グループ情報のコレクション
     */
    public List<Group> getGroups() {
        return groups;
    }

}
