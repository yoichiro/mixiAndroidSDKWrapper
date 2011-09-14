package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.image
.GetProfileImagesCallbackHandler;

/**
 * Profile Image API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface ProfileImageAPI {

    /**
     * 認可ユーザが持つプロフィール画像の一覧を返します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyProfileImages(GetProfileImagesCallbackHandler handler);

}
