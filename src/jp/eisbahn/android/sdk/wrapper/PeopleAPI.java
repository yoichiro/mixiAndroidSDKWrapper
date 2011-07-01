package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleParams;

/**
 * People API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface PeopleAPI {

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
