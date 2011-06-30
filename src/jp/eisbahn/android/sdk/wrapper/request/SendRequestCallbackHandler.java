package jp.eisbahn.android.sdk.wrapper.request;

import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import android.content.Context;
import android.os.Bundle;

/**
 * mixiアプリ向けリクエスト送信APIの処理結果を扱うハンドラクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class SendRequestCallbackHandler extends CallbackAdapter {

    /** リクエストを送信したユーザのIDの配列. */
    private String[] requestMembers;

    /** リクエストID. */
    private String requestId;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public SendRequestCallbackHandler(final Context newContext) {
        super(newContext);
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.CallbackAdapter#onComplete(
     * android.os.Bundle)
     */
    @Override
    public final void onComplete(final Bundle values) {
        String requestMember = values.getString("request_member");
        requestMembers = requestMember.split(",");
        requestId = values.getString("request_id");
        super.onComplete(values);
    }

    /**
     * リクエストを送信したユーザのIDの配列を返します.
     * @return ユーザIDの配列
     */
    public final String[] getRequestMembers() {
        return requestMembers;
    }

    /**
     * 送信されたリクエストを特定するためのIDを返します.
     * @return リクエストID
     */
    public final String getRequestId() {
        return requestId;
    }

}

