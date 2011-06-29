package jp.mixi.android.sdk.wrapper.request;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;
import jp.mixi.android.sdk.wrapper.AbstractContainerImpl;
import jp.mixi.android.sdk.wrapper.CallbackAdapter;

/**
 * People APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class RequestContainerImpl extends AbstractContainerImpl {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public RequestContainerImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    /**
     * mixiアプリ向けに提供されているリクエスト送信APIを呼び出します.
     * @param context コンテキストオブジェクト
     * @param params リクエスト送信に必要なパラメータを持つオブジェクト
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public final void sendRequest(
            final Context context,
            final SendRequestParams params,
            final SendRequestCallbackHandler handler) {
        getContainer().showDialog(
                context,
                "/requests",
                params.convertParameterMap(),
                handler);
    }

    /**
     * mixiアプリ向けに提供されているリクエスト削除APIを呼び出します.
     * @param requestIds 削除したいリクエストのIDの配列
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public final void deleteRequests(
            final String[] requestIds,
            final CallbackAdapter handler) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < requestIds.length; i++) {
            if (first) {
                first = false;
            } else {
                sb.append(",");
            }
            sb.append(requestIds[i]);
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("requestIds", sb.toString());
        getContainer().send(
                "/apps/requests/@me/@self",
                HttpMethod.DELETE,
                params,
                handler);
    }

}
