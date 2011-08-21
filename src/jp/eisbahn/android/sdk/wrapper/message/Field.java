package jp.eisbahn.android.sdk.wrapper.message;

/**
 * 取得したいメッセージ情報の項目を指定します.
 * @author Yoichiro Tanaka
 *
 */
public enum Field {

    /** ID. */
    id(false),
    /** タイトル. */
    title(false),
    /** 本文. */
    body(false),
    /** 送信日時. */
    timeSent(false),
    /** ステータス. */
    status(false),
    /** ニックネーム. */
    displayName(true),
    /** プロフィール画像のURL. */
    thumbnailUrl(true),
    /** プロフィールページのURL. */
    profileUrl(true);

    /** 接頭語が必要かどうか. */
    private boolean needPrefix;

    /**
     * このインスタンスが生成されるときに呼び出されます.
     * @param needPrefix 接頭語が必要かどうか
     */
    private Field(final boolean needPrefix) {
        this.needPrefix = needPrefix;
    }

    /**
     * 接頭語が必要かどうかを返します.
     * @return 接頭語が必要かどうか
     */
    public boolean isNeedPrefix() {
        return needPrefix;
    }

}
