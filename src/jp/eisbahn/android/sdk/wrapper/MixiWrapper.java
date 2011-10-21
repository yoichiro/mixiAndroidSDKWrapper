package jp.eisbahn.android.sdk.wrapper;

import jp.mixi.android.sdk.MixiContainer;


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

    /**
     * Groups APIに関する処理を持つオブジェクトを返します.
     * @return Groups APIに関する処理を持つオブジェクト
     */
    GroupsAPI getGroupsAPI();

    /**
     * Search APIに関する処理を持つオブジェクトを返します.
     * @return Search APIに関する処理を持つオブジェクト
     */
    SearchAPI getSearchAPI();

    /**
     * Check APIに関する処理を持つオブジェクトを返します.
     * @return Check APIに関する処理を持つオブジェクト
     */
    CheckAPI getCheckAPI();

    /**
     * Diary APIに関する処理を持つオブジェクトを返します.
     * @return Diary APIに関する処理を持つオブジェクト
     */
    DiaryAPI getDiaryAPI();

    /**
     * Message APIに関する処理を持つオブジェクトを返します.
     * @return Message APIに関する処理を持つオブジェクト
     */
    MessageAPI getMessageAPI();

    /**
     * Voice APIに関する処理を持つオブジェクトを返します.
     * @return Voice APIに関する処理を持つオブジェクト
     */
    VoiceAPI getVoiceAPI();

    /**
     * Updates APIに関する処理を持つオブジェクトを返します.
     * @return Updates APIに関する処理を持つオブジェクト
     */
    UpdatesAPI getUpdatesAPI();

    /**
     * Profile Image APIに関する処理を持つオブジェクトを返します.
     * @return Profile Image APIに関する処理を持つオブジェクト
     */
    ProfileImageAPI getProfileImageAPI();

    /**
     * Checkin APIに関する処理を持つオブジェクトを返します.
     * @return Checkin APIに関する処理を持つオブジェクト
     */
    CheckinAPI getCheckinAPI();

    /**
     * {@see MixiContainer}オブジェクトを返します.
     * @return {@see MixiContainer}オブジェクト
     */
    MixiContainer getContainer();

}
