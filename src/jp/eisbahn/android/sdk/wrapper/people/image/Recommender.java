package jp.eisbahn.android.sdk.wrapper.people.image;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.people.Person;

/**
 * プロフィール画像を勧めたユーザの情報を持つモデルクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Recommender extends Person {

    /**
     * このオブジェクトが生成されたときに呼び出されます.
     * @param original JSONオブジェクト
     */
    public Recommender(final JSONObject original) {
        super(original);
    }

    /**
     * メッセージを返します.
     * @return メッセージ
     */
    public final String getMessage() {
        return getPropertyString("message");
    }

}
