package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.voice.GetCommentsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.voice.GetFeedbacksParams;
import jp.eisbahn.android.sdk.wrapper.voice.GetStatusParams;
import jp.eisbahn.android.sdk.wrapper.voice.GetStatusesCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.voice.GetStatusesParams;
import jp.eisbahn.android.sdk.wrapper.voice.GetUsersCallbackHandler;

/**
 * Voice API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface VoiceAPI {

    /**
     * 認可ユーザのつぶやき一覧を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyStatuses(GetStatusesCallbackHandler handler);

    /**
     * 認可ユーザのつぶやき一覧を取得します.
     * @param params 取得条件を指定するためのオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyStatuses(GetStatusesParams params,
            GetStatusesCallbackHandler handler);

    /**
     * 指定された特定の友人のつぶやき一覧を取得します.
     * @param userId ユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendStatuses(String userId, GetStatusesCallbackHandler handler);

    /**
     * 指定された特定の友人のつぶやき一覧を取得します.
     * @param userId ユーザID
     * @param params 取得条件を指定するためのオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendStatuses(String userId, GetStatusesParams params,
            GetStatusesCallbackHandler handler);

    /**
     * 全ての友人のつぶやき一覧を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendsStatuses(GetStatusesCallbackHandler handler);

    /**
     * 全ての友人のつぶやき一覧を取得します.
     * @param params 取得条件を指定するためのオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendsStatuses(GetStatusesParams params,
            GetStatusesCallbackHandler handler);

    /**
     * 指定されたグループのつぶやき一覧を取得します.
     * @param groupId グループID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getGroupStatuses(String groupId, GetStatusesCallbackHandler handler);

    /**
     * 指定されたグループのつぶやき一覧を取得します.
     * @param groupId グループID
     * @param params 取得条件を指定するためのオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getGroupStatuses(String groupId, GetStatusesParams params,
            GetStatusesCallbackHandler handler);

    /**
     * 指定されたIDのつぶやき一覧を取得します.
     * @param postId つぶやきのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getStatus(String postId, GetStatusesCallbackHandler handler);

    /**
     * 指定されたつぶやき一覧を取得します.
     * @param postId つぶやきのID
     * @param params 取得条件を指定するためのオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getStatus(String postId, GetStatusParams params,
            GetStatusesCallbackHandler handler);

    /**
     * 指定されたIDのつぶやきのコメント一覧を取得します.
     * @param postId つぶやきのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getStatusComments(String postId, GetCommentsCallbackHandler handler);

    /**
     * 指定されたIDのつぶやきのコメント一覧を取得します.
     * @param postId つぶやきのID
     * @param params 取得条件を指定するためのオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getStatusComments(String postId, GetFeedbacksParams params,
            GetCommentsCallbackHandler handler);

    /**
     * 指定されたIDのつぶやきのいいね一覧を取得します.
     * @param postId つぶやきのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getStatusFavorites(String postId, GetUsersCallbackHandler handler);

    /**
     * 指定されたIDのつぶやきのいいね一覧を取得します.
     * @param postId つぶやきのID
     * @param params 取得条件を指定するためのオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getStatusFavorites(String postId, GetFeedbacksParams params,
            GetUsersCallbackHandler handler);

}
