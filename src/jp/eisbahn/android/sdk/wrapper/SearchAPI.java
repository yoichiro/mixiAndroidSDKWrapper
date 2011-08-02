package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;

/**
 * Search API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface SearchAPI {

    /**
     * 指定されたメールアドレスからそのユーザのプロフィール情報を取得します.
     * @param groupId グループID
     * @param emails メールアドレスの配列
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getPeople(String groupId, String[] emails,
            GetPeopleCallbackHandler handler);

    /**
     * 指定されたメールアドレスからそのユーザのプロフィール情報を取得します.
     * @param emails メールアドレスの配列
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getPeople(String[] emails, GetPeopleCallbackHandler handler);

}
