package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.PeopleProxyImpl;
import jp.eisbahn.android.sdk.wrapper.photo.PhotoProxyImpl;
import jp.eisbahn.android.sdk.wrapper.request.RequestProxyImpl;
import jp.eisbahn.android.sdk.wrapper.search.SearchProxyImpl;
import jp.eisbahn.android.sdk.wrapper.check.CheckProxyImpl;
import jp.eisbahn.android.sdk.wrapper.groups.GroupsProxyImpl;
import jp.mixi.android.sdk.MixiContainer;

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

    /** Groups API コンテナ. */
    private GroupsProxyImpl groupsProxy;

    /** Search API コンテナ. */
    private SearchProxyImpl searchProxy;

    /** Check API コンテナ. */
    private CheckProxyImpl checkProxy;

    /** {@see MixiContainer}オブジェクト. */
    private MixiContainer container;

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public MixiWrapperImpl(final MixiContainer newContainer) {
        super();
        container = newContainer;
        peopleProxy = new PeopleProxyImpl(newContainer);
        requestProxy = new RequestProxyImpl(newContainer);
        photoProxy = new PhotoProxyImpl(newContainer);
        groupsProxy = new GroupsProxyImpl(newContainer);
        searchProxy = new SearchProxyImpl(newContainer);
        checkProxy = new CheckProxyImpl(newContainer);
    }

    @Override
    public RequestAPI getRequestAPI() {
        return requestProxy;
    }

    @Override
    public PeopleAPI getPeopleAPI() {
        return peopleProxy;
    }

    @Override
    public PhotoAPI getPhotoAPI() {
        return photoProxy;
    }

    @Override
    public GroupsAPI getGroupsAPI() {
        return groupsProxy;
    }

    @Override
    public SearchAPI getSearchAPI() {
        return searchProxy;
    }

    @Override
    public CheckAPI getCheckAPI() {
        return checkProxy;
    }

    @Override
    public MixiContainer getContainer() {
        return container;
    }

}
