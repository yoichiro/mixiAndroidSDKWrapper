package jp.eisbahn.android.sdk.wrapper.voice;

import org.json.JSONObject;

/**
 * コメントに関する情報を持つモデルクラスです.
 * @author Yoichiro Tanaka
 */
public class Comment extends AbstractVoiceModel {

    /**
     * このインスタンスを初期化します.
     * @param original 情報を持つJSONオブジェクト
     */
    public Comment(final JSONObject original) {
        super(original);
    }

}
