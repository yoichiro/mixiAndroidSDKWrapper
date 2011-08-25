package jp.eisbahn.android.sdk.wrapper.voice;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.VoiceAPI;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Voice APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class VoiceProxyImpl extends AbstractProxyImpl implements VoiceAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public VoiceProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getMyStatuses(final GetStatusesCallbackHandler handler) {
        getFriendStatuses("@me", handler);
    }

    @Override
    public void getMyStatuses(final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getFriendStatuses("@me", params, handler);
    }

    @Override
    public void getFriendStatuses(final String userId,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + userId + "/user_timeline",
                handler);
    }

    @Override
    public void getFriendStatuses(final String userId,
            final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + userId + "/user_timeline",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getFriendsStatuses(final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline", handler);
    }

    @Override
    public void getFriendsStatuses(final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getGroupStatuses(final String groupId,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline/" + groupId,
                handler);
    }

    @Override
    public void getGroupStatuses(final String groupId,
            final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline/" + groupId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getStatus(final String postId,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + postId, handler);
    }

    @Override
    public void getStatus(final String postId, final GetStatusParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + postId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getStatusComments(final String postId,
            final GetCommentsCallbackHandler handler) {
        getContainer().send("/voice/replies/" + postId, handler);
    }

    @Override
    public void getStatusComments(final String postId,
            final GetFeedbacksParams params,
            final GetCommentsCallbackHandler handler) {
        getContainer().send("/voice/replies/" + postId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getStatusFavorites(final String postId,
            final GetUsersCallbackHandler handler) {
        getContainer().send("/voice/favorites/" + postId, handler);
    }

    @Override
    public void getStatusFavorites(final String postId,
            final GetFeedbacksParams params,
            final GetUsersCallbackHandler handler) {
        getContainer().send("/voice/favorites/" + postId,
                params.convertParameterMap(), handler);
    }

}
