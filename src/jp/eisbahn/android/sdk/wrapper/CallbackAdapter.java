package jp.eisbahn.android.sdk.wrapper;

import jp.mixi.android.sdk.CallbackListener;
import jp.mixi.android.sdk.ErrorInfo;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * このコールバックリスナは、各要求が完了したあとに実行される処理が記述されます.
 * 実際には各ハンドラメソッドは処理を何も持っていません。このアダプタクラスは、
 * コールバックリスナの実装を簡略化するために使用されます.
 * @author Yoichiro Tanaka
 *
 */
public class CallbackAdapter implements CallbackListener {

    /** コンテキストオブジェクト. */
    private Context context;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newContext コンテキストオブジェクト
     */
    public CallbackAdapter(final Context newContext) {
        super();
        this.context = newContext;
    }

    /**
     * コンテキストオブジェクトを返します.
     * @return コンテキストオブジェクト
     */
    protected Context getContext() {
        return context;
    }

    /**
     * 正しく結果が得られた際に呼び出されるハンドラメソッドです.
     * @param canceled ユーザにより処理がキャンセルされた場合はtrue、それ以外はtrue
     */
    protected void handleResult(final boolean canceled) {
    }

    /**
     * 各コールバックメソッドの呼び出しの直後に共通に行いたい処理を持ちます.
     */
    protected void preprocess() {
    }

    @Override
    public void onComplete(final Bundle values) {
        preprocess();
        handleResult(false);
    }

    @Override
    public void onCancel() {
        preprocess();
        handleResult(true);
    }

    @Override
    public void onFatal(final ErrorInfo e) {
        preprocess();
        String message = "[" + e.getErrorCode()
                       + "] " + e.getMessage();
        alert("Fatal", message);
        if (e.hasException()) {
            Log.e("mixiAndroidSDKWrapper", message, e.getException());
        } else {
            Log.e("mixiAndroidSDKWrapper", message);
        }
    }

    @Override
    public void onError(final ErrorInfo e) {
        preprocess();
        String message = "[" + e.getErrorCode()
                       + "] " + e.getMessage();
        alert("Error", message);
        if (e.hasException()) {
            Log.w("mixiAndroidSDKWrapper", message, e.getException());
        } else {
            Log.w("mixiAndroidSDKWrapper", message);
        }
    }

    /**
     * 警告ダイアログを表示します.
     * @param title タイトル文字列
     * @param message メッセージs
     */
    protected final void alert(final String title, final String message) {
        new AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show();
    }

}
