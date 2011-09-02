package jp.eisbahn.android.sdk.wrapper.people;

import jp.eisbahn.android.sdk.wrapper.User;

import org.json.JSONObject;

/**
 * ユーザのプロフィール情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Person extends User {

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Person(final JSONObject original) {
        super(original);
    }

}
