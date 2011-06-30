package jp.eisbahn.android.sdk.wrapper;

import jp.mixi.android.sdk.MixiContainer;

/**
 * 各種コンテナクラスに共通な処理を提供する抽象クラスです.
 * @author Yoichiro Tanaka
 *
 */
public abstract class AbstractContainerImpl {

    /** MixiContainerオブジェクト. */
    private MixiContainer container;

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public AbstractContainerImpl(final MixiContainer newContainer) {
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
