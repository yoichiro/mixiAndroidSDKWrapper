package jp.eisbahn.android.sdk.wrapper;


/**
 * mixi API SDK for Androidをより手軽に利用するための処理が
 * 規定されたインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface MixiWrapper {

    /**
     * mixiアプリ向けリクエストAPIに関する処理を持つオブジェクトを返します.
     * @return mixiアプリ向けリクエストAPIに関する処理を持つオブジェクト
     */
    RequestAPI getRequestAPI();

    /**
     * People APIに関する処理を持つオブジェクトを返します.
     * @return People APIに関する処理を持つオブジェクト
     */
    PeopleAPI getPeopleAPI();

    /**
     * Photo APIに関する処理を持つオブジェクトを返します.
     * @return Photo APIに関する処理を持つオブジェクト
     */
    PhotoAPI getPhotoAPI();

}
