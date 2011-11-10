package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.common.Model;

import org.json.JSONObject;

/**
 * 位置情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Location extends Model {

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Location(final JSONObject original) {
        super(original);
    }

    /**
     * 緯度を返します.
     * @return 緯度
     */
    public final double getLatitude() {
        return getPropertyDouble("latitude");
    }

    /**
     * 軽度を返します.
     * @return 軽度
     */
    public final double getLongitude() {
        return getPropertyDouble("longitude");
    }

    /**
     * Geohashを返します.
     * @return Geohash
     */
    public final String getGeohash() {
        return getPropertyString("geohash");
    }

    /**
     * 距離を返します.
     * @return 距離
     */
    public final double getDistance() {
        return getPropertyDouble("distance");
    }

}
