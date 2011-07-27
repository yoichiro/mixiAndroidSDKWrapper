package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.groups.GetGroupsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.groups.GetGroupsParams;

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

    /**
     * 認可ユーザが持つグループ情報を取得します.
     * @param params 取得条件
     * @param handler 処理結果を受け取るためのコールバックリスナ
     */
    void getMyGroups(GetGroupsParams params, GetGroupsCallbackHandler handler);

}
