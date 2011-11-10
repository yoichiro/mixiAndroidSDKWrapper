package jp.eisbahn.android.sdk.wrapper.search;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.SearchAPI;
import jp.eisbahn.android.sdk.wrapper.common.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.util.StringUtils;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Search APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class SearchProxyImpl extends AbstractProxyImpl implements SearchAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public SearchProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getPeople(final String groupId, final String[] emails,
            final GetPeopleCallbackHandler handler) {
        String q = StringUtils.join(emails, ",");
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", q);
        getContainer().send("/search/people/" + groupId, params, handler);
    }

    @Override
    public void getPeople(final String[] emails,
            final GetPeopleCallbackHandler handler) {
        String q = StringUtils.join(emails, ",");
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", q);
        getContainer().send("/search/people", params, handler);
    }

}
