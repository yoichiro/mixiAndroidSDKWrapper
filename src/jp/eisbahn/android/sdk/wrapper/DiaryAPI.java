package jp.eisbahn.android.sdk.wrapper;

/**
 * Diary API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface DiaryAPI {

    /**
     * 指定された情報で全体公開される日記を投稿します.
     * show_usersパラメータ値は「自分と公開中の友人に表示」が適用されます。
     * @param title 日記のタイトル文字列
     * @param body 日記の本文
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postPublicDiary(String title, String body,
            GetIdCallbackHandler handler);

    /**
     * 指定された情報で日記を投稿します.
     * show_usersパラメータ値は「自分だけに表示」が適用されます。
     * @param title 日記のタイトル文字列
     * @param body 日記の本文
     * @param visibility 日記の公開設定
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postDiary(String title, String body, Visibility visibility,
            GetIdCallbackHandler handler);

    /**
     * 指定された情報で日記を投稿します.
     * show_usersパラメータ値は「自分だけに表示」が適用されます。
     * @param title 日記のタイトル文字列
     * @param body 日記の本文
     * @param group 公開対象のグループID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postDiary(String title, String body, String group,
            GetIdCallbackHandler handler);

    /**
     * 指定された情報で日記を投稿します.
     * @param title 日記のタイトル文字列
     * @param body 日記の本文
     * @param visibility 日記の公開設定
     * @param showUsers 「自分だけに表示」の場合はfalse,「自分と公開中の友人に表示」の場合はtrue
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postDiary(String title, String body, Visibility visibility,
            boolean showUsers, GetIdCallbackHandler handler);

    /**
     * 指定された情報で日記を投稿します.
     * show_usersパラメータ値は「自分だけに表示」が適用されます。
     * @param title 日記のタイトル文字列
     * @param body 日記の本文
     * @param group 公開対象のグループID
     * @param showUsers 「自分だけに表示」の場合はfalse,「自分と公開中の友人に表示」の場合はtrue
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postDiary(String title, String body, String group,
            boolean showUsers, GetIdCallbackHandler handler);

}
