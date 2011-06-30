package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleParams;
import jp.eisbahn.android.sdk.wrapper.people.PeopleProxyImpl;
import jp.eisbahn.android.sdk.wrapper.photo.GetAlbumsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.GetPhotosCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.photo.PhotoProxyImpl;
import jp.eisbahn.android.sdk.wrapper.request.RequestProxyImpl;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestParams;
import jp.mixi.android.sdk.MixiContainer;
import android.content.Context;

/**
 * {@link MixiWrapper}インタフェースの実装クラスです.
 * @author Yoichiro Tanaka
 *
 */
public class MixiWrapperImpl implements MixiWrapper {

    /** People API コンテナ. */
    private PeopleProxyImpl peopleProxy;

    /** mixiアプリ向けリクエストコンテナ. */
    private RequestProxyImpl requestProxy;

    /** Photo API コンテナ. */
    private PhotoProxyImpl photoProxy;

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public MixiWrapperImpl(final MixiContainer newContainer) {
        super();
        peopleProxy = new PeopleProxyImpl(newContainer);
        requestProxy = new RequestProxyImpl(newContainer);
        photoProxy = new PhotoProxyImpl(newContainer);
    }

    @Override
    public void sendRequest(final Context context,
            final SendRequestParams params,
            final SendRequestCallbackHandler handler) {
        requestProxy.sendRequest(context, params, handler);
    }

    @Override
    public void deleteRequests(final String[] requestIds,
            final CallbackAdapter handler) {
        requestProxy.deleteRequests(requestIds, handler);
    }

    @Override
    public void getMe(final GetPeopleCallbackHandler handler) {
        peopleProxy.getMe(handler);
    }

    @Override
    public void getFriends(final GetPeopleCallbackHandler handler) {
        peopleProxy.getFriends(handler);
    }

    @Override
    public void getFriends(final GetPeopleParams params,
            final GetPeopleCallbackHandler handler) {
        peopleProxy.getFriends(params, handler);
    }

    @Override
    public void getMyAlbums(final GetAlbumsCallbackHandler handler) {
        photoProxy.getMyAlbums(handler);
    }

    @Override
    public void getMyAlbum(final String albumId,
            final GetAlbumsCallbackHandler handler) {
        photoProxy.getMyAlbum(albumId, handler);
    }

    @Override
    public void getFriendAlbums(final String userId,
            final GetAlbumsCallbackHandler handler) {
        photoProxy.getFriendAlbums(userId, handler);
    }

    @Override
    public void getFriendAlbums(final String userId, final String accessKey,
            final GetAlbumsCallbackHandler handler) {
        photoProxy.getFriendAlbums(userId, accessKey, handler);
    }

    @Override
    public void getFriendAlbum(final String userId, final String albumId,
            final GetAlbumsCallbackHandler handler) {
        photoProxy.getFriendAlbum(userId, albumId, handler);
    }

    @Override
    public void getFriendAlbum(final String userId, final String albumId,
            final String accessKey, final GetAlbumsCallbackHandler handler) {
        photoProxy.getFriendAlbum(userId, albumId, accessKey, handler);
    }

    @Override
    public void getFriendsAlbums(final GetAlbumsCallbackHandler handler) {
        photoProxy.getFriendsAlbums(handler);
    }

    @Override
    public void getMyPhotos(final String albumId,
            final GetPhotosCallbackHandler handler) {
        photoProxy.getMyPhotos(albumId, handler);
    }

    @Override
    public void getMyPhoto(final String albumId, final String mediaItemId,
            final GetPhotosCallbackHandler handler) {
        photoProxy.getMyPhoto(albumId, mediaItemId, handler);
    }

    @Override
    public void getFriendPhotos(final String userId, final String albumId,
            final GetPhotosCallbackHandler handler) {
        photoProxy.getFriendPhotos(userId, albumId, handler);
    }

    @Override
    public void getFriendPhotos(final String userId, final String albumId,
            final String accessKey, final GetPhotosCallbackHandler handler) {
        photoProxy.getFriendPhotos(userId, albumId, accessKey, handler);
    }

    @Override
    public void getFriendPhoto(final String userId, final String albumId,
            final String mediaItemId, final GetPhotosCallbackHandler handler) {
        photoProxy.getFriendPhoto(userId, albumId, mediaItemId, handler);
    }

    @Override
    public void getFriendPhoto(final String userId, final String albumId,
            final String mediaItemId, final String accessKey,
            final GetPhotosCallbackHandler handler) {
        photoProxy.getFriendPhoto(userId, albumId, mediaItemId,
                accessKey, handler);
    }

}
