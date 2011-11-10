package jp.eisbahn.android.sdk.wrapper.people.image;

import java.text.ParseException;
import java.util.Date;

import jp.eisbahn.android.sdk.wrapper.common.Model;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

import org.json.JSONObject;

/**
 * プロフィール画像の情報を持つモデルクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class ProfileImage extends Model {

    /** プロフィール画像を勧めたユーザの情報. */
    private Recommender recommender;

    /**
     * このオブジェクトが生成されたときに呼び出されます.
     * @param original JSONオブジェクト
     */
    public ProfileImage(final JSONObject original) {
        super(original);
        recommender = new Recommender(getPropertyJSONObject("recommender"));
    }

    /**
     * IDを返します.
     * @return ID
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * プロフィール画像のURLを返します.
     * @return プロフィール画像のURL
     */
    public final String getThumbnailUrl() {
        return getPropertyString("thumbnailUrl");
    }

    /**
     * create属性値を返します.
     * @return create属性値
     * @throws ParseException もし日付のパース処理に失敗したとき
     */
    public final Date getCreated() throws ParseException {
        String createdAt = getPropertyString("created");
        if (createdAt != null) {
            return DateUtils.convertDate(createdAt);
        } else {
            return null;
        }
    }

    /**
     * プライバシー設定を返します.
     * @return プライバシー設定
     */
    public final Privacy getPrivacy() {
        String privacy = getPropertyString("privacy");
        return Privacy.valueOf(privacy);
    }

    /**
     * メインのプロフィール画像としてセットされているか返します.
     * @return メインのプロフィール画像としてセットされているか
     */
    public final boolean isPrimary() {
        return getPropertyBoolean("primary");
    }

    /**
     * プロフィール画像を勧めたユーザの情報を返します.
     * @return プロフィール画像を勧めたユーザの情報
     */
    public Recommender getRecommender() {
        return recommender;
    }

}
