package jp.eisbahn.android.sdk.wrapper.people;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.mixi.android.sdk.MixiContainer;

/**
 * People APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class PeopleProxyImpl extends AbstractProxyImpl {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public PeopleProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    /**
     * 認可ユーザのプロフィール情報を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public final void getMe(final GetPeopleCallbackHandler handler) {
        getContainer().send("/people/@me/@self", handler);
    }

    /**
     * 認可ユーザの友人のプロフィール情報を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public final void getFriends(final GetPeopleCallbackHandler handler) {
        getContainer().send("/people/@me/@friends", handler);
    }

    /**
     * 認可ユーザの友人のプロフィール情報を取得します.
     * @param params 取得条件を指定するためのパラメータ
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getFriends(final GetPeopleParams params,
            final GetPeopleCallbackHandler handler) {
        getContainer().send("/people/@me/@friends",
                params.convertParameterMap(), handler);
    }

}
