package jp.eisbahn.android.sdk.wrapper.people.image;

/**
 * プロフィール画像の公開範囲を定義した列挙型です.
 * @author Yoichiro Tanaka
 *
 */
public enum Privacy {

    /** 全体公開. */
    everyone,
    /** 友人に公開. */
    friends,
    /** 未公開. */
    self;

}
