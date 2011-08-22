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

}
