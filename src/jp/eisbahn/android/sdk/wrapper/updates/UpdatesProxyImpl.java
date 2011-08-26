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

}
