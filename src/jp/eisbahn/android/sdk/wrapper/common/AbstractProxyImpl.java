package jp.eisbahn.android.sdk.wrapper.common;

import jp.mixi.android.sdk.MixiContainer;

/**
 * 各種コンテナクラスに共通な処理を提供する抽象クラスです.
 * @author Yoichiro Tanaka
 *
 */
public abstract class AbstractProxyImpl {

    /** MixiContainerオブジェクト. */
    private MixiContainer container;

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public AbstractProxyImpl(final MixiContainer newContainer) {
        super();
        this.container = newContainer;
    }

    /**
     * MixiContainerオブジェクトを返します.
     * @return MixiContainerオブジェクト
     */
    protected MixiContainer getContainer() {
        return container;
    }

}
