package jp.mixi.android.sdk.wrapper.photo;

import org.json.JSONObject;

/**
 * フォトの情報を持つクラスです.
 * @author Yoichiro Tanaka
 */
public class Photo extends AbstractModel {

    /**
     * このインスタンスを返します.
     * @param newOriginal JSONオブジェクト
     */
    protected Photo(final JSONObject newOriginal) {
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

}
