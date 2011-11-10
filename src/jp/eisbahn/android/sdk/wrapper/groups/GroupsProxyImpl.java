package jp.eisbahn.android.sdk.wrapper.groups;

import jp.eisbahn.android.sdk.wrapper.GroupsAPI;
import jp.eisbahn.android.sdk.wrapper.common.AbstractProxyImpl;
import jp.mixi.android.sdk.MixiContainer;

/**
 * People APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GroupsProxyImpl extends AbstractProxyImpl implements GroupsAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public GroupsProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getMyGroups(final GetGroupsCallbackHandler handler) {
        getContainer().send("/groups/@me", handler);
    }

    @Override
    public void getMyGroups(final GetGroupsParams params,
            final GetGroupsCallbackHandler handler) {
        getContainer().send("/groups/@me", params.convertParameterMap(),
                handler);
    }

}
