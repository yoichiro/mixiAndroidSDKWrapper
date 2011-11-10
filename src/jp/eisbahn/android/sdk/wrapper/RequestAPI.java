package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.common.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestParams;
import android.content.Context;

/**
 * mixiアプリ向けリクエストAPIに関する処理を規定したインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface RequestAPI {

    /**
     * mixiアプリ向けに提供されているリクエスト送信APIを呼び出します.
     * @param context コンテキストオブジェクト
     * @param params リクエスト送信に必要なパラメータを持つオブジェクト
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void sendRequest(
            Context context,
            SendRequestParams params,
            SendRequestCallbackHandler handler);

    /**
     * mixiアプリ向けに提供されているリクエスト削除APIを呼び出します.
     * @param requestIds 削除したいリクエストのIDの配列
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteRequests(
            String[] requestIds,
            CallbackAdapter handler);

}
