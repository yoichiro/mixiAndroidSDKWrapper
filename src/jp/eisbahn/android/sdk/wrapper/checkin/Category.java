package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.Model;

import org.json.JSONObject;

/**
 * カテゴリ情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Category extends Model {

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Category(final JSONObject original) {
        super(original);
    }

    /**
     * カテゴリ名を返します.
     * @return カテゴリ名
     */
    public final String getFormatted() {
        return getPropertyString("formatted");
    }

}
