package jp.mixi.android.sdk.wrapper;

import java.util.HashMap;
import java.util.Map;

import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;
import jp.mixi.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.mixi.android.sdk.wrapper.people.GetPeopleParams;
import jp.mixi.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.mixi.android.sdk.wrapper.request.SendRequestParams;
import android.content.Context;

/**
 * {@link MixiContainerWrapper}インタフェースの実装クラスです.
 * @author Yoichiro Tanaka
 *
 */
public class MixiContainerWrapperImpl implements MixiContainerWrapper {

    /** MixiContainerオブジェクト. */
    private MixiContainer container;

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public MixiContainerWrapperImpl(final MixiContainer newContainer) {
        super();
        this.container = newContainer;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.MixiContainerWrapper#sendRequest(
     * android.content.Context, jp.mixi.android.sdk.wrapper.RequestParams,
     * jp.mixi.android.sdk.wrapper.RequestCallbackHandler)
     */
    @Override
    public final void sendRequest(
            final Context context,
            final SendRequestParams params,
            final SendRequestCallbackHandler handler) {
        container.showDialog(
                context,
                "/requests",
                params.convertParameterMap(),
                handler);
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.MixiContainerWrapper#deleteRequests(
     * java.lang.String[],
     * jp.mixi.android.sdk.wrapper.CallbackAdapter)
     */
    @Override
    public final void deleteRequests(
            final String[] requestIds,
            final CallbackAdapter handler) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < requestIds.length; i++) {
            if (first) {
                first = false;
            } else {
                sb.append(",");
            }
            sb.append(requestIds[i]);
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("requestIds", sb.toString());
        container.send(
                "/apps/requests/@me/@self",
                HttpMethod.DELETE,
                params,
                handler);
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.MixiContainerWrapper#getMe(
     * jp.mixi.android.sdk.wrapper.people.GetPeopleCallbackHandler)
     */
    @Override
    public final void getMe(final GetPeopleCallbackHandler handler) {
        container.send("/people/@me/@self", handler);
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.MixiContainerWrapper#getFriends(
     * jp.mixi.android.sdk.wrapper.people.GetPeopleCallbackHandler)
     */
    @Override
    public final void getFriends(final GetPeopleCallbackHandler handler) {
        container.send("/people/@me/@friends", handler);
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.MixiContainerWrapper#getFriends(
     * jp.mixi.android.sdk.wrapper.people.GetFriendsParams,
     * jp.mixi.android.sdk.wrapper.people.GetPeopleCallbackHandler)
     */
    @Override
    public void getFriends(final GetPeopleParams params,
            final GetPeopleCallbackHandler handler) {
        container.send("/people/@me/@friends",
                params.convertParameterMap(), handler);
    }

}
