package jp.eisbahn.android.sdk.wrapper.voice;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.common.Model;

/**
 * ユーザに関する情報を持つモデルクラスです.
 * @author Yoichiro Tanaka
 */
public class User extends Model {

    /**
     * このインスタンスを初期化します.
     * @param original 情報を持つJSONオブジェクト.
     */
    protected User(final JSONObject original) {
        super(original);
    }

    /**
     * IDを返します.
     * @return ID.
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * ニックネームを返します.
     * @return ニックネーム.
     */
    public final String getScreenName() {
        return getPropertyString("screen_name");
    }

    /**
     * プロフィール画像のURLを返します.
     * @return プロフィール画像のURL.
     */
    public final String getProfileImageUrl() {
        return getPropertyString("profile_image_url");
    }

    /**
     * プロフィールページのURLを返します.
     * @return プロフィールページのURL.
     */
    public final String getUrl() {
        return getPropertyString("url");
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return "User [getId()=" + getId() + ", getScreenName()="
                + getScreenName() + ", getProfileImageUrl()="
                + getProfileImageUrl() + ", getUrl()=" + getUrl() + "]";
    }

}
