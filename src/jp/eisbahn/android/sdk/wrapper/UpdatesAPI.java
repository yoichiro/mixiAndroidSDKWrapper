package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.updates.GetFeedCallbackHandler;


/**
 * Updates API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface UpdatesAPI {

    /**
     * 認可ユーザ自身のフィード一覧を取得します.
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getMyFeeds(GetFeedCallbackHandler handler);

    /**
     * ある友人のフィード一覧を取得します.
     * @param userId 友人のユーザID
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getFriendFeeds(String userId, GetFeedCallbackHandler handler);

    /**
     * 認可ユーザの友人のフィード一覧を取得します.
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getFriendsFeeds(GetFeedCallbackHandler handler);

}
