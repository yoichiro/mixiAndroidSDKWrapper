package jp.eisbahn.android.sdk.wrapper.message;

import java.text.ParseException;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.common.Model;
import jp.eisbahn.android.sdk.wrapper.common.User;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

/**
 * メッセージの内容を持つモデルクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Message extends Model {

    /** このメッセージに関係するユーザの情報. */
    private User user;

    /**
     * 指定されたオブジェクトでこのインスタンスを初期化します.
     * @param newOriginal JSONオブジェクト
     * @param userPropertyName このメッセージに関係するユーザの情報を持つ属性名
     */
    protected Message(final JSONObject newOriginal,
            final String userPropertyName) {
        super(newOriginal);
        user = new User(getPropertyJSONObject(userPropertyName));
    }

    /**
     * メッセージIDを返します.
     * @return メッセージID
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * ステータスを返します.
     * @return このメッセージのステータス
     */
    public final Status getStatus() {
        String status = getPropertyString("status");
        if (status.equals("new")) {
            status = "unread";
        }
        return Status.valueOf(status);
    }

    /**
     * 送信日時を返します.
     * @return 送信日時.
     * @throws ParseException 日時の書式が不正だったとき
     */
    public final Date getTimeSent() throws ParseException {
        String timeSent = getPropertyString("timeSent");
        if (timeSent != null) {
            return DateUtils.convertDate(timeSent);
        } else {
            return null;
        }
    }

    /**
     * タイトルを返します.
     * @return タイトル.
     */
    public final String getTitle() {
        return getPropertyString("title");
    }

    /**
     * 本文を返します.
     * @return 本文.
     */
    public final String getBody() {
        return getPropertyString("body");
    }

    /**
     * このメッセージに関係するユーザの情報を返します.
     * @return このメッセージに関係するユーザの情報
     */
    public final User getUser() {
        return user;
    }

}
