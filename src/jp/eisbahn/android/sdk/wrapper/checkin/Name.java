package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.common.Model;

import org.json.JSONObject;

/**
 * 名前情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Name extends Model {

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Name(final JSONObject original) {
        super(original);
    }

    /**
     * 名前を返します.
     * @return 名前
     */
    public final String getFormatted() {
        return getPropertyString("formatted");
    }

}
