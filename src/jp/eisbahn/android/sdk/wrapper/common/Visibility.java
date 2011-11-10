package jp.eisbahn.android.sdk.wrapper.common;

/**
 * 公開範囲を指定します.
 * @author Yoichiro Tanaka
 */
public enum Visibility {

    /** Everyone. */
    everyone,
    /** Friends. */
    friends,
    /** Friends of friends. */
    friends_of_friends,
    /** Top friends. */
    top_friends,
    /** Group. */
    group,
    /** Specific users. */
    user,
    /** Access key. */
    access_key,
    /** Private. */
    self

}
