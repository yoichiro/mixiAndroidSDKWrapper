package jp.eisbahn.android.sdk.wrapper.checkin;

import java.text.ParseException;
import java.util.Date;

import jp.eisbahn.android.sdk.wrapper.common.Comment;
import jp.eisbahn.android.sdk.wrapper.common.Model;
import jp.eisbahn.android.sdk.wrapper.common.Photo;
import jp.eisbahn.android.sdk.wrapper.common.User;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * スポット情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Checkin extends Model {

    /** 位置情報. */
    private Location location;

    /** ユーザ情報. */
    private User user;

    /** スポット情報. */
    private Spot spot;

    /** コメント情報. */
    private Comment[] comments;

    /** いいねをしたユーザ情報. */
    private User[] favorites;

    /** フォト情報. */
    private Photo[] photos;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param original JSONオブジェクト
     */
    public Checkin(final JSONObject original) {
        super(original);
        location = new Location(getPropertyJSONObject("location"));
        user = new User(getPropertyJSONObject("user"));
        spot = new Spot(getPropertyJSONObject("spot"));
        parseCommentList();
        parseFavoriteList();
        parsePhotoList();
    }

    /**
     * 位置情報を返します.
     * @return 位置情報
     */
    public final Location getLocation() {
        return location;
    }

    /**
     * IDを返します.
     * @return ID
     */
    public final String getId() {
        return getPropertyString("id");
    }

    /**
     * メッセージを返します.
     * @return メッセージ
     */
    public final String getMessage() {
        return getPropertyString("message");
    }

    /**
     * ユーザ情報を返します.
     * @return ユーザ情報
     */
    public final User getUser() {
        return user;
    }

    /**
     * スポット情報を返します.
     * @return スポット情報
     */
    public final Spot getSpot() {
        return spot;
    }

    /**
     * コメント数を返します.
     * @return コメント数
     */
    public int getNumComments() {
        return getPropertyInt("numComments");
    }

    /**
     * いいね数を返します.
     * @return いいね数
     */
    public int getNumFavorites() {
        return getPropertyInt("numFavorites");
    }

    /**
     * コメントのリストをパースします.
     */
    private void parseCommentList() {
        JSONArray array = getPropertyJSONArray("comments");
        if (array != null) {
            try {
                int size = array.length();
                comments = new Comment[size];
                for (int i = 0; i < size; i++) {
                    comments[i] =
                        new Comment((JSONObject) array.getJSONObject(i));
                }
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /**
     * いいねをしたユーザのリストをパースします.
     */
    private void parseFavoriteList() {
        JSONArray array = getPropertyJSONArray("favorites");
        if (array != null) {
            try {
                int size = array.length();
                favorites = new User[size];
                for (int i = 0; i < size; i++) {
                    favorites[i] =
                        new User((JSONObject) array.getJSONObject(i));
                }
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
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
                    photos[i] =
                        new Photo((JSONObject) array.getJSONObject(i));
                }
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /**
     * コメントの配列を返します.
     * @return コメントの配列
     */
    public final Comment[] getComments() {
        return comments;
    }

    /**
     * いいねをしたユーザ情報の配列を返します.
     * @return いいねをしたユーザ情報の配列
     */
    public final User[] getFavorites() {
        return favorites;
    }

    /**
     * 認可ユーザがいいねをしたかどうかを返します.
     * @return 認可ユーザがいいねをした場合はtrue
     */
    public final boolean isFavorited() {
        return getPropertyBoolean("favorited");
    }

    /**
     * created属性値を返します.
     * @return コメント投稿日時
     * @throws ParseException パースに失敗したとき
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
     * フォト情報の配列を返します.
     * @return フォト情報の配列
     */
    public final Photo[] getPhotos() {
        return photos;
    }

}
