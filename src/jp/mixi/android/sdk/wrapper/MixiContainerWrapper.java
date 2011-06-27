package jp.mixi.android.sdk.wrapper;

import jp.mixi.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.mixi.android.sdk.wrapper.people.GetPeopleParams;
import jp.mixi.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.mixi.android.sdk.wrapper.request.SendRequestParams;
import android.content.Context;

/**
 * mixi API SDK for Androidをより手軽に利用するための処理が
 * 規定されたインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface MixiContainerWrapper {

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

    /**
     * 認可ユーザのプロフィール情報を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMe(GetPeopleCallbackHandler handler);

    /**
     * 認可ユーザの友人のプロフィール情報を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriends(GetPeopleCallbackHandler handler);

    /**
     * 認可ユーザの友人のプロフィール情報を取得します.
     * @param params 取得条件を指定するためのパラメータ
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriends(GetPeopleParams params, GetPeopleCallbackHandler handler);

}
