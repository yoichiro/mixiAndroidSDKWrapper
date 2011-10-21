package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.CheckinAPI;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.util.StringUtils;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Check-in APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class CheckinProxyImpl extends AbstractProxyImpl implements CheckinAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public CheckinProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getSpot(final String spotId,
            final GetSpotCallbackHandler handler) {
        getContainer().send("/spots/" + spotId, handler);
    }

    @Override
    public void getSpot(final String spotId, final SpotField[] fields,
            final GetSpotCallbackHandler handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("fields", StringUtils.convertArrayToStringWithComma(fields));
        getContainer().send("/spots/" + spotId, params, handler);
    }

    @Override
    public void searchSpots(final double latitude, final double longitude,
            final GetSpotsCallbackHandler handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("center",
                Double.toString(latitude) + "," + Double.toString(longitude));
        getContainer().send("/search/spots", params, handler);
    }

    @Override
    public void searchSpots(final SearchSpotsParams params,
            final GetSpotsCallbackHandler handler) {
        getContainer().send("/search/spots",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getMySpots(final GetSpotsCallbackHandler handler) {
        getFriendSpots("@me", handler);
    }

    @Override
    public void getFriendSpots(final String userId,
            final GetSpotsCallbackHandler handler) {
        getContainer().send("/spots/" + userId + "/@self", handler);
    }

    @Override
    public void getMySpots(final GetSpotsParams params,
            final GetSpotsCallbackHandler handler) {
        getFriendSpots("@me", params, handler);
    }

    @Override
    public void getFriendSpots(final String userId, final GetSpotsParams params,
            final GetSpotsCallbackHandler handler) {
        getContainer().send("/spots/" + userId + "/@self",
                params.convertParameterMap(), handler);
    }

    @Override
    public void createSpot(final String name, final String description,
            final double latitude, final double longitude,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("name", name);
            JSONObject location = new JSONObject();
            location.put("latitude", String.valueOf(latitude));
            location.put("longitude", String.valueOf(longitude));
            params.put("location", location);
            params.put("description", description);
            getContainer().send("/spots/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteSpot(final String spotId, final CallbackAdapter handler) {
        getContainer().send("/spots/@me/@self/" + spotId, HttpMethod.DELETE,
                handler);
    }

}
