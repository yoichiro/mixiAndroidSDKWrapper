package jp.eisbahn.android.sdk.wrapper.people.image;

import java.io.IOException;
import java.io.InputStream;

import jp.eisbahn.android.sdk.wrapper.ProfileImageAPI;

import jp.eisbahn.android.sdk.wrapper.common.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.common.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.common.GetIdCallbackHandler;
import jp.mixi.android.sdk.HttpMethod;
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

    @Override
    public void getMyProfileImages(final GetImagesParams params,
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/@me/@self",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getFriendProfileImages(final String userId,
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/" + userId + "/@self", handler);
    }

    @Override
    public void getFriendProfileImages(final String userId,
            final GetImagesParams params,
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/" + userId + "/@self",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getMyProfileImage(final String imageId,
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/@me/@self/" + imageId, handler);
    }

    @Override
    public void getMyProfileImage(final String imageId,
            final GetImagesParams params,
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/@me/@self/" + imageId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getFriendProfileImage(final String userId,
            final String imageId,
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/" + userId + "/@self/" + imageId,
                handler);
    }

    @Override
    public void getFriendProfileImage(final String userId,
            final String imageId, final GetImagesParams params,
            final GetProfileImagesCallbackHandler handler) {
        getContainer().send("/people/images/" + userId + "/@self/" + imageId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void uploadProfileImage(final InputStream in, final Privacy privacy,
            final GetIdCallbackHandler handler) {
        try {
            getContainer().send(
                    "/people/images/@me/@self?privacy=" + privacy.toString(),
                    "image/jpeg", in, in.available(), handler);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteMyProfileImage(final String imageId,
            final CallbackAdapter handler) {
        getContainer().send("/people/images/@me/@self/" + imageId,
                HttpMethod.DELETE, handler);
    }

}
