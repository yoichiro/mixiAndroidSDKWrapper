package jp.eisbahn.android.sdk.wrapper.message;

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
 * メッセージ情報の取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetMessagesCallbackHandler extends CallbackAdapter {

    /** 総取得可能件数. */
    private int totalResults;

    /** 今回要求分に関する取得件数. */
    private int itemsPerPage;

    /** 開始インデックス. */
    private int startIndex;

    /** メッセージ情報のコレクション. */
    private List<Message> messages;

    /** メッセージに関係するユーザの種別. */
    private String relatedUserType;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetMessagesCallbackHandler(final Context newContext) {
        super(newContext);
    }

    /**
     * メッセージに関係するユーザの種別をセットします.
     * @param relatedUserType メッセージに関係するユーザの種別
     */
    void setRelatedUserType(final String relatedUserType) {
        this.relatedUserType = relatedUserType;
    }

    /**
     * メッセージに関係するユーザの種別を返します.
     * @return メッセージに関係するユーザの種別
     */
    String getRelatedUserType() {
        return relatedUserType;
    }

    @Override
    public void onComplete(final Bundle values) {
        if (relatedUserType == null) {
            throw new IllegalStateException("relatedUserType not set.");
        }
        try {
            String response = values.getString("response");
            JSONObject root = new JSONObject(response);
            totalResults = root.getInt("totalResults");
            itemsPerPage = root.getInt("itemsPerPage");
            startIndex = root.getInt("startIndex");
            Object entry = root.get("entry");
            if (entry instanceof JSONObject) {
                JSONObject obj = (JSONObject) entry;
                messages = new ArrayList<Message>();
                messages.add(new Message(obj, relatedUserType));
            } else {
                JSONArray array = (JSONArray) entry;
                messages = new ArrayList<Message>();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    messages.add(new Message(obj, relatedUserType));
                }
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching people failed. " + e.getMessage());
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
     * メッセージ情報のコレクションを返します.
     * @return メッセージ情報のコレクション
     */
    public List<Message> getMessages() {
        return messages;
    }

}
