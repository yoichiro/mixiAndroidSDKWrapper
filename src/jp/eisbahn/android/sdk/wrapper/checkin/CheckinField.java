package jp.eisbahn.android.sdk.wrapper.checkin;

/**
 * 取得したいチェックイン履歴情報の項目を指定します.
 * @author Yoichiro Tanaka
 *
 */
public enum CheckinField {

    /** 全て. */
    all,
    /** ID. */
    id,
    /** チェックインしたユーザ. */
    user,
    /** チェックインしたユーザ-ID. */
    user_id,
    /** チェックインしたユーザ-ニックネーム. */
    user_displayName,
    /** チェックインしたユーザ-プロフィール画像URL. */
    user_thumbnailUrl,
    /** チェックインしたユーザ-プロフィールページURL. */
    user_profileUrl,
    /** メッセージ. */
    message,
    /** 対象スポット. */
    spot,
    /** 対象スポット-ID. */
    spot_id,
    /** 対象スポット-スポットの名前. */
    spot_name,
    /** 対象スポット-自由記入の説明文. */
    spot_description,
    /** 対象スポット-スポット管理者. */
    spot_owner,
    /** 対象スポット-スポット管理者-ID. */
    spot_owner_id,
    /** 対象スポット-スポット管理者-ニックネーム. */
    spot_owner_displayName,
    /** 対象スポット-スポット管理者-プロフィール画像URL. */
    spot_owner_thumbnailUrl,
    /** 対象スポット-スポット管理者-プロフィールページURL. */
    spot_owner_profileUrl,
    /** 対象スポット-カテゴリ. */
    spot_categories,
    /** 対象スポット-住所. */
    spot_address,
    /** 対象スポット-住所-書式化された住所. */
    spot_address_formatted,
    /** 対象スポット-住所-緯度. */
    spot_address_latitude,
    /** 対象スポット-住所-軽度. */
    spot_address_longitude,
    /** 対象スポット-住所-Geohash. */
    spot_address_geohash,
    /** 対象スポット-住所-距離. */
    spot_address_distance,
    /** 位置. */
    location,
    /** 位置-緯度. */
    location_latitude,
    /** 位置-軽度. */
    location_longitude,
    /** 位置-Geohash. */
    location_geohash,
    /** 位置-距離. */
    location_distance,
    /** コメント数. */
    numComments,
    /** いいね数. */
    numFavorites,
    /** コメント. */
    comments,
    /** コメント-ID. */
    comments_id,
    /** コメント-ユーザ. */
    comments_user,
    /** コメント-ユーザ-ID. */
    comments_user_id,
    /** コメント-ユーザ-ニックネーム. */
    comments_user_displayName,
    /** コメント-ユーザ-プロフィール画像URL. */
    comments_user_thumbnailUrl,
    /** コメント-ユーザ-プロフィールページURL. */
    comments_user_profileUrl,
    /** コメント-投稿日時. */
    comments_created,
    /** コメント-本文. */
    comments_text,
    /** いいね. */
    favorites,
    /** いいね-ユーザID. */
    favorites_id,
    /** いいね-ニックネーム. */
    favorites_displayName,
    /** いいね-プロフィール画像URL. */
    favorites_thumbnailUrl,
    /** いいね-プロフィールページURL. */
    favorites_profileUrl,
    /** 自分がいいねしたかどうか. */
    favorited,
    /** フォト. */
    photo,
    /** フォト-アルバムID. */
    photo_albumId,
    /** フォト-投稿日時. */
    photo_created,
    /** フォト-ID. */
    photo_id,
    /** フォト-大きな画像のURL. */
    photo_largeImageUrl,
    /** フォト-MIMEタイプ. */
    photo_mimeType,
    /** フォト-コメント数. */
    photo_numComments,
    /** フォト-いいね数. */
    photo_numFavorites,
    /** フォト-サムネイル画像URL. */
    photo_thumbnailUrl,
    /** フォト-タイトル. */
    photo_title,
    /** フォト-タイプ. */
    photo_type,
    /** フォト-URL. */
    photo_url,
    /** フォト-フォトページURL. */
    photo_viewPageUrl,
    /** 作成日時. */
    created;

    /**
     * 実際使用されるField値を返します.
     * @return '_'が'.'に置換された後の文字列
     */
    @Override
    public String toString() {
        if (this.name().equals(CheckinField.all)) {
            return "@all";
        } else {
            return this.name().replace('_', '.');
        }
    }

}
