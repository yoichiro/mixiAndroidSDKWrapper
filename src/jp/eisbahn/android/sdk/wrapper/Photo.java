package jp.eisbahn.android.sdk.wrapper;

import java.text.ParseException;
import java.util.Date;

import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

import org.json.JSONObject;

/**
 * フォトの情報を持つクラスです.
 * @author Yoichiro Tanaka
 */
public class Photo extends Model {

    /**
     * このインスタンスを返します.
     * @param newOriginal JSONオブジェクト
     */
    public Photo(final JSONObject newOriginal) {
        super(newOriginal);
    }

    /**
     * アルバムIDを返します.
     * @return アルバムID
     */
    public final String getAlbumId() {
        return getPropertyString("albumId");
    }

    /**
     * 大きな画像のURLを返します.
     * @return 大きな画像のURL
     */
    public final String getLargeImageUrl() {
        return getPropertyString("largeImageUrl");
    }

    /**
     * MIMEタイプを返します.
     * @return MIMEタイプ
     */
    public final String getMimeType() {
        return getPropertyString("mimeType");
    }

    /**
     * いいね！の数を返します.
     * @return いいね！の数
     */
    public final int getNumFavorites() {
        return getPropertyInt("numFavorites");
    }

    /**
     * 種別を返します.
     * @return 種別
     */
    public final String getType() {
        return getPropertyString("type");
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
