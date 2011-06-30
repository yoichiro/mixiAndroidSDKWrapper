package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleParams;
import jp.eisbahn.android.sdk.wrapper.photo.GetAlbumsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.GetPhotosCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestParams;
import android.content.Context;

/**
 * mixi API SDK for Androidをより手軽に利用するための処理が
 * 規定されたインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface MixiWrapper {

    // --- mixiアプリ向けリクエストAPI

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

    // --- People API

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

    // - Photo API

    /**
     * 認可ユーザが持つアルバムの一覧を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyAlbums(GetAlbumsCallbackHandler handler);

    /**
     * 認可ユーザが持つアルバムの情報を取得します.
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyAlbum(String albumId, GetAlbumsCallbackHandler handler);

    /**
     * 認可ユーザの友人が持つアルバムの一覧を取得します.
     * @param userId 友人のユーザID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendAlbums(String userId, GetAlbumsCallbackHandler handler);

    /**
     * 認可ユーザの友人が持つアルバムの一覧を取得します.
     * @param userId 友人のユーザID
     * @param accessKey アルバムにつけられた合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendAlbums(String userId, String accessKey,
            GetAlbumsCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人が持つアルバムの情報を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendAlbum(String userId, String albumId,
            GetAlbumsCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人が持つアルバムの情報を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param accessKey アルバムにつけられた合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendAlbum(String userId, String albumId, String accessKey,
            GetAlbumsCallbackHandler handler);

    /**
     * 認可ユーザの友人が最近作成したアルバムの一覧を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendsAlbums(GetAlbumsCallbackHandler handler);

    /**
     * 認可ユーザのフォトの一覧を取得します.
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyPhotos(String albumId, GetPhotosCallbackHandler handler);

    /**
     * 認可ユーザのフォトの情報を取得します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyPhoto(String albumId, String mediaItemId,
            GetPhotosCallbackHandler handler);

}
