package jp.eisbahn.android.sdk.wrapper.updates;

import jp.eisbahn.android.sdk.wrapper.UpdatesAPI;
import jp.eisbahn.android.sdk.wrapper.common.AbstractProxyImpl;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Updates APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class UpdatesProxyImpl extends AbstractProxyImpl implements UpdatesAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public UpdatesProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getMyFeeds(final GetFeedCallbackHandler handler) {
        getFriendFeeds("@me", handler);
    }

    @Override
    public void getFriendFeeds(final String userId,
            final GetFeedCallbackHandler handler) {
        getContainer().send("/updates/" + userId + "/@self", handler);
    }

    @Override
    public void getFriendsFeeds(final GetFeedCallbackHandler handler) {
        getGroupFeeds("@friends", handler);
    }

    @Override
    public void getGroupFeeds(final String groupId,
            final GetFeedCallbackHandler handler) {
        getContainer().send("/updates/@me/" + groupId, handler);
    }

    @Override
    public void getMyFeeds(final GetFeedParams params,
            final GetFeedCallbackHandler handler) {
        getFriendFeeds("@me", params, handler);
    }

    @Override
    public void getFriendFeeds(final String userId,
            final GetFeedParams params,
            final GetFeedCallbackHandler handler) {
        getContainer().send("/updates/" + userId + "/@self",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getFriendsFeeds(final GetFeedParams params,
            final GetFeedCallbackHandler handler) {
        getGroupFeeds("@friends", params, handler);
    }

    @Override
    public void getGroupFeeds(final String groupId,
            final GetFeedParams params,
            final GetFeedCallbackHandler handler) {
        getContainer().send("/updates/@me/" + groupId,
                params.convertParameterMap(), handler);
    }

}
