package jp.eisbahn.android.sdk.wrapper.updates;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.UpdatesAPI;
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
        getContainer().send("/updates/@me/@friends", handler);
    }

}
