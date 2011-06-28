package jp.mixi.android.sdk.wrapper.photo;

import org.json.JSONObject;

import jp.mixi.android.sdk.wrapper.Model;

/**
 * プライバシー情報を持つクラスです.
 * @author Yoichiro Tanaka
 */
public class Privacy extends Model {

    /**
     * Initialize this instance.
     * @param newOriginal The JSON object.
     */
    public Privacy(final JSONObject newOriginal) {
        super(newOriginal);
    }

    /**
     * Retrieve the visibility.
     * @return The visibility value.
     */
    public final Visibility getVisibility() {
        return Visibility.valueOf(getPropertyString("visibility"));
    }

}
