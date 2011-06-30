package jp.mixi.android.sdk.wrapper;

import jp.mixi.android.sdk.MixiContainer;
import jp.mixi.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.mixi.android.sdk.wrapper.people.GetPeopleParams;
import jp.mixi.android.sdk.wrapper.people.PeopleContainerImpl;
import jp.mixi.android.sdk.wrapper.photo.GetAlbumsCallbackHandler;
import jp.mixi.android.sdk.wrapper.photo.GetPhotosCallbackHandler;
import jp.mixi.android.sdk.wrapper.photo.PhotoContainerImpl;
import jp.mixi.android.sdk.wrapper.request.RequestContainerImpl;
import jp.mixi.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.mixi.android.sdk.wrapper.request.SendRequestParams;
import android.content.Context;

/**
 * {@link MixiContainerWrapper}インタフェースの実装クラスです.
 * @author Yoichiro Tanaka
 *
 */
public class MixiContainerWrapperImpl implements MixiContainerWrapper {

    /** People API コンテナ. */
    private PeopleContainerImpl peopleContainer;

    /** mixiアプリ向けリクエストコンテナ. */
    private RequestContainerImpl requestContainer;

    /** Photo API コンテナ. */
    private PhotoContainerImpl photoContainer;

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public MixiContainerWrapperImpl(final MixiContainer newContainer) {
        super();
        peopleContainer = new PeopleContainerImpl(newContainer);
        requestContainer = new RequestContainerImpl(newContainer);
        photoContainer = new PhotoContainerImpl(newContainer);
    }

    @Override
    public void sendRequest(final Context context,
            final SendRequestParams params,
            final SendRequestCallbackHandler handler) {
        requestContainer.sendRequest(context, params, handler);
    }

    @Override
    public void deleteRequests(final String[] requestIds,
            final CallbackAdapter handler) {
        requestContainer.deleteRequests(requestIds, handler);
    }

    @Override
    public void getMe(final GetPeopleCallbackHandler handler) {
        peopleContainer.getMe(handler);
    }

    @Override
    public void getFriends(final GetPeopleCallbackHandler handler) {
        peopleContainer.getFriends(handler);
    }

    @Override
    public void getFriends(final GetPeopleParams params,
            final GetPeopleCallbackHandler handler) {
        peopleContainer.getFriends(params, handler);
    }

    @Override
    public void getMyAlbums(final GetAlbumsCallbackHandler handler) {
        photoContainer.getMyAlbums(handler);
    }

    @Override
    public void getMyAlbum(final String albumId,
            final GetAlbumsCallbackHandler handler) {
        photoContainer.getMyAlbum(albumId, handler);
    }

    @Override
    public void getFriendAlbums(final String userId,
            final GetAlbumsCallbackHandler handler) {
        photoContainer.getFriendAlbums(userId, handler);
    }

    @Override
    public void getFriendAlbums(final String userId, final String accessKey,
            final GetAlbumsCallbackHandler handler) {
        photoContainer.getFriendAlbums(userId, accessKey, handler);
    }

    @Override
    public void getFriendAlbum(final String userId, final String albumId,
            final GetAlbumsCallbackHandler handler) {
        photoContainer.getFriendAlbum(userId, albumId, handler);
    }

    @Override
    public void getFriendAlbum(final String userId, final String albumId,
            final String accessKey, final GetAlbumsCallbackHandler handler) {
        photoContainer.getFriendAlbum(userId, albumId, accessKey, handler);
    }

    @Override
    public void getFriendsAlbums(final GetAlbumsCallbackHandler handler) {
        photoContainer.getFriendsAlbums(handler);
    }

    @Override
    public void getMyPhotos(final String albumId,
            final GetPhotosCallbackHandler handler) {
        photoContainer.getMyPhotos(albumId, handler);
    }

    @Override
    public void getMyPhoto(final String albumId, final String mediaItemId,
            final GetPhotosCallbackHandler handler) {
        photoContainer.getMyPhoto(albumId, mediaItemId, handler);
    }

}
