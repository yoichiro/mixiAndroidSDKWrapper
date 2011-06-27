package jp.mixi.android.sdk.wrapper.people;

import jp.mixi.android.sdk.wrapper.Entity;

import org.json.JSONObject;

/**
 * ユーザのプロフィール情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Person extends Entity {

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Person(final JSONObject original) {
        super(original);
    }

    /**
     * IDを返します.
     * @return ID
     */
    public String getId() {
        return getString("id");
    }

    /**
     * ニックネームを返します.
     * @return ニックネーム
     */
    public String getDisplayName() {
        return getString("displayName");
    }

    /**
     * プロフィール画像のURLを返します.
     * @return プロフィール画像のURL
     */
    public String getThumbnailUrl() {
        return getString("thumbnailUrl");
    }

    /**
     * プロフィールページのURLを返します.
     * @return プロフィールページのURL
     */
    public String getProfileUrl() {
        return getString("profileUrl");
    }

}
