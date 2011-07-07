package jp.eisbahn.android.sdk.wrapper;

import jp.mixi.android.sdk.Config;
import jp.mixi.android.sdk.MixiContainer;
import jp.mixi.android.sdk.MixiContainerFactory;

/**
 * 指定された情報に基づいて、{@see MixiWrapper}オブジェクトを生成します.
 * @author Yoichiro Tanaka
 *
 */
public class MixiWrapperFactory {

    /**
     * mixi Graph APIを利用するための{@see MixiWrapper}オブジェクトを生成します.
     * @param clientId Client ID
     * @return {@see MixiWrapper}オブジェクト
     */
    public MixiWrapper createForGraphAPI(final String clientId) {
        return create(clientId, Config.GRAPH_API);
    }

    /**
     * mixiアプリを利用するための{@see MixiWrapper}オブジェクトを生成します.
     * @param clientId Client ID
     * @return {@see MixiWrapper}オブジェクト
     */
    public MixiWrapper createForMixiApp(final String clientId) {
        return create(clientId, Config.APPLICATION);
    }

    /**
     * {@see MixiWrapper}オブジェクトを生成します.
     * @param clientId Client ID
     * @param selector セレクタ
     * @return {@see MixiWrapper}オブジェクト
     */
    private MixiWrapper create(final String clientId, final int selector) {
        Config config = new Config();
        config.clientId = clientId;
        config.selector = selector;
        MixiContainer container = MixiContainerFactory.getContainer(config);
        MixiWrapper wrapper = new MixiWrapperImpl(container);
        return wrapper;
    }

}
