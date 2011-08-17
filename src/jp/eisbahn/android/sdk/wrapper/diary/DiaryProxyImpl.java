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
        postInternal(title, body, Visibility.everyone, null, true, handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final Visibility visibility, final GetIdCallbackHandler handler) {
        postInternal(title, body, visibility, null, false, handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final String group, final GetIdCallbackHandler handler) {
        postInternal(title, body, Visibility.group, group, false, handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final Visibility visibility, final boolean showUsers,
            final GetIdCallbackHandler handler) {
        postInternal(title, body, visibility, null, showUsers, handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final String group, final boolean showUsers,
            final GetIdCallbackHandler handler) {
        postInternal(title, body, Visibility.group, group, showUsers, handler);
    }

    /**
     * 日記の投稿を実際に行う内部メソッドです.
     * @param title 日記のタイトル
     * @param body 日記の本文
     * @param visibility 公開範囲
     * @param group 特定のグループに公開する際のグループID
     * @param showUsers 「自分だけに表示」の場合はfalse,「自分と公開中の友人に表示」の場合はtrue
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    private void postInternal(final String title, final String body,
            final Visibility visibility, final String group,
            final boolean showUsers, final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("title", title);
            params.put("body", body);
            JSONObject privacy = new JSONObject();
            privacy.put("visibility", visibility.toString());
            if (group != null) {
                privacy.put("group", group);
            }
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
