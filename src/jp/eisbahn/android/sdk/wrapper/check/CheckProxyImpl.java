package jp.eisbahn.android.sdk.wrapper.check;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.CheckAPI;
import jp.mixi.android.sdk.MixiContainer;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Check APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class CheckProxyImpl extends AbstractProxyImpl implements CheckAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public CheckProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void postCheck(final String key, final String title,
            final String primaryUrl, final CallbackAdapter handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("key", key);
            params.put("title", title);
            params.put("primaryUrl", primaryUrl);
            getContainer().send("/share", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void postCheck(final String key, final String title,
            final String primaryUrl, final PostCheckParams additionals,
            final CallbackAdapter handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("key", key);
            params.put("title", title);
            params.put("primaryUrl", primaryUrl);
            params = additionals.appendParams(params);
            getContainer().send("/share", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

}
