package jp.eisbahn.android.sdk.wrapper.groups;

import jp.eisbahn.android.sdk.wrapper.common.Model;

import org.json.JSONObject;

/**
 * ユーザが持つグループの情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Group extends Model {

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Group(final JSONObject original) {
        super(original);
    }

    /**
     * IDを返します.
     * @return ID
     */
    public String getId() {
        return getPropertyString("id");
    }

    /**
     * タイトルを返します.
     * @return タイトル
     */
    public String getTitle() {
        return getPropertyString("title");
    }

}
