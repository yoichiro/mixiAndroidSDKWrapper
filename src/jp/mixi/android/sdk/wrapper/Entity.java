package jp.mixi.android.sdk.wrapper;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * コンテンツの情報を持つクラスに共通な処理を提供する抽象クラスです.
 * @author Yoichiro Tanaka
 *
 */
public abstract class Entity {

    /** JSONオブジェクト. */
    private JSONObject original;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Entity(final JSONObject original) {
        super();
        this.original = original;
    }

    /**
     * JSONオブジェクトを返します.
     * @return JSONオブジェクト
     */
    protected JSONObject getOriginal() {
        return original;
    }

    /**
     * JSONオブジェクトから指定された属性名の値を返します.
     * @param name 属性名
     * @return 値
     */
    protected String getString(final String name) {
        try {
            return original.getString(name);
        } catch (JSONException e) {
            Log.e("mixiAndroidSDKWrapper", e.getMessage(), e);
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
