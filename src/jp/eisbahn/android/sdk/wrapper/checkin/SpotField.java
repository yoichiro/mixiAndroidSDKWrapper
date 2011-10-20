package jp.eisbahn.android.sdk.wrapper.checkin;

/**
 * 取得したいスポット情報の項目を指定します.
 * @author Yoichiro Tanaka
 *
 */
public enum SpotField {

    /** 全て. */
    all,
    /** ID. */
    id,
    /** スポットの名前. */
    name,
    /** 自由記入の説明文. */
    description,
    /** スポット管理者. */
    owner,
    /** スポット管理者-ID. */
    owner_id,
    /** スポット管理者-ニックネーム. */
    owner_displayName,
    /** スポット管理者-プロフィール画像URL. */
    owner_thumbnailUrl,
    /** スポット管理者-プロフィールページURL. */
    owner_profileUrl,
    /** カテゴリ. */
    categories,
    /** 住所. */
    address,
    /** 住所-書式化された住所. */
    address_formatted,
    /** 住所-緯度. */
    address_latitude,
    /** 住所-軽度. */
    address_longitude,
    /** 住所-Geohash. */
    address_geohash,
    /** 住所-距離. */
    address_distance;

    /**
     * 実際使用されるField値を返します.
     * @return '_'が'.'に置換された後の文字列
     */
    @Override
    public String toString() {
        if (this.name().equals(SpotField.all)) {
            return "@all";
        } else {
            return this.name().replace('_', '.');
        }
    }

}
