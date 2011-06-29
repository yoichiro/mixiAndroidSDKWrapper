package jp.mixi.android.sdk.wrapper;

import org.json.JSONObject;

/**
 * ユーザの情報を持つクラスです.
 * @author Yoichiro Tanaka
 */
public class User extends Model {

    /**
     * このインスタンスを初期化します.
     * @param newOriginal JSONオブジェクト
     */
    public User(final JSONObject newOriginal) {
        super(newOriginal);
    }

    /**
     * IDを返します.
     * @return ID
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * ニックネームを返します.
     * @return ニックネーム
     */
    public final String getDisplayName() {
        return getPropertyString("displayName");
    }

    /**
     * プロフィールページのURLを返します.
     * @return プロフィールページのURL
     */
    public final String getProfileUrl() {
        return getPropertyString("profileUrl");
    }

    /**
     * プロフィール画像のURLを返します.
     * @return プロフィール画像のURL
     */
    public final String getThumbnailUrl() {
        return getPropertyString("thumbnailUrl");
    }

}
