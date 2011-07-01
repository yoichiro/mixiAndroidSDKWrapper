package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.PeopleProxyImpl;
import jp.eisbahn.android.sdk.wrapper.photo.PhotoProxyImpl;
import jp.eisbahn.android.sdk.wrapper.request.RequestProxyImpl;
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

}
