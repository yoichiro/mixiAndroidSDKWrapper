package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.updates.GetFeedCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.updates.GetFeedParams;


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

    /**
     * 特定のグループのフィード一覧を取得します.
     * @param groupId グループID
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getGroupFeeds(String groupId, GetFeedCallbackHandler handler);

    /**
     * 認可ユーザ自身のフィード一覧を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getMyFeeds(GetFeedParams params, GetFeedCallbackHandler handler);

    /**
     * ある友人のフィード一覧を取得します.
     * @param userId 友人のユーザID
     * @param params 取得条件を持つオブジェクト
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getFriendFeeds(String userId, GetFeedParams params,
            GetFeedCallbackHandler handler);

    /**
     * 認可ユーザの友人のフィード一覧を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getFriendsFeeds(GetFeedParams params, GetFeedCallbackHandler handler);

    /**
     * 特定のグループのフィード一覧を取得します.
     * @param groupId グループID
     * @param params 取得条件を持つオブジェクト
     * @param handler 取得結果を処理するためのハンドラオブジェクト
     */
    void getGroupFeeds(String groupId, GetFeedParams params,
            GetFeedCallbackHandler handler);

}
