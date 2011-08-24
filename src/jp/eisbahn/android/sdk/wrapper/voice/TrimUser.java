package jp.eisbahn.android.sdk.wrapper.voice;

/**
 * ユーザ情報として欲しい情報を選別するためのパラメータです.
 * @author Yoichiro Tanaka
 *
 */
public enum TrimUser {

    /** 全て取得. */
    ALL("false"),
    /** idのみ取得. */
    ID("true"),
    /** id, screen_nameを取得. */
    ID_AND_SCREEN_NAME("exclude_screen_name");

    /** APIで使われる文字列. */
    private String real;

    /**
     * このインスタンスを初期化します.
     * @param real APIで使われる文字列
     */
    private TrimUser(final String real) {
        this.real = real;
    }

    /**
     * APIで使われる文字列を返します.
     * @return APIで使われる文字列
     */
    public String getReal() {
        return real;
    }

}
