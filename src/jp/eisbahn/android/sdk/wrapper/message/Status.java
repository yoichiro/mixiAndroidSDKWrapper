package jp.eisbahn.android.sdk.wrapper.message;

/**
 * メッセージのステータスを定義した列挙型です.
 * @author Yoichiro Tanaka
 *
 */
public enum Status {

    /** 未読. */
    unread("new"),
    /** 既読. */
    read("read"),
    /** 返信済み. */
    replied("replied");

    /** APIで使われる実際の文字列. */
    private String real;

    /**
     * 指定された情報に基づいて、このインスタンスを初期化します.
     * @param newReal APIで使われる実際の文字列
     */
    private Status(final String newReal) {
        real = newReal;
    }

    /**
     * APIで使われる実際の文字列を返します.
     * @return APIで使われる実際の文字列
     */
    public String getReal() {
        return real;
    }

}
