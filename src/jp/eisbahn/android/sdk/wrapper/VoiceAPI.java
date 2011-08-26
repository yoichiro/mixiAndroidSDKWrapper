package jp.eisbahn.android.sdk.wrapper;

import java.io.InputStream;

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

    /**
     * つぶやきを投稿します.
     * @param status つぶやきの本文
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postStatus(String status, GetStatusesCallbackHandler handler);

    /**
     * 画像付きでつぶやきを投稿します.
     * 画像のフォーマットは「image/jpeg」となります.
     * @param status つぶやきの本文
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postStatus(String status, InputStream image,
            GetStatusesCallbackHandler handler);

    /**
     * つぶやきを削除します.
     * @param postId 削除したいつぶやきのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteStatus(String postId, CallbackAdapter handler);

    /**
     * あるつぶやきにコメントを投稿します.
     * @param postId つぶやきのID
     * @param text コメントの本文
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postStatusComment(String postId, String text,
            CallbackAdapter handler);

    /**
     * あるつぶやきのコメントを削除します.
     * @param postId つぶやきのID
     * @param commentId コメントのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteStatusComment(String postId, String commentId,
            CallbackAdapter handler);

    /**
     * あるつぶやきにいいね！を投稿します.
     * @param postId つぶやきのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postStatusFavorite(String postId, CallbackAdapter handler);

    /**
     * あるつぶやきのいいね！を削除します.
     * @param postId つぶやきのID
     * @param userId 削除したいいいね！の投稿者のユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteStatusFavorite(String postId, String userId,
            CallbackAdapter handler);

}
