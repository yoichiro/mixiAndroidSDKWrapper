package jp.eisbahn.android.sdk.wrapper.updates;

import java.text.ParseException;
import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.Model;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

/**
 * フィードを表すモデルクラスです.
 * @author Yoichiro Tanaka
 */
public class Entry extends Model {

    /** Activity Object. */
    private ActivityObject object;

    /** アクター. */
    private ActivityObject actor;

    /**
     * このインスタンスを初期化します.
     * @param newOriginal JSONオブジェクト.
     */
    public Entry(final JSONObject newOriginal) {
        super(newOriginal);
        object = new ActivityObject(getPropertyJSONObject("object"));
        actor = new ActivityObject(getPropertyJSONObject("actor"));
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
     * 動詞を返します.
     * @return verb属性値
     */
    public final String getVerb() {
        return getPropertyString("verb");
    }

    /**
     * IDを返します.
     * @return ID文字列
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * タイトルを返します.
     * @return タイトル文字列
     */
    public final String getTitle() {
        return getPropertyString("title");
    }

    /**
     * Activity Objectオブジェクトを返します.
     * @return Activity Objectオブジェクト
     */
    public final ActivityObject getObject() {
        return object;
    }

    /**
     * アクターを返します.
     * @return アクター
     */
    public final ActivityObject getActor() {
        return actor;
    }

}
