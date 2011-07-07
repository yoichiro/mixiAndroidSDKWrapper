package jp.eisbahn.android.sdk.wrapper;

import java.io.InputStream;

import jp.eisbahn.android.sdk.wrapper.photo.GetAlbumsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.GetCommentsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.GetPhotosCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.GetUsersCallbackHandler;

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

    /**
     * 認可ユーザのアルバムのコメント一覧を取得します.
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyAlbumComments(String albumId, GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のアルバムのコメント一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendAlbumComments(String userId, String albumId,
            GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のアルバムのコメント一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param accessKey 合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendAlbumComments(String userId, String albumId,
            String accessKey, GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザのフォトのコメント一覧を取得します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyPhotoComments(String albumId, String mediaItemId,
            GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のフォトのコメント一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhotoComments(String userId, String albumId,
            String mediaItemId, GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のフォトのコメント一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param accessKey 合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhotoComments(String userId, String albumId,
            String mediaItemId, String accessKey,
            GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザのフォトのいいね！一覧を取得します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyPhotoFavorites(String albumId, String mediaItemId,
            GetUsersCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のフォトのいいね！一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhotoFavorites(String userId, String albumId,
            String mediaItemId, GetUsersCallbackHandler handler);

    /**
     * 認可ユーザの特定の友人のフォトのいいね！一覧を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param accessKey 合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getFriendPhotoFavorites(String userId, String albumId,
            String mediaItemId, String accessKey,
            GetUsersCallbackHandler handler);

    /**
     * 新規にアルバムを作成します.
     * @param title アルバムのタイトル
     * @param description アルバムの説明文
     * @param visibility 公開範囲
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void createAlbum(String title, String description, Visibility visibility,
            GetIdCallbackHandler handler);

    /**
     * 新規にアルバムを作成します.
     * @param title アルバムのタイトル
     * @param description アルバムの説明文
     * @param visibility 公開範囲
     * @param accessKey 合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void createAlbum(String title, String description, Visibility visibility,
            String accessKey, GetIdCallbackHandler handler);

    /**
     * 指定されたアルバムを削除します.
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteAlbum(String albumId, CallbackAdapter handler);

    /**
     * 認可ユーザの指定されたアルバムにコメントを投稿します.
     * @param albumId アルバムID
     * @param text コメント本文
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postMyAlbumComment(String albumId, String text,
            CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人の指定されたアルバムにコメントを投稿します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param text コメント本文
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postFriendAlbumComment(String userId, String albumId,
            String text, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人の指定されたアルバムにコメントを投稿します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param accessKey アクセスキー
     * @param text コメント本文
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postFriendAlbumComment(String userId, String albumId,
            String accessKey, String text,
            CallbackAdapter handler);

    /**
     * 認可ユーザのアルバムのコメントを削除します.
     * @param albumId アルバムID
     * @param commentId コメントID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteMyAlbumComment(String albumId, String commentId,
            CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人のアルバムのコメントを削除します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param commentId コメントID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteFriendAlbumComment(String userId, String albumId,
            String commentId, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人のアルバムのコメントを削除します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param accessKey 合い言葉
     * @param commentId コメントID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteFriendAlbumComment(String userId, String albumId,
            String accessKey, String commentId, CallbackAdapter handler);

    /**
     * 新規にフォトをアップロードします.
     * 対応フォーマットはJPEGのみとなります.
     * @param in フォトのバイナリ情報のストリーム
     * @param length フォトのバイナリの長さ
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void uploadPhoto(InputStream in, int length, String albumId,
            GetIdCallbackHandler handler);

    /**
     * 新規にフォトをアップロードします.
     * 対応フォーマットはJPEGのみとなります.
     * @param in フォトのバイナリ情報のストリーム
     * @param length フォトのバイナリの長さ
     * @param albumId アルバムID
     * @param title フォトにつけるタイトル文字列
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void uploadPhoto(InputStream in, int length, String albumId,
            String title, GetIdCallbackHandler handler);

    /**
     * 認可ユーザのフォトを削除します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deletePhoto(String albumId, String mediaItemId,
            CallbackAdapter handler);

    /**
     * 認可ユーザの指定されたフォトにコメントを投稿します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param text コメント本文
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postMyPhotoComment(String albumId, String mediaItemId, String text,
            CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人の指定されたフォトにコメントを投稿します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param text コメント本文
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postFriendPhotoComment(String userId, String albumId,
            String mediaItemId, String text, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人の指定されたフォトにコメントを投稿します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param accessKey アクセスキー
     * @param text コメント本文
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postFriendPhotoComment(String userId, String albumId,
            String mediaItemId, String accessKey, String text,
            CallbackAdapter handler);

    /**
     * 認可ユーザのフォトのコメントを削除します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param commentId コメントID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteMyPhotoComment(String albumId, String mediaItemId,
            String commentId, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人のフォトのコメントを削除します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param commentId コメントID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteFriendPhotoComment(String userId, String albumId,
            String mediaItemId, String commentId, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人のフォトのコメントを削除します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param accessKey 合い言葉
     * @param commentId コメントID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteFriendPhotoComment(String userId, String albumId,
            String mediaItemId, String accessKey, String commentId,
            CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人の指定されたフォトにいいね！を投稿します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postFriendPhotoFavorite(String userId, String albumId,
            String mediaItemId, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人の指定されたフォトにいいね！を投稿します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param accessKey アクセスキー
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postFriendPhotoFavorite(String userId, String albumId,
            String mediaItemId, String accessKey, CallbackAdapter handler);

    /**
     * 認可ユーザのフォトのいいね！を削除します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param favoriteUserId 消したいいいね！のユーザID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteMyPhotoFavorite(String albumId, String mediaItemId,
            String favoriteUserId, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人のフォトのいいね！を削除します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param favoriteUserId 消したいいいね！のユーザID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteFriendPhotoFavorite(String userId, String albumId,
            String mediaItemId, String favoriteUserId, CallbackAdapter handler);

    /**
     * 認可ユーザの特定の友人のフォトのいいね！を削除します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param accessKey 合い言葉
     * @param favoriteUserId 消したいいいね！のユーザID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void deleteFriendPhotoFavorite(String userId, String albumId,
            String mediaItemId, String accessKey, String favoriteUserId,
            CallbackAdapter handler);

}
