package jp.eisbahn.android.sdk.wrapper.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Dateオブジェクトについて便利な処理を提供するクラスです.
 * @author Yoichiro Tanaka
 */
public final class DateUtils {

    /** createAt属性をパースするためのDate format. */
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    /**
     * このインスタンスを初期化します.
     */
    private DateUtils() {
        super();
    }

    /**
     * 日付文字列をDateオブジェクトに変換します..
     * @param original 日付文字列.
     * @return 変換された日付オブジェクト.
     * @throws ParseException もし引数が不正だったとき.
     */
    public static Date convertDate(final String original)
            throws ParseException {
        String target = original;
        if (target.endsWith(":00")) {
            StringBuilder sb = new StringBuilder();
            sb.append(target.substring(0, target.indexOf(":00")));
            sb.append("00");
            target = sb.toString();
        }
        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.parse(target);
    }

    /**
     * Dateオブジェクトを日付文字列に変換します.
     * @param date Dateオブジェクト.
     * @return 日付文字列.
     */
    public static String convertDate(final Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return formatter.format(date);
    }

}
