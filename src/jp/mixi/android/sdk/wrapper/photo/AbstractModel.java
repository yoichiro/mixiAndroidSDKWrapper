package jp.mixi.android.sdk.wrapper.photo;

import java.text.ParseException;

import java.util.Date;

import org.json.JSONObject;

import jp.mixi.android.sdk.wrapper.Model;
import jp.mixi.android.sdk.wrapper.util.DateUtils;

/**
 * 各種エンティティクラスの親クラスです.
 * @author Yoichiro Tanaka
 */
abstract class AbstractModel extends Model {

    /**
     * このインスタンスを初期化します.
     * @param newOriginal JSONオブジェクト
     */
    protected AbstractModel(final JSONObject newOriginal) {
        super(newOriginal);
    }

    /**
     * createAt属性値を返します.
     * @return createAt属性値
     * @throws ParseException もし日付のパース処理に失敗したとき
     */
    public final Date getCreatedAt() throws ParseException {
        String createdAt = getPropertyString("created");
        if (createdAt != null) {
            return DateUtils.convertDate(createdAt);
        } else {
            return null;
        }
    }

    /**
     * IDを返します.
     * @return ID
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * コメント数を返します.
     * @return コメント数
     */
    public final int getNumComments() {
        return getPropertyInt("numComments");
    }

    /**
     * サムネイル画像のURLを返します.
     * @return サムネイル画像のURL
     */
    public final String getThumbnailUrl() {
        return getPropertyString("thumbnailUrl");
    }

    /**
     * タイトルを返します.
     * @return タイトル
     */
    public final String getTitle() {
        return getPropertyString("title");
    }

    /**
     * URLを返します.
     * @return URL
     */
    public final String getUrl() {
        return getPropertyString("url");
    }

    /**
     * ViewページURLを返します.
     * @return ViewページURL
     */
    public final String getViewPageUrl() {
        return getPropertyString("viewPageUrl");
    }

}
