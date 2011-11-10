package jp.eisbahn.android.sdk.wrapper.common;

import org.json.JSONObject;

/**
 * 公開範囲の情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Privacy extends Model {

    /**
     * このインスタンスを初期化します.
     * @param newOriginal JSONオブジェクト
     */
    public Privacy(final JSONObject newOriginal) {
        super(newOriginal);
    }

    /**
     * 公開範囲を取得します.
     * @return 公開範囲
     */
    public final Visibility getVisibility() {
        return Visibility.valueOf(getPropertyString("visibility"));
    }

}
