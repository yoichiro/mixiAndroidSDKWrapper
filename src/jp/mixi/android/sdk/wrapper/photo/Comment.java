package jp.mixi.android.sdk.wrapper.photo;

import java.text.ParseException;

import java.util.Date;

import org.json.JSONObject;

import jp.mixi.android.sdk.wrapper.Model;
import jp.mixi.android.sdk.wrapper.User;
import jp.mixi.android.sdk.wrapper.util.DateUtils;

/**
 * コメントの情報を持つクラスです.
 * @author Yoichiro Tanaka
 */
public class Comment extends Model {

    /** ユーザの情報を持つオブジェクト. */
    private User user;

    /**
     * このインスタンスを初期化します.
     * @param newOriginal JSONオブジェクト
     */
    protected Comment(final JSONObject newOriginal) {
        super(newOriginal);
        user = new User(getPropertyJSONObject("user"));
    }

    /**
     * IDを返します.
     * @return ID
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * createAt属性値を返します.
     * @return コメント投稿日時
     * @throws ParseException パースに失敗したとき
     */
    public final Date getCreatedAt() throws ParseException {
        String createdAt = getPropertyString("created");
        if (createdAt != null) {
            return DateUtils.convertDate(createdAt);
        } else {
            return null;
        }
    }

    /**
     * コメント本文を返します.
     * @return コメント本文.
     */
    public final String getText() {
        return getPropertyString("text");
    }

    /**
     * 投稿者の情報を返します.
     * @return 投稿者の情報
     */
    public final User getUser() {
        return user;
    }

}
