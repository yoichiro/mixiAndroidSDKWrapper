package jp.eisbahn.android.sdk.wrapper.common;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.util.StringUtils;

/**
 * このクラスは、要求を具体的に指定するためのパラメータを持つクラスにとって
 * 便利な処理を提供する抽象クラスです.
 * @author Yoichiro Tanaka
 *
 */
public abstract class AbstractParams {

    /**
     * このインスタンスが持つ情報から、SDKに渡されるコレクションを生成し、それを返します.
     * @return 各パラメータ値を持つコレクション
     */
    public abstract Map<String, String> convertParameterMap();

    /**
     * 引数valueが値を持つとき、指定されたコレクションに指定された名前で追加を行います.
     * @param map 値が追加されるコレクション
     * @param name 値の名称
     * @param value 追加される値
     */
    protected final void putParameter(final Map<String, String> map,
            final String name, final String value) {
        if (value != null) {
            map.put(name, value);
        }
    }

    /**
     * 指定された配列を、カンマ区切りの一つの文字列に変換して返します.
     * @param array 配列. 各要素はtoString()されます.
     * @return 変換後のカンマ区切りの文字列
     */
    protected final String convertArrayToStringWithComma(
            final Object[] array) {
        return StringUtils.convertArrayToStringWithComma(array);
    }

}
