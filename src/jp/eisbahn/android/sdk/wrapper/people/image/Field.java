package jp.eisbahn.android.sdk.wrapper.people.image;

/**
 * 取得したいプロフィール画像情報の項目を指定します.
 * @author Yoichiro Tanaka
 *
 */
public enum Field {

    /** ID. */
    id,
    /** プロフィール画像のURL. */
    thumbnailUrl,
    /** 公開範囲. */
    privacy,
    /** メイン画像かどうか. */
    primary,
    /** 作成日時. */
    created,
    /** オススメしたユーザの情報. */
    recommender;

}
