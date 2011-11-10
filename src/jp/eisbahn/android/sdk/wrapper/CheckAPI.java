package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.check.PostCheckParams;
import jp.eisbahn.android.sdk.wrapper.common.CallbackAdapter;

/**
 * Check API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface CheckAPI {

    /**
     * 指定された内容でmixiチェックを投稿します.
     * @param key mixi チェック識別キー
     * @param title タイトル。チェックする対象を簡潔に表す文字列です。
     * @param primaryUrl この投稿が参照する URL。
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postCheck(String key, String title, String primaryUrl,
            CallbackAdapter handler);

    /**
     * 指定された内容でmixiチェックを投稿します.
     * @param key mixi チェック識別キー
     * @param title タイトル。チェックする対象を簡潔に表す文字列です。
     * @param primaryUrl この投稿が参照する URL。
     * @param additionals 追加のパラメータ。
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void postCheck(String key, String title, String primaryUrl,
            PostCheckParams additionals, CallbackAdapter handler);

}
