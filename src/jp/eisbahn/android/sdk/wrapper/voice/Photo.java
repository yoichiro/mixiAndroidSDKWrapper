package jp.eisbahn.android.sdk.wrapper.voice;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.common.Model;

/**
 * フォトに関する情報を持つモデルクラスです.
 * @author Yoichiro Tanaka
 */
public class Photo extends Model {

    /**
     * このインスタンスを初期化します.
     * @param newOriginal 情報を持つJSONオブジェクト.
     */
    public Photo(final JSONObject newOriginal) {
        super(newOriginal);
    }

    /**
     * サムネイル画像のURLを返します.
     * @return サムネイル画像のURL.
     */
    public final String getThumbnailUrl() {
        return getPropertyString("thumbnail_url");
    }

    /**
     * 画像のURLを返します.
     * @return 画像のURL.
     */
    public final String getImageUrl() {
        return getPropertyString("image_url");
    }

}
