package jp.eisbahn.android.sdk.wrapper.checkin;

import org.json.JSONObject;

/**
 * 住所を含む位置情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Address extends Location {

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Address(final JSONObject original) {
        super(original);
    }

    /**
     * 住所を返します.
     * @return 住所
     */
    public final String getFormatted() {
        return getPropertyString("formatted");
    }

}
