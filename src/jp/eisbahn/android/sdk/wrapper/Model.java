package jp.eisbahn.android.sdk.wrapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * コンテンツの情報を持つクラスに共通な処理を提供する抽象クラスです.
 * @author Yoichiro Tanaka
 *
 */
public abstract class Model {

    /** JSONオブジェクト. */
    private JSONObject original;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Model(final JSONObject original) {
        super();
        this.original = original;
    }

    /**
     * 属性値を文字列として返します.
     * @param propertyName 属性名
     * @return 属性値
     */
    protected final String getPropertyString(final String propertyName) {
        try {
            return (String) original.get(propertyName);
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 属性値をint値として返します.
     * @param propertyName 属性名
     * @return 属性値
     */
    protected final int getPropertyInt(final String propertyName) {
        Object value;
        try {
            value = original.get(propertyName);
        } catch (JSONException e) {
            value = null;
        }
        if (value == null) {
            return 0;
        } else if (value instanceof Integer) {
            return (Integer) value;
        } else {
            return Integer.parseInt((String) value);
        }
    }

    /**
     * 属性値をboolean値として返します.
     * @param propertyName 属性名
     * @return 属性値
     */
    protected final boolean getPropertyBoolean(final String propertyName) {
        Object value;
        try {
            value = original.get(propertyName);
        } catch (JSONException e) {
            value = null;
        }
        if (value == null) {
            return false;
        } else if (value instanceof Boolean) {
            return (Boolean) value;
        } else {
            return Boolean.parseBoolean((String) value);
        }
    }

    /**
     * 属性値を文字列配列として返します.
     * @param propertyName 属性名
     * @return 属性値
     */
    protected final String[] getPropertyStringArray(final String propertyName) {
        JSONArray array;
        try {
            array = (JSONArray) original.get(propertyName);
        } catch (JSONException e) {
            return null;
        }
        String[] result = new String[array.length()];
        for (int i = 0; i < array.length(); i++) {
            try {
                result[i] = array.getString(i);
            } catch (JSONException e) {
                result[i] = null;
            }
        }
        return result;
    }

    /**
     * 属性値をJSONオブジェクトとして返します.
     * @param propertyName 属性名
     * @return 属性値
     */
    protected final JSONObject getPropertyJSONObject(
            final String propertyName) {
        try {
            return (JSONObject) original.get(propertyName);
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 属性値をJSON配列として返します.
     * @param propertyName 属性名
     * @return 属性値
     */
    protected final JSONArray getPropertyJSONArray(final String propertyName) {
        try {
            return (JSONArray) original.get(propertyName);
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * オリジナルのJSONオブジェクトを返します.
     * @return JSONオブジェクト
     */
    public final JSONObject getOriginal() {
        return original;
    }

}
