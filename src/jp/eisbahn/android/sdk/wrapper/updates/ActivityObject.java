package jp.eisbahn.android.sdk.wrapper.updates;

import java.text.ParseException;
import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.common.Model;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

/**
 * Activity Objectを表すモデルクラスです.
 * @author Yoichiro Tanaka
 */
public class ActivityObject extends Model {

    /**
     * このインスタンスを初期化します.
     * @param newOriginal JSONオブジェクト
     */
    public ActivityObject(final JSONObject newOriginal) {
        super(newOriginal);
    }

    /**
     * link属性値を返します.
     * @return link属性値
     */
    public final String getLink() {
        return getPropertyString("link");
    }

    /**
     * postedTime属性値を返します.
     * @return postedTime属性値
     * @throws ParseException もし書式のパースに失敗したとき
     */
    public final Date getPostedTime() throws ParseException {
        String postedTime = getPropertyString("postedTime");
        if (postedTime != null) {
            return DateUtils.convertDate(postedTime);
        } else {
            return null;
        }
    }

    /**
     * Object type属性値を返します.
     * @return Object type属性値
     */
    public final String getObjectType() {
        return getPropertyString("objectType");
    }

    /**
     * 追加情報をJSONObjectオブジェクトとして返します.
     * @param key 属性を特定するためのキー
     * @return 追加情報
     */
    public final JSONObject getExtendedInfoAsJson(final String key) {
        return getPropertyJSONObject(key);
    }

    /**
     * 追加情報を文字列として返します.
     * @param key 属性を特定するためのキー
     * @return 追加情報
     */
    public final String getExtendedInfoAsString(final String key) {
        return getPropertyString(key);
    }

    /**
     * IDを返します.
     * @return ID文字列
     */
    public final String getId() {
        return getPropertyString("id");
    }

}
