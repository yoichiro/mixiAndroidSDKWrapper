package jp.eisbahn.android.sdk.wrapper.checkin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.CheckinAPI;
import jp.eisbahn.android.sdk.wrapper.GetCommentsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.GetUsersCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.Visibility;
import jp.eisbahn.android.sdk.wrapper.util.StringUtils;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Check-in APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class CheckinProxyImpl extends AbstractProxyImpl implements CheckinAPI {

    /** バッファサイズ. */
    private static final int BUF_SIZE = 1024;

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public CheckinProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getSpot(final String spotId,
            final GetSpotCallbackHandler handler) {
        getContainer().send("/spots/" + spotId, handler);
    }

    @Override
    public void getSpot(final String spotId, final SpotField[] fields,
            final GetSpotCallbackHandler handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("fields", StringUtils.convertArrayToStringWithComma(fields));
        getContainer().send("/spots/" + spotId, params, handler);
    }

    @Override
    public void searchSpots(final double latitude, final double longitude,
            final GetSpotsCallbackHandler handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("center",
                Double.toString(latitude) + "," + Double.toString(longitude));
        getContainer().send("/search/spots", params, handler);
    }

    @Override
    public void searchSpots(final SearchSpotsParams params,
            final GetSpotsCallbackHandler handler) {
        getContainer().send("/search/spots",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getMySpots(final GetSpotsCallbackHandler handler) {
        getFriendSpots("@me", handler);
    }

    @Override
    public void getFriendSpots(final String userId,
            final GetSpotsCallbackHandler handler) {
        getContainer().send("/spots/" + userId + "/@self", handler);
    }

    @Override
    public void getMySpots(final GetSpotsParams params,
            final GetSpotsCallbackHandler handler) {
        getFriendSpots("@me", params, handler);
    }

    @Override
    public void getFriendSpots(final String userId, final GetSpotsParams params,
            final GetSpotsCallbackHandler handler) {
        getContainer().send("/spots/" + userId + "/@self",
                params.convertParameterMap(), handler);
    }

    @Override
    public void createSpot(final String name, final String description,
            final double latitude, final double longitude,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("name", name);
            JSONObject location = new JSONObject();
            location.put("latitude", String.valueOf(latitude));
            location.put("longitude", String.valueOf(longitude));
            params.put("location", location);
            params.put("description", description);
            getContainer().send("/spots/@me/@self", params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteSpot(final String spotId, final CallbackAdapter handler) {
        getContainer().send("/spots/@me/@self/" + spotId, HttpMethod.DELETE,
                handler);
    }

    @Override
    public void getMyCheckins(final GetCheckinsCallbackHandler handler) {
        getContainer().send("/checkins/@me/@self", handler);
    }

    @Override
    public void getMyCheckins(final GetCheckinsParams params,
            final GetCheckinsCallbackHandler handler) {
        getContainer().send("/checkins/@me/@self",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getFriendCheckins(final String userId,
            final GetCheckinsCallbackHandler handler) {
        getContainer().send("/checkins/" + userId + "/@self", handler);
    }

    @Override
    public void getFriendCheckins(final String userId,
            final GetCheckinsParams params,
            final GetCheckinsCallbackHandler handler) {
        getContainer().send("/checkins/" + userId + "/@self",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getGroupCheckins(final String groupId,
            final GetCheckinsCallbackHandler handler) {
        getContainer().send("/checkins/@me/" + groupId, handler);
    }

    @Override
    public void getGroupCheckins(final String groupId,
            final GetCheckinsParams params,
            final GetCheckinsCallbackHandler handler) {
        getContainer().send("/checkins/@me/" + groupId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getFriendsCheckins(final GetCheckinsCallbackHandler handler) {
        getGroupCheckins("@friends", handler);
    }

    @Override
    public void getFriendsCheckins(final GetCheckinsParams params,
            final GetCheckinsCallbackHandler handler) {
        getGroupCheckins("@friends", params, handler);
    }

    @Override
    public void getMyCheckin(final String checkinId,
            final GetCheckinCallbackHandler handler) {
        getFriendCheckin("@me", checkinId, handler);
    }

    @Override
    public void getMyCheckin(final String checkinId,
            final CheckinField[] fields,
            final GetCheckinCallbackHandler handler) {
        getFriendCheckin("@me", checkinId, fields, handler);
    }

    @Override
    public void getFriendCheckin(final String userId, final String checkinId,
            final GetCheckinCallbackHandler handler) {
        getContainer().send("/checkins/" + userId + "/@self/" + checkinId,
                handler);
    }

    @Override
    public void getFriendCheckin(final String userId, final String checkinId,
            final CheckinField[] fields,
            final GetCheckinCallbackHandler handler) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("fields", StringUtils.convertArrayToStringWithComma(fields));
        getContainer().send("/checkins/" + userId + "/@self/" + checkinId,
                params, handler);
    }

    @Override
    public void checkin(final String spotId, final String message,
            final Visibility visibility,
            final GetIdCallbackHandler handler) {
        postInternal(spotId, message, visibility, null, handler);
    }

    @Override
    public void checkin(final String spotId, final String message,
            final String groupId, final GetIdCallbackHandler handler) {
        postInternal(spotId, message, Visibility.group, groupId, handler);
    }

    @Override
    public void checkin(final String spotId, final double latitude,
            final double longitude, final String message,
            final Visibility visibility, final GetIdCallbackHandler handler) {
        postInternal(spotId, message, latitude, longitude,
                visibility, null, handler);
    }

    @Override
    public void checkin(final String spotId, final double latitude,
            final double longitude, final String message, final String groupId,
            final GetIdCallbackHandler handler) {
        postInternal(spotId, message, latitude, longitude,
                Visibility.group, groupId, handler);
    }

    @Override
    public void checkin(final String spotId, final String message,
            final Visibility visibility, final InputStream image,
            final GetIdCallbackHandler handler) {
        postInternal(spotId, message, visibility, null, image, handler);
    }

    @Override
    public void checkin(final String spotId, final String message,
            final String groupId, final InputStream image,
            final GetIdCallbackHandler handler) {
        postInternal(spotId, message, Visibility.group, groupId,
                image, handler);
    }

    @Override
    public void checkin(final String spotId, final double latitude,
            final double longitude, final String message,
            final Visibility visibility, final InputStream image,
            final GetIdCallbackHandler handler) {
        postInternal(spotId, message, latitude, longitude, visibility, null,
                image, handler);
    }

    @Override
    public void checkin(final String spotId, final double latitude,
            final double longitude, final String message, final String groupId,
            final InputStream image, final GetIdCallbackHandler handler) {
        postInternal(spotId, message, latitude, longitude, Visibility.group,
                groupId, image, handler);
    }

    /**
     * チェックインを実際に行う内部メソッドです.
     * @param spotId スポットID
     * @param message メッセージ
     * @param visibility 公開範囲
     * @param group 特定のグループに公開する際のグループID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    private void postInternal(final String spotId, final String message,
            final Visibility visibility, final String group,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = createRequestJSONObject(message,
                    visibility, group);
            getContainer().send("/checkins/" + spotId, params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * チェックインを実際に行う内部メソッドです.
     * @param spotId スポットID
     * @param message メッセージ
     * @param latitude 緯度
     * @param longitude 経度
     * @param visibility 公開範囲
     * @param group 特定のグループに公開する際のグループID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    private void postInternal(final String spotId, final String message,
            final double latitude, final double longitude,
            final Visibility visibility, final String group,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = createRequestJSONObject(message,
                    latitude, longitude, visibility, group);
            getContainer().send("/checkins/" + spotId, params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * チェックインを実際に行う内部メソッドです.
     * @param spotId スポットID
     * @param message メッセージ
     * @param visibility 公開範囲
     * @param group 特定のグループに公開する際のグループID
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    private void postInternal(final String spotId, final String message,
            final Visibility visibility, final String group,
            final InputStream image,
            final GetIdCallbackHandler handler) {
        postInternal(spotId, message, -1, -1, visibility, group, image,
                handler);
    }

    /**
     * チェックインを実際に行う内部メソッドです.
     * @param spotId スポットID
     * @param message メッセージ
     * @param latitude 緯度
     * @param longitude 経度
     * @param visibility 公開範囲
     * @param group 特定のグループに公開する際のグループID
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    private void postInternal(final String spotId, final String message,
            final double latitude, final double longitude,
            final Visibility visibility, final String group,
            final InputStream image,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params;
            if (latitude >= 0 && longitude >= 0) {
                params = createRequestJSONObject(message,
                        latitude, longitude,
                        visibility, group);
            } else {
                params = createRequestJSONObject(message,
                        visibility, group);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("---mixi_android_sdk_wrapper\r\n");
            sb.append("Content-Disposition: form-data; name=\"request\"\r\n");
            sb.append("\r\n");
            sb.append(params.toString());
            sb.append("\r\n");
            sb.append("---mixi_android_sdk_wrapper\r\n");
            sb.append("Content-Disposition: form-data; name=\"photo1\";"
                    + " filename=\"photo1.jpg\"\r\n");
            sb.append("\r\n");
            byte[] header = sb.toString().getBytes("UTF-8");
            byte[] request = new byte[header.length + image.available()];
            System.arraycopy(header, 0, request, 0, header.length);

            int len = 0;
            int offset = header.length;
            byte[] buf = new byte[BUF_SIZE];
            while ((len = image.read(buf)) != -1) {
                System.arraycopy(buf, 0, request, offset, len);
                offset += len;
            }
            getContainer().send(
                    "/checkins/" + spotId,
                    "multipart/form-data; boundary=-mixi_android_sdk_wrapper",
                    new ByteArrayInputStream(request),
                    request.length,
                    handler);
        } catch (JSONException e) {
            Log.w("mixiAndroidSDKWrapper", e);
            throw new IllegalStateException(e);
        } catch (UnsupportedEncodingException e) {
            Log.w("mixiAndroidSDKWrapper", e);
            throw new IllegalStateException(e);
        } catch (IOException e) {
            Log.w("mixiAndroidSDKWrapper", e);
            throw new IllegalStateException(e);
        } finally {
            try {
                image.close();
            } catch (IOException ex) {
                Log.w("mixiAndroidSDKWrapper", ex);
            }
        }
    }

    /**
     * 指定された内容でリクエストのJSONオブジェクトを構築します.
     * @param message メッセージ
     * @param visibility 公開範囲
     * @param group グループID
     * @return 生成されたJSONオブジェクト
     * @throws JSONException もし何らかの理由でJSONオブジェクトの生成に失敗したとき
     */
    private JSONObject createRequestJSONObject(final String message,
            final Visibility visibility, final String group)
            throws JSONException {
        JSONObject params = new JSONObject();
        params.put("message", message);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        if (group != null) {
            privacy.put("group", group);
        }
        params.put("privacy", privacy);
        return params;
    }

    /**
     * 指定された内容でリクエストのJSONオブジェクトを構築します.
     * @param message メッセージ
     * @param latitude 緯度
     * @param longitude 経度
     * @param visibility 公開範囲
     * @param group グループID
     * @return 生成されたJSONオブジェクト
     * @throws JSONException もし何らかの理由でJSONオブジェクトの生成に失敗したとき
     */
    private JSONObject createRequestJSONObject(final String message,
            final double latitude, final double longitude,
            final Visibility visibility, final String group)
            throws JSONException {
        JSONObject params = new JSONObject();
        params.put("message", message);
        JSONObject location = new JSONObject();
        location.put("latitude", String.valueOf(latitude));
        location.put("longitude", String.valueOf(longitude));
        params.put("location", location);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        if (group != null) {
            privacy.put("group", group);
        }
        params.put("privacy", privacy);
        return params;
    }

    @Override
    public void deleteCheckin(final String checkinId,
            final CallbackAdapter handler) {
        getContainer().send("/checkins/@me/@self/" + checkinId,
                HttpMethod.DELETE, handler);
    }

    @Override
    public void getMyCheckinComments(final String checkinId,
            final GetCommentsCallbackHandler handler) {
        getFriendCheckinComments("@me", checkinId, handler);
    }

    @Override
    public void getMyCheckinComments(final String checkinId,
            final GetCommentsParams params,
            final GetCommentsCallbackHandler handler) {
        getFriendCheckinComments("@me", checkinId, params, handler);
    }

    @Override
    public void getFriendCheckinComments(final String userId,
            final String checkinId, final GetCommentsCallbackHandler handler) {
        getContainer().send(
                "/checkins/comments/" + userId + "/@self/" + checkinId,
                handler);
    }

    @Override
    public void getFriendCheckinComments(final String userId,
            final String checkinId, final GetCommentsParams params,
            final GetCommentsCallbackHandler handler) {
        getContainer().send(
                "/checkins/comments/" + userId + "/@self/" + checkinId,
                params.convertParameterMap(),
                handler);
    }

    @Override
    public void postMyCheckinComment(final String checkinId, final String text,
            final GetIdCallbackHandler handler) {
        postFriendCheckinComment("@me", checkinId, text, handler);
    }

    @Override
    public void postFriendCheckinComment(final String userId,
            final String checkinId, final String text,
            final GetIdCallbackHandler handler) {
        try {
            JSONObject params = new JSONObject();
            params.put("text", text);
            getContainer().send(
                    "/checkins/comments/" + userId + "/@self/" + checkinId,
                    params, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteMyCheckinComment(final String checkinId,
            final String commentId, final CallbackAdapter handler) {
        deleteFriendCheckinComment("@me", checkinId, commentId, handler);
    }

    @Override
    public void deleteFriendCheckinComment(final String userId,
            final String checkinId, final String commentId,
            final CallbackAdapter handler) {
        getContainer().send(
                "/checkins/comments/" + userId + "/@self/" + checkinId + "/"
                + commentId,
                HttpMethod.DELETE, handler);
    }

    @Override
    public void getMyCheckinFavorites(final String checkinId,
            final GetUsersCallbackHandler handler) {
        getFriendCheckinFavorites("@me", checkinId, handler);
    }

    @Override
    public void getMyCheckinFavorites(final String checkinId,
            final GetFavoritesParams params,
            final GetUsersCallbackHandler handler) {
        getFriendCheckinFavorites("@me", checkinId, params, handler);
    }

    @Override
    public void getFriendCheckinFavorites(final String userId,
            final String checkinId,
            final GetUsersCallbackHandler handler) {
        getContainer().send(
                "/checkins/favorites/" + userId + "/@self/" + checkinId,
                handler);
    }

    @Override
    public void getFriendCheckinFavorites(final String userId,
            final String checkinId, final GetFavoritesParams params,
            final GetUsersCallbackHandler handler) {
        getContainer().send(
                "/checkins/favorites/" + userId + "/@self/" + checkinId,
                params.convertParameterMap(),
                handler);
    }

    @Override
    public void postFriendCheckinFavorite(final String userId,
            final String checkinId, final GetIdCallbackHandler handler) {
        getContainer().send(
                "/checkins/favorites/" + userId + "/@self/" + checkinId,
                HttpMethod.POST,
                handler);
    }

    @Override
    public void deleteMyCheckinFavorite(final String checkinId,
            final String favoriteUserId, final CallbackAdapter handler) {
        deleteFriendCheckinFavorite("@me", checkinId, favoriteUserId, handler);
    }

    @Override
    public void deleteFriendCheckinFavorite(final String userId,
            final String checkinId, final String favoriteUserId,
            final CallbackAdapter handler) {
        getContainer().send(
                "/checkins/favorites/" + userId + "/@self/" + checkinId
                + "/" + favoriteUserId, HttpMethod.DELETE, handler);
    }
}
