package jp.eisbahn.android.sdk.wrapper.voice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.Model;

/**
 * このクラスはVoice APIにて扱われる情報の共通的な処理を持つ抽象クラスです.
 * @author Yoichiro Tanaka
 */
public abstract class AbstractVoiceModel extends Model {

    /** createAt属性をパースするためのDateFormat. */
    private static final String DATE_FORMAT = "EEE MMM dd HH:mm:ss Z yyyy";

    /** ユーザオブジェクト. */
    private User user;

    /**
     * このインスタンスを初期化します.
     * @param original 情報を持つJSONオブジェクト.
     */
    public AbstractVoiceModel(final JSONObject original) {
        super(original);
        user = new User(getPropertyJSONObject("user"));
    }

    /**
     * IDを返します.
     * @return ID文字列.
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * createAt属性値を返します.
     * @return createAt属性値.
     * @throws ParseException 日付文字列が不正だったとき.
     */
    public final Date getCreatedAt() throws ParseException {
        String createdAt = getPropertyString("created_at");
        if (createdAt != null) {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.US);
            Date date = format.parse(createdAt);
            return date;
        } else {
            return null;
        }
    }

    /**
     * text属性値を返します.
     * @return text属性値 .
     */
    public final String getText() {
        return getPropertyString("text");
    }

    /**
     * ユーザに関する情報を持つオブジェクトを返します.
     * @return ユーザに関する情報を持つオブジェクト.
     */
    public final User getUser() {
        return user;
    }

}
