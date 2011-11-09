package jp.eisbahn.android.sdk.wrapper;

import java.io.InputStream;

import jp.eisbahn.android.sdk.wrapper.checkin.CheckinField;
import jp.eisbahn.android.sdk.wrapper.checkin.GetCheckinCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.checkin.GetCheckinsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.checkin.GetCheckinsParams;
import jp.eisbahn.android.sdk.wrapper.checkin.GetCommentsParams;
import jp.eisbahn.android.sdk.wrapper.checkin.GetFavoritesParams;
import jp.eisbahn.android.sdk.wrapper.checkin.GetSpotCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.checkin.GetSpotsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.checkin.GetSpotsParams;
import jp.eisbahn.android.sdk.wrapper.checkin.SearchSpotsParams;
import jp.eisbahn.android.sdk.wrapper.checkin.SpotField;


/**
 * Check-in API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface CheckinAPI {

    /**
     * 指定されたスポットIDのスポット情報を取得します.
     * @param spotId スポットID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSpot(String spotId, GetSpotCallbackHandler handler);

    /**
     * 指定されたスポットIDのスポット情報を取得します.
     * @param spotId スポットID
     * @param fields 取得したい項目
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSpot(String spotId, SpotField[] fields,
            GetSpotCallbackHandler handler);

    /**
     * 指定された条件でスポットを検索します.
     * @param latitude 緯度
     * @param longitude 軽度
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void searchSpots(double latitude, double longitude,
            GetSpotsCallbackHandler handler);

    /**
     * 指定された条件でスポットを検索します.
     * @param params 条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void searchSpots(SearchSpotsParams params,
            GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザが作成したスポット情報を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMySpots(GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザが作成したスポット情報を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMySpots(GetSpotsParams params, GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザのある友人が作成したスポット情報を取得します.
     * @param userId 友人のユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendSpots(String userId, GetSpotsCallbackHandler handler);

    /**
     * 認可ユーザのある友人が作成したスポット情報を取得します.
     * @param userId 友人のユーザID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendSpots(String userId, GetSpotsParams params,
            GetSpotsCallbackHandler handler);

    /**
     * 新規にマイスポットを作成します.
     * @param name スポット名
     * @param description スポットの説明
     * @param latitude 緯度
     * @param longitude 軽度
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void createSpot(String name, String description, double latitude,
            double longitude, GetIdCallbackHandler handler);

    /**
     * マイスポットを削除します.
     * @param spotId スポットID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteSpot(String spotId, CallbackAdapter handler);

    /**
     * 認可ユーザのチェックインフィード一覧を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckins(GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザのチェックインフィード一覧を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckins(GetCheckinsParams params,
            GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザのある友人のチェックインフィード一覧を取得します.
     * @param userId 友人のユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckins(String userId, GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザのある友人のチェックインフィード一覧を取得します.
     * @param userId 友人のユーザID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckins(String userId, GetCheckinsParams params,
            GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザのあるグループのチェックインフィード一覧を取得します.
     * @param groupId グループID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getGroupCheckins(String groupId, GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザのあるグループのチェックインフィード一覧を取得します.
     * @param groupId グループID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getGroupCheckins(String groupId, GetCheckinsParams params,
            GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインフィード一覧を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendsCheckins(GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインフィード一覧を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendsCheckins(GetCheckinsParams params,
            GetCheckinsCallbackHandler handler);

    /**
     * 認可ユーザのチェックインフィード情報を取得します.
     * @param checkinId チェックインフィードのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckin(String checkinId, GetCheckinCallbackHandler handler);

    /**
     * 認可ユーザのチェックインフィード情報を取得します.
     * @param checkinId チェックインフィードのID
     * @param fields 取得対象の項目
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckin(String checkinId, CheckinField[] fields,
            GetCheckinCallbackHandler handler);

    /**
     * 認可ユーザのある友人のチェックインフィード情報を取得します.
     * @param userId 友人のユーザID
     * @param checkinId チェックインフィードのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckin(String userId, String checkinId,
            GetCheckinCallbackHandler handler);

    /**
     * 認可ユーザのある友人のチェックインフィード情報を取得します.
     * @param userId 友人のユーザID
     * @param checkinId チェックインフィードのID
     * @param fields 取得対象の項目
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckin(String userId, String checkinId,
            CheckinField[] fields,
            GetCheckinCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param message メッセージ
     * @param visibility 公開範囲
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, String message, Visibility visibility,
            GetIdCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param message メッセージ
     * @param groupId 公開するグループのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, String message, String groupId,
            GetIdCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param latitude 緯度
     * @param longitude 経度
     * @param message メッセージ
     * @param visibility 公開範囲
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, double latitude, double longitude,
            String message, Visibility visibility,
            GetIdCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param latitude 緯度
     * @param longitude 経度
     * @param message メッセージ
     * @param groupId 公開するグループのID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, double latitude, double longitude,
            String message, String groupId, GetIdCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param message メッセージ
     * @param visibility 公開範囲
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, String message, Visibility visibility,
            InputStream image, GetIdCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param message メッセージ
     * @param groupId 公開するグループID
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, String message, String groupId,
            InputStream image, GetIdCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param latitude 緯度
     * @param longitude 経度
     * @param message メッセージ
     * @param visibility 公開範囲
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, double latitude, double longitude,
            String message, Visibility visibility, InputStream image,
            GetIdCallbackHandler handler);

    /**
     * 指定されたスポットにチェックインします.
     * @param spotId スポットID
     * @param latitude 緯度
     * @param longitude 経度
     * @param message メッセージ
     * @param groupId 公開するグループのID
     * @param image 画像の入力ストリーム
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void checkin(String spotId, double latitude, double longitude,
            String message, String groupId, InputStream image,
            GetIdCallbackHandler handler);

    /**
     * 認可ユーザが行ったチェックインを削除します.
     * @param checkinId チェックインID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteCheckin(String checkinId, CallbackAdapter handler);

    /**
     * 認可ユーザのチェックインに付けられたコメントを取得します.
     * @param checkinId チェックインID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckinComments(String checkinId,
            GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザのチェックインに付けられたコメントを取得します.
     * @param checkinId チェックインID
     * @param params 取得条件を持つパラメータクラス
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckinComments(String checkinId, GetCommentsParams params,
            GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインに付けられたコメントを取得します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckinComments(String userId, String checkinId,
            GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインに付けられたコメントを取得します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param params 取得条件を持つパラメータクラス
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckinComments(String userId, String checkinId,
            GetCommentsParams params, GetCommentsCallbackHandler handler);

    /**
     * 認可ユーザのチェックインにコメントを投稿します.
     * @param checkinId チェックインID
     * @param text コメントの本文
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postMyCheckinComment(String checkinId, String text,
            GetIdCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインにコメントを投稿します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param text コメントの本文
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postFriendCheckinComment(String userId, String checkinId, String text,
            GetIdCallbackHandler handler);

    /**
     * 認可ユーザのチェックインに投稿されたコメントを削除します.
     * @param checkinId チェックインID
     * @param commentId コメントID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteMyCheckinComment(String checkinId, String commentId,
            CallbackAdapter handler);

    /**
     * 認可ユーザの友人のチェックインに投稿されたコメントを削除します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param commentId コメントID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteFriendCheckinComment(String userId, String checkinId,
            String commentId, CallbackAdapter handler);

    /**
     * 認可ユーザのチェックインに投稿されたいいね！を取得します.
     * @param checkinId チェックインID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckinFavorites(String checkinId,
            GetUsersCallbackHandler handler);

    /**
     * 認可ユーザのチェックインに投稿されたいいね！を取得します.
     * @param checkinId チェックインID
     * @param params 取得条件を持つパラメータオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyCheckinFavorites(String checkinId, GetFavoritesParams params,
            GetUsersCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインに投稿されたいいね！を取得します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckinFavorites(String userId, String checkinId,
            GetUsersCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインに投稿されたいいね！を取得します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param params 取得条件を持つパラメータオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendCheckinFavorites(String userId, String checkinId,
            GetFavoritesParams params, GetUsersCallbackHandler handler);

    /**
     * 認可ユーザの友人のチェックインにいいね！を投稿します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void postFriendCheckinFavorite(String userId, String checkinId,
            GetIdCallbackHandler handler);

    /**
     * 認可ユーザのチェックインに投稿されたいいね！を削除します.
     * @param checkinId チェックインID
     * @param favoriteUserId いいね！をしたユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteMyCheckinFavorite(String checkinId, String favoriteUserId,
            CallbackAdapter handler);

    /**
     * 認可ユーザの友人のチェックインに投稿されたいいね！を削除します.
     * @param userId ユーザID
     * @param checkinId チェックインID
     * @param favoriteUserId いいね！をしたユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteFriendCheckinFavorite(String userId, String checkinId,
            String favoriteUserId, CallbackAdapter handler);

}
