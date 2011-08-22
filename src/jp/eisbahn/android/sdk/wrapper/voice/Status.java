package jp.eisbahn.android.sdk.wrapper.voice;

import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * つぶやきの情報を持つモデルクラスです.
 * @author Yoichiro Tanaka
 */
public class Status extends AbstractVoiceModel {

    /** フォトのリスト. */
    private Photo[] photos;

    /**
     * このインスタンスを初期化します.
     * @param original 情報を持つJSONオブジェクト.
     */
    protected Status(final JSONObject original) {
        super(original);
        parsePhotoList();
    }

    /**
     * フォトのリストをパースします.
     */
    private void parsePhotoList() {
        JSONArray array = getPropertyJSONArray("photo");
        if (array != null) {
            try {
                int size = array.length();
                photos = new Photo[size];
                for (int i = 0; i < size; i++) {
                    photos[i] = new Photo((JSONObject) array.getJSONObject(i));
                }
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /**
     * 返信数を返します.
     * @return 返信数.
     */
    public final int getReplyCount() {
        return getPropertyInt("reply_count");
    }

    /**
     * いいね！数を返します.
     * @return いいね！数.
     */
    public final int getFavoriteCount() {
        return getPropertyInt("favorite_count");
    }

    /**
     * フォトのリストを返します.
     * @return フォトのリスト.
     */
    public final Photo[] getPhotos() {
        return photos;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        String createAt;
        try {
            createAt = getCreatedAt().toString();
        } catch (ParseException e) {
            createAt = e.getMessage();
        }
        return "Status [getReplyCount()=" + getReplyCount()
                + ", getFavoriteCount()=" + getFavoriteCount() + ", getId()="
                + getId() + ", getCreatedAt()=" + createAt
                + ", getText()=" + getText() + ", getUser()=" + getUser() + "]";
    }

}
