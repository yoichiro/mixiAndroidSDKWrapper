package jp.eisbahn.android.sdk.wrapper.util;

/**
 * 文字列を扱うユーティリティクラスです.
 * @author Yoichiro Tanaka
 *
 */
public final class StringUtils {

    /**
     * このインスタンスを初期化します.
     */
    private StringUtils() {
    }

    /**
     * 指定された配列を、指定された区切り文字で連結した結果の文字列を返します.
     * @param source 文字列配列
     * @param delimiter 区切り文字
     * @return 連結後の文字列
     */
    public static String join(final String[] source, final String delimiter) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < source.length; i++) {
            if (first) {
                first = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(source[i]);
        }
        return sb.toString();
    }

    /**
     * 指定された配列を、カンマ区切りの一つの文字列に変換して返します.
     * @param array 配列. 各要素はtoString()されます.
     * @return 変換後のカンマ区切りの文字列
     */
    public static String convertArrayToStringWithComma(
            final Object[] array) {
        if (array == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (int i = 0; i < array.length; i++) {
                if (!first) {
                    sb.append(',');
                }
                sb.append(array[i].toString());
                first = false;
            }
            return sb.toString();
        }
    }

}
