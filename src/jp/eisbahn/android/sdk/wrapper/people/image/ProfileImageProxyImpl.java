package jp.eisbahn.android.sdk.wrapper.people.image;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.ProfileImageAPI;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Profile Image APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class ProfileImageProxyImpl extends AbstractProxyImpl
implements ProfileImageAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public ProfileImageProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getMyProfileImages(
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/@me/@self", handler);
    }

}
