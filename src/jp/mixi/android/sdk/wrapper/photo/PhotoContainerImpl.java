package jp.mixi.android.sdk.wrapper.photo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.util.Log;

import jp.mixi.android.sdk.MixiContainer;
import jp.mixi.android.sdk.wrapper.AbstractContainerImpl;

/**
 * Photo APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class PhotoContainerImpl extends AbstractContainerImpl {

    /**
     * このインスタンスを初期化します.
     * @param newContainer コンテナオブジェクト
     */
    public PhotoContainerImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    /**
     * 認可ユーザが持つアルバムの一覧を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getMyAlbums(final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/@me/@self", handler);
    }

    /**
     * 認可ユーザが持つアルバムの情報を取得します.
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getMyAlbum(final String albumId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/@me/@self/" + albumId, handler);
    }

    /**
     * 認可ユーザの友人が持つアルバムの一覧を取得します.
     * @param userId 友人のユーザID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getFriendAlbums(final String userId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/" + userId + "/@self", handler);
    }

    /**
     * 認可ユーザの友人が持つアルバムの一覧を取得します.
     * @param userId 友人のユーザID
     * @param accessKey アルバムにつけられた合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getFriendAlbums(final String userId, final String accessKey,
            final GetAlbumsCallbackHandler handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/albums/" + userId
                    + "/@self?accessKey=" + encodedAccessKey, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    /**
     * 認可ユーザの友人が持つアルバムの情報を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getFriendAlbum(final String userId, final String albumId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/" + userId + "/@self/" + albumId, handler);
    }

    /**
     * 認可ユーザの友人が持つアルバムの情報を取得します.
     * @param userId 友人のユーザID
     * @param albumId アルバムID
     * @param accessKey アルバムにつけられた合い言葉
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getFriendAlbum(final String userId, final String albumId,
            final String accessKey, final GetAlbumsCallbackHandler handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/albums/" + userId
                    + "/@self/" + albumId + "?accessKey="
                    + encodedAccessKey, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    /**
     * 認可ユーザの友人が最近作成したアルバムの一覧を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getFriendsAlbums(final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/@me/@friends", handler);
    }

    /**
     * 認可ユーザのフォトの一覧を取得します.
     * @param albumId アルバムID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getMyPhotos(final String albumId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId, handler);
    }

    /**
     * 認可ユーザのフォトの情報を取得します.
     * @param albumId アルバムID
     * @param mediaItemId フォトID
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    public void getMyPhoto(final String albumId, final String mediaItemId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId, handler);
    }

}
