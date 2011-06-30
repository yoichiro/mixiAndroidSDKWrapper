package jp.eisbahn.android.sdk.wrapper.people;

import jp.eisbahn.android.sdk.wrapper.Model;

import org.json.JSONObject;

/**
 * ユーザのプロフィール情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Person extends Model {

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
        return getPropertyString("id");
    }

    /**
     * ニックネームを返します.
     * @return ニックネーム
     */
    public String getDisplayName() {
        return getPropertyString("displayName");
    }

    /**
     * プロフィール画像のURLを返します.
     * @return プロフィール画像のURL
     */
    public String getThumbnailUrl() {
        return getPropertyString("thumbnailUrl");
    }

    /**
     * プロフィールページのURLを返します.
     * @return プロフィールページのURL
     */
    public String getProfileUrl() {
        return getPropertyString("profileUrl");
    }

}
