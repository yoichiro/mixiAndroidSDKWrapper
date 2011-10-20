package jp.eisbahn.android.sdk.wrapper.checkin;

/**
 * ページングにおける取得方向です.
 * @author Yoichiro Tanaka
 *
 */
public enum ResultsDirection {

    /** 最新の結果からsinceIdで指定された位置まで. */
    recent,
    /** sinceIdで指定された位置よりソート順で後方の結果. */
    next;

}
