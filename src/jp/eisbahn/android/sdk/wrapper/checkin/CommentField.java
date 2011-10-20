package jp.eisbahn.android.sdk.wrapper.checkin;

/**
 * 取得したいチェックイン履歴情報の項目を指定します.
 * @author Yoichiro Tanaka
 *
 */
public enum CommentField {

    /** 全て. */
    all,
    /** ID. */
    id,
    /** ユーザ. */
    user,
    /** ユーザ-ID. */
    user_id,
    /** ユーザ-ニックネーム. */
    user_displayName,
    /** ユーザ-プロフィール画像URL. */
    user_thumbnailUrl,
    /** ユーザ-プロフィールページURL. */
    user_profileUrl,
    /** 投稿日時. */
    created,
    /** 本文. */
    text;

    /**
     * 実際使用されるField値を返します.
     * @return '_'が'.'に置換された後の文字列
     */
    @Override
    public String toString() {
        if (this.name().equals(CommentField.all)) {
            return "@all";
        } else {
            return this.name().replace('_', '.');
        }
    }

}
