package jp.eisbahn.android.sdk.wrapper.people.image;


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
 * プロフィール画像の取得結果を受け取り提供するためのコールバックハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetProfileImagesCallbackHandler extends CallbackAdapter {

    /** 総取得可能件数. */
    private int totalResults;

    /** 今回要求分に関する取得件数. */
    private int itemsPerPage;

    /** 開始インデックス. */
    private int startIndex;

    /** プロフィール画像のコレクション. */
    private List<ProfileImage> profileImages;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public GetProfileImagesCallbackHandler(final Context newContext) {
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
                profileImages = new ArrayList<ProfileImage>();
                profileImages.add(new ProfileImage(obj));
            } else {
                JSONArray array = (JSONArray) entry;
                profileImages = new ArrayList<ProfileImage>();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    profileImages.add(new ProfileImage(obj));
                }
            }
            super.onComplete(values);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            alert("Error", "Fetching profile image failed. " + e.getMessage());
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
     * プロフィール画像のコレクションを返します.
     * @return プロフィール画像のコレクション
     */
    public List<ProfileImage> getProfileImages() {
        return profileImages;
    }

}
