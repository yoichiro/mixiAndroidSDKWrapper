package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.checkin.GetSpotCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.checkin.GetSpotsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.checkin.GetSpotsParams;
import jp.eisbahn.android.sdk.wrapper.checkin.SearchSpotsParams;
import jp.eisbahn.android.sdk.wrapper.checkin.SpotField;


/**
 * Check-in API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface CheckinAPI {

    /**
     * 指定されたスポットIDのスポット情報を取得します.
     * @param spotId スポットID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSpot(String spotId, GetSpotCallbackHandler handler);

    /**
     * 指定されたスポットIDのスポット情報を取得します.
     * @param spotId スポットID
     * @param fields 取得したい項目
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSpot(String spotId, SpotField[] fields,
            GetSpotCallbackHandler handler);

    /**
     * 指定された条件でスポットを検索します.
     * @param latitude 緯度
     * @param longitude 軽度
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void searchSpots(double latitude, double longitude,
            GetSpotsCallbackHandler handler);

    /**
     * 指定された条件でスポットを検索します.
     * @param params 条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void searchSpots(SearchSpotsParams params,
            GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザが作成したスポット情報を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMySpots(GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザが作成したスポット情報を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMySpots(GetSpotsParams params, GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザのある友人が作成したスポット情報を取得します.
     * @param userId 友人のユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendSpots(String userId, GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザのある友人が作成したスポット情報を取得します.
     * @param userId 友人のユーザID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendSpots(String userId, GetSpotsParams params,
            GetSpotsCallbackHandler handler);

    /**
     * 新規にマイスポットを作成します.
     * @param name スポット名
     * @param description スポットの説明
     * @param latitude 緯度
     * @param longitude 軽度
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void createSpot(String name, String description, double latitude,
            double longitude, GetIdCallbackHandler handler);

    /**
     * マイスポットを削除します.
     * @param spotId スポットID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteSpot(String spotId, CallbackAdapter handler);
}
