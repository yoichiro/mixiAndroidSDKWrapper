package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.groups.GetGroupsCallbackHandler;

/**
 * Groups API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface GroupsAPI {

    /**
     * 認可ユーザが持つグループ情報を取得します.
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyGroups(GetGroupsCallbackHandler handler);

}
