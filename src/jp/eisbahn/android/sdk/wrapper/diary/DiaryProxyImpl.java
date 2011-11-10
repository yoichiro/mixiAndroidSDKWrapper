package jp.eisbahn.android.sdk.wrapper.diary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import jp.eisbahn.android.sdk.wrapper.DiaryAPI;
import jp.eisbahn.android.sdk.wrapper.common.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.common.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.common.Visibility;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Diary APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class DiaryProxyImpl extends AbstractProxyImpl implements DiaryAPI {

    /** バッファサイズ. */
    private static final int BUF_SIZE = 1024;

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

    @Override
    public void postPublicDiary(final String title, final String body,
            final InputStream image, final GetIdCallbackHandler handler) {
        postInternal(title, body, Visibility.everyone, null, true, image,
                handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final Visibility visibility, final InputStream image,
            final GetIdCallbackHandler handler) {
        postInternal(title, body, visibility, null, false, image, handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final String group, final InputStream image,
            final GetIdCallbackHandler handler) {
        postInternal(title, body, Visibility.group, group, false, image,
                handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final Visibility visibility, final boolean showUsers,
            final InputStream image, final GetIdCallbackHandler handler) {
        postInternal(title, body, visibility, null, showUsers, image, handler);
    }

    @Override
    public void postDiary(final String title, final String body,
            final String group, final boolean showUsers,
            final InputStream image, final GetIdCallbackHandler handler) {
        postInternal(title, body, Visibility.group, group, showUsers, image,
                handler);
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
            JSONObject params = createRequestJSONObject(title, body,
                    visibility, group, showUsers);
            getContainer().send("/diary/articles/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 日記の投稿を実際に行う内部メソッドです.
     * @param title 日記のタイトル
     * @param body 日記の本文
     * @param visibility 公開範囲
     * @param group 特定のグループに公開する際のグループID
     * @param showUsers 「自分だけに表示」の場合はfalse,「自分と公開中の友人に表示」の場合はtrue
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    private void postInternal(final String title, final String body,
            final Visibility visibility, final String group,
            final boolean showUsers, final InputStream image,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = createRequestJSONObject(title, body,
                    visibility, group, showUsers);
            StringBuilder sb = new StringBuilder();
            sb.append("---mixi_android_sdk_wrapper\r\n");
            sb.append("Content-Disposition: form-data; name=\"request\"\r\n");
            sb.append("\r\n");
            sb.append(params.toString());
            sb.append("\r\n");
            sb.append("---mixi_android_sdk_wrapper\r\n");
            sb.append("Content-Disposition: form-data; name=\"photo1\";"
                    + " filename=\"photo1.jpg\"\r\n");
            sb.append("\r\n");
            byte[] header = sb.toString().getBytes("UTF-8");
            byte[] request = new byte[header.length + image.available()];
            System.arraycopy(header, 0, request, 0, header.length);

            int len = 0;
            int offset = header.length;
            byte[] buf = new byte[BUF_SIZE];
            while ((len = image.read(buf)) != -1) {
                System.arraycopy(buf, 0, request, offset, len);
                offset += len;
            }
            getContainer().send(
                    "/diary/articles/@me/@self",
                    "multipart/form-data; boundary=-mixi_android_sdk_wrapper",
                    new ByteArrayInputStream(request),
                    request.length,
                    handler);
        } catch (JSONException e) {
            Log.w("mixiAndroidSDKWrapper", e);
            throw new IllegalStateException(e);
        } catch (UnsupportedEncodingException e) {
            Log.w("mixiAndroidSDKWrapper", e);
            throw new IllegalStateException(e);
        } catch (IOException e) {
            Log.w("mixiAndroidSDKWrapper", e);
            throw new IllegalStateException(e);
        } finally {
            try {
                image.close();
            } catch (IOException ex) {
                Log.w("mixiAndroidSDKWrapper", ex);
            }
        }
    }

    /**
     * 指定された内容に基づいて、送信されるJSONオブジェクトを構築し返します.
     * @param title タイトル文字列
     * @param body 本文
     * @param visibility 公開範囲
     * @param group グループID
     * @param showUsers 「自分だけに表示」の場合はfalse,「自分と公開中の友人に表示」の場合はtrue
     * @return JSONオブジェクト
     * @throws JSONException JSONオブジェクトの構築に失敗したとき
     */
    private JSONObject createRequestJSONObject(final String title,
            final String body, final Visibility visibility, final String group,
            final boolean showUsers) throws JSONException {
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
        return params;
    }

}
