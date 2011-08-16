package jp.eisbahn.android.sdk.wrapper.diary;

import org.json.JSONException;
import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.DiaryAPI;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.Visibility;
import jp.mixi.android.sdk.MixiContainer;

/**
 * People APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class DiaryProxyImpl extends AbstractProxyImpl implements DiaryAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public DiaryProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void postPublicDiary(final String title, final String body,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("title", title);
            params.put("body", body);
            JSONObject privacy = new JSONObject();
            privacy.put("visibility", "everyone");
            privacy.put("show_users", "1");
            params.put("privacy", privacy);
            getContainer().send("/diary/articles/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void postDiary(final String title, final String body,
            final Visibility visibility, final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("title", title);
            params.put("body", body);
            JSONObject privacy = new JSONObject();
            privacy.put("visibility", visibility.toString());
            privacy.put("show_users", "0");
            params.put("privacy", privacy);
            getContainer().send("/diary/articles/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void postDiary(final String title, final String body,
            final String group, final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("title", title);
            params.put("body", body);
            JSONObject privacy = new JSONObject();
            privacy.put("visibility", Visibility.group.toString());
            privacy.put("group", group);
            privacy.put("show_users", "0");
            params.put("privacy", privacy);
            getContainer().send("/diary/articles/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void postDiary(final String title, final String body,
            final Visibility visibility, final boolean showUsers,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("title", title);
            params.put("body", body);
            JSONObject privacy = new JSONObject();
            privacy.put("visibility", visibility.toString());
            if (showUsers) {
                privacy.put("show_users", "1");
            } else {
                privacy.put("show_users", "0");
            }
            params.put("privacy", privacy);
            getContainer().send("/diary/articles/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void postDiary(final String title, final String body,
            final String group, final boolean showUsers,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("title", title);
            params.put("body", body);
            JSONObject privacy = new JSONObject();
            privacy.put("visibility", Visibility.group.toString());
            privacy.put("group", group);
            if (showUsers) {
                privacy.put("show_users", "1");
            } else {
                privacy.put("show_users", "0");
            }
            params.put("privacy", privacy);
            getContainer().send("/diary/articles/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

}
