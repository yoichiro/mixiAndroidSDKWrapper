package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.common.Model;
import jp.eisbahn.android.sdk.wrapper.common.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * スポット情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Spot extends Model {

    /** 住所情報. */
    private Address address;

    /** 名前情報. */
    private Name name;

    /** カテゴリ情報の配列. */
    private Category[] categories;

    /** オーナー情報. */
    private User owner;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Spot(final JSONObject original) {
        super(original);
        address = new Address(getPropertyJSONObject("address"));
        name = new Name(getPropertyJSONObject("name"));
        parseCategoryList();
        owner = new User(getPropertyJSONObject("owner"));
    }

    /**
     * カテゴリ名を返します.
     * @return カテゴリ名
     */
    public final String getFormatted() {
        return getPropertyString("formatted");
    }

    /**
     * 住所情報を返します.
     * @return 住所情報
     */
    public final Address getAddress() {
        return address;
    }

    /**
     * IDを返します.
     * @return ID
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * 自由記入の説明文を返します.
     * @return 自由記入の説明文
     */
    public final String getDescription() {
        return getPropertyString("description");
    }

    /**
     * 名前情報を返します.
     * @return 名前情報
     */
    public final Name getName() {
        return name;
    }

    /**
     * カテゴリのリストをパースします.
     */
    private void parseCategoryList() {
        JSONArray array = getPropertyJSONArray("categories");
        if (array != null) {
            try {
                int size = array.length();
                categories = new Category[size];
                for (int i = 0; i < size; i++) {
                    categories[i] =
                        new Category((JSONObject) array.getJSONObject(i));
                }
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /**
     * カテゴリ情報の配列をかえします.
     * @return カテゴリ情報
     */
    public final Category[] getCategories() {
        return categories;
    }

    /**
     * オーナー情報を返します.
     * @return オーナー情報
     */
    public final User getOwner() {
        return owner;
    }

}
