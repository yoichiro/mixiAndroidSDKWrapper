package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.photo.GetAlbumsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.GetPhotosCallbackHandler;

/**
 * Photo APIに関する処理を規定したインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface PhotoAPI {

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

    /**
     * 認可ユーザの特定の友人のフォトの一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhotos(String userId, String albumId,
            GetPhotosCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のフォトの一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param accessKey 合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhotos(String userId, String albumId, String accessKey,
            GetPhotosCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のフォトの情報を返します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhoto(String userId, String albumId, String mediaItemId,
            GetPhotosCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のフォトの情報を返します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param accessKey 合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhoto(String userId, String albumId, String mediaItemId,
            String accessKey, GetPhotosCallbackHandler handler);

    /**
     * 認可ユーザの友人が最近アップロードしたフォトの一覧を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendsPhotos(GetPhotosCallbackHandler handler);

}
