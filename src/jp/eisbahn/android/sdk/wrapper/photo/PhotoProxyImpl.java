package jp.eisbahn.android.sdk.wrapper.photo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.PhotoAPI;
import jp.mixi.android.sdk.MixiContainer;
import android.util.Log;

/**
 * Photo APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class PhotoProxyImpl extends AbstractProxyImpl implements PhotoAPI {

    /**
     * このインスタンスを初期化します.
     * @param newContainer コンテナオブジェクト
     */
    public PhotoProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getMyAlbums(final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/@me/@self", handler);
    }

    @Override
    public void getMyAlbum(final String albumId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/@me/@self/" + albumId, handler);
    }

    @Override
    public void getFriendAlbums(final String userId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/" + userId + "/@self", handler);
    }

    @Override
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

    @Override
    public void getFriendAlbum(final String userId, final String albumId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/" + userId
                + "/@self/" + albumId, handler);
    }

    @Override
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

    @Override
    public void getFriendsAlbums(final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/@me/@friends", handler);
    }

    @Override
    public void getMyPhotos(final String albumId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId, handler);
    }

    @Override
    public void getMyPhoto(final String albumId, final String mediaItemId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhotos(final String userId, final String albumId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/" + userId
                + "/@self/" + albumId, handler);
    }

    @Override
    public void getFriendPhotos(final String userId, final String albumId,
            final String accessKey, final GetPhotosCallbackHandler handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/mediaItems/" + userId
                    + "/@self/" + albumId + "?accessKey="
                    + encodedAccessKey, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void getFriendPhoto(final String userId, final String albumId,
            final String mediaItemId, final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/" + userId
                + "/@self/" + albumId + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhoto(final String userId, final String albumId,
            final String mediaItemId, final String accessKey,
            final GetPhotosCallbackHandler handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/mediaItems/" + userId
                    + "/@self/" + albumId + "/" + mediaItemId + "?accessKey="
                    + encodedAccessKey, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void getFriendsPhotos(final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@friends", handler);
    }

}