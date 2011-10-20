package jp.eisbahn.android.sdk.wrapper.photo;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.GetCommentsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.GetUsersCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.PhotoAPI;
import jp.eisbahn.android.sdk.wrapper.Visibility;
import jp.mixi.android.sdk.HttpMethod;
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
    public void getMyAlbum(final  String albumId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/@me/@self/" + albumId, handler);
    }

    @Override
    public void getFriendAlbums(final  String userId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/" + userId + "/@self", handler);
    }

    @Override
    public void getFriendAlbums(final  String userId, final  String accessKey,
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
    public void getFriendAlbum(final  String userId, final  String albumId,
            final GetAlbumsCallbackHandler handler) {
        getContainer().send("/photo/albums/" + userId
                + "/@self/" + albumId, handler);
    }

    @Override
    public void getFriendAlbum(final  String userId, final  String albumId,
            final  String accessKey, final GetAlbumsCallbackHandler handler) {
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
    public void getMyPhotos(final  String albumId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId, handler);
    }

    @Override
    public void getMyPhoto(final  String albumId, final  String mediaItemId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhotos(final  String userId, final  String albumId,
            final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/" + userId
                + "/@self/" + albumId, handler);
    }

    @Override
    public void getFriendPhotos(final  String userId, final  String albumId,
            final  String accessKey, final GetPhotosCallbackHandler handler) {
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
    public void getFriendPhoto(final  String userId, final  String albumId,
            final  String mediaItemId, final GetPhotosCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/" + userId
                + "/@self/" + albumId + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhoto(final  String userId, final  String albumId,
            final  String mediaItemId, final  String accessKey,
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

    @Override
    public void getMyAlbumComments(final  String albumId,
            final GetCommentsCallbackHandler handler) {
        getContainer().send("/photo/comments/albums/@me/@self/" + albumId,
                handler);
    }

    @Override
    public void getFriendAlbumComments(final  String userId,
            final String albumId, final GetCommentsCallbackHandler handler) {
        getContainer().send("/photo/comments/albums/" + userId
                + "/@self/" + albumId, handler);
    }

    @Override
    public void getFriendAlbumComments(final String userId,
            final String albumId, final String accessKey,
            final GetCommentsCallbackHandler handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
           getContainer().send("/photo/comments/albums/" + userId
                   + "/@self/" + albumId + "?accessKey="
                   + encodedAccessKey, handler);
       } catch (UnsupportedEncodingException e) {
           Log.e("PhotoContainerImpl", e.getMessage(), e);
           throw new IllegalStateException(e);
       }
    }

    @Override
    public void getMyPhotoComments(final String albumId,
            final String mediaItemId,
            final GetCommentsCallbackHandler handler) {
        getContainer().send("/photo/comments/albums/@me/@self/" + albumId
                + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhotoComments(final String userId,
            final String albumId, final String mediaItemId,
            final GetCommentsCallbackHandler handler) {
        getContainer().send("/photo/comments/albums/" + userId
                + "/@self/" + albumId + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhotoComments(final String userId,
            final String albumId, final String mediaItemId,
            final String accessKey,
            final GetCommentsCallbackHandler handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/comments/albums/" + userId
                   + "/@self/" + albumId + "/" + mediaItemId + "?accessKey="
                   + encodedAccessKey, handler);
       } catch (UnsupportedEncodingException e) {
           Log.e("PhotoContainerImpl", e.getMessage(), e);
           throw new IllegalStateException(e);
       }
    }

    @Override
    public void getMyPhotoFavorites(final String albumId,
            final String mediaItemId, final  GetUsersCallbackHandler handler) {
        getContainer().send("/photo/favorites/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhotoFavorites(final String userId,
            final String albumId, final String mediaItemId,
            final  GetUsersCallbackHandler handler) {
        getContainer().send("/photo/favorites/mediaItems/" + userId
                + "/@self/" + albumId + "/" + mediaItemId, handler);
    }

    @Override
    public void getFriendPhotoFavorites(final String userId,
            final String albumId, final String mediaItemId,
            final String accessKey, final GetUsersCallbackHandler handler) {
       try {
           String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
           getContainer().send("/photo/favorites/mediaItems/" + userId
                   + "/@self/" + albumId + "/" + mediaItemId + "?accessKey="
                   + encodedAccessKey, handler);
       } catch (UnsupportedEncodingException e) {
           Log.e("PhotoContainerImpl", e.getMessage(), e);
           throw new IllegalStateException(e);
       }
    }

    @Override
    public void createAlbum(final String title, final String description,
            final Visibility visibility, final GetIdCallbackHandler handler) {
        createAlbum(title, description, visibility, null, handler);
    }

    @Override
    public void createAlbum(final String title, final String description,
            final Visibility visibility, final String accessKey,
            final GetIdCallbackHandler handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("title", title);
        params.put("description", description);
        params.put("visibility", visibility.toString());
        if (visibility.equals(Visibility.access_key)) {
            params.put("accessKey", accessKey);
        }
        getContainer().send("/photo/albums/@me/@self", HttpMethod.POST,
                params, handler);
    }

    @Override
    public void deleteAlbum(final String albumId,
            final CallbackAdapter handler) {
        getContainer().send("/photo/albums/@me/@self/" + albumId,
                HttpMethod.DELETE, handler);
    }

    @Override
    public void postMyAlbumComment(final String albumId, final String text,
            final CallbackAdapter handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("text", text);
        getContainer().send("/photo/comments/albums/@me/@self/" + albumId,
                HttpMethod.POST, params, handler);
    }

    @Override
    public void postFriendAlbumComment(final String userId,
            final String albumId, final String text,
            final CallbackAdapter handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("text", text);
        getContainer().send("/photo/comments/albums/" + userId + "/@self/"
                + albumId, HttpMethod.POST, params, handler);
    }

    @Override
    public void postFriendAlbumComment(final String userId,
            final String albumId, final String accessKey, final String text,
            final CallbackAdapter handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            Map<String, String> params = new HashMap<String, String>();
            params.put("text", text);
            getContainer().send("/photo/comments/albums/" + userId
                    + "/@self/" + albumId + "?accessKey="
                    + encodedAccessKey, HttpMethod.POST, params, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteMyAlbumComment(final String albumId,
            final String commentId, final CallbackAdapter handler) {
        getContainer().send("/photo/comments/albums/@me/@self/" + albumId
                + "/" + commentId, HttpMethod.DELETE, handler);
    }

    @Override
    public void deleteFriendAlbumComment(final String userId,
            final String albumId, final String commentId,
            final CallbackAdapter handler) {
        getContainer().send("/photo/comments/albums/" + userId + "/@self/"
                + albumId + "/" + commentId, HttpMethod.DELETE, handler);
    }

    @Override
    public void deleteFriendAlbumComment(final String userId,
            final String albumId, final String accessKey,
            final String commentId, final CallbackAdapter handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/comments/albums/" + userId
                    + "/@self/" + albumId + "/" + commentId + "?accessKey="
                    + encodedAccessKey, HttpMethod.DELETE, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void uploadPhoto(final InputStream in, final int length,
            final String albumId, final GetIdCallbackHandler handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId,
                "image/jpeg", in, length, handler);
    }

    @Override
    public void uploadPhoto(final InputStream in, final int length,
            final String albumId, final String title,
            final GetIdCallbackHandler handler) {
        try {
            String encodedTitle = URLEncoder.encode(title, "UTF-8");
            getContainer().send("/photo/mediaItems/@me/@self/"
                    + albumId + "?title=" + encodedTitle, "image/jpeg",
                    in, length, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deletePhoto(final String albumId, final String mediaItemId,
            final CallbackAdapter handler) {
        getContainer().send("/photo/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId, HttpMethod.DELETE, handler);
    }

    @Override
    public void postMyPhotoComment(final String albumId,
            final String mediaItemId, final String text,
            final CallbackAdapter handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("text", text);
        getContainer().send("/photo/comments/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId,
                HttpMethod.POST, params, handler);
    }

    @Override
    public void postFriendPhotoComment(final String userId,
            final String albumId, final String mediaItemId, final String text,
            final CallbackAdapter handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("text", text);
        getContainer().send("/photo/comments/mediaItems/" + userId + "/@self/"
                + albumId + "/" + mediaItemId, HttpMethod.POST, params,
                handler);
    }

    @Override
    public void postFriendPhotoComment(final String userId,
            final String albumId, final String mediaItemId,
            final String accessKey, final String text,
            final CallbackAdapter handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            Map<String, String> params = new HashMap<String, String>();
            params.put("text", text);
            getContainer().send("/photo/comments/mediaItems/" + userId
                    + "/@self/" + albumId + "/" + mediaItemId + "?accessKey="
                    + encodedAccessKey, HttpMethod.POST, params, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteMyPhotoComment(final String albumId,
            final String mediaItemId, final String commentId,
            final CallbackAdapter handler) {
        getContainer().send("/photo/comments/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId + "/" + commentId, HttpMethod.DELETE,
                handler);
    }

    @Override
    public void deleteFriendPhotoComment(final String userId,
            final String albumId, final String mediaItemId,
            final String commentId, final CallbackAdapter handler) {
        getContainer().send("/photo/comments/mediaItems/" + userId + "/@self/"
                + albumId + "/" + mediaItemId + "/" + commentId,
                HttpMethod.DELETE, handler);
    }

    @Override
    public void deleteFriendPhotoComment(final String userId,
            final String albumId, final String mediaItemId,
            final String accessKey, final String commentId,
            final CallbackAdapter handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/comments/mediaItems/" + userId
                    + "/@self/" + albumId + "/" + mediaItemId + "/" + commentId
                    + "?accessKey=" + encodedAccessKey, HttpMethod.DELETE,
                    handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void postFriendPhotoFavorite(final String userId,
            final String albumId, final String mediaItemId,
            final CallbackAdapter handler) {
        getContainer().send("/photo/favorites/mediaItems/" + userId + "/@self/"
                + albumId + "/" + mediaItemId, HttpMethod.POST, handler);
    }

    @Override
    public void postFriendPhotoFavorite(final String userId,
            final String albumId, final String mediaItemId,
            final String accessKey, final CallbackAdapter handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/favorites/mediaItems/" + userId
                    + "/@self/" + albumId + "/" + mediaItemId + "?accessKey="
                    + encodedAccessKey, HttpMethod.POST, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteMyPhotoFavorite(final String albumId,
            final String mediaItemId, final String favoriteUserId,
            final CallbackAdapter handler) {
        getContainer().send("/photo/favorites/mediaItems/@me/@self/" + albumId
                + "/" + mediaItemId + "/" + favoriteUserId, HttpMethod.DELETE,
                handler);
    }

    @Override
    public void deleteFriendPhotoFavorite(final String userId,
            final String albumId, final String mediaItemId,
            final String favoriteUserId, final CallbackAdapter handler) {
        getContainer().send("/photo/favorites/mediaItems/" + userId + "/@self/"
                + albumId + "/" + mediaItemId + "/" + favoriteUserId,
                HttpMethod.DELETE, handler);
    }

    @Override
    public void deleteFriendPhotoFavorite(final String userId,
            final String albumId, final String mediaItemId,
            final String accessKey, final String favoriteUserId,
            final CallbackAdapter handler) {
        try {
            String encodedAccessKey = URLEncoder.encode(accessKey, "UTF-8");
            getContainer().send("/photo/favorites/mediaItems/" + userId
                    + "/@self/" + albumId + "/" + mediaItemId + "/"
                    + favoriteUserId + "?accessKey=" + encodedAccessKey,
                    HttpMethod.DELETE, handler);
        } catch (UnsupportedEncodingException e) {
            Log.e("PhotoContainerImpl", e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

}
