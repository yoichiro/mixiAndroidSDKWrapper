package jp.eisbahn.android.sdk.wrapper;

import java.io.InputStream;

import jp.eisbahn.android.sdk.wrapper.people.image.GetImagesParams;
import jp.eisbahn.android.sdk.wrapper.people.image
.GetProfileImagesCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.people.image.Privacy;

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

    /**
     * 認可ユーザが持つプロフィール画像の一覧を返します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyProfileImages(GetImagesParams params,
            GetProfileImagesCallbackHandler handler);

    /**
     * 認可ユーザのある友人が持つプロフィール画像の一覧を返します.
     * @param userId 友人のユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendProfileImages(String userId,
            GetProfileImagesCallbackHandler handler);

    /**
     * 認可ユーザが持つプロフィール画像の一覧を返します.
     * @param userId 友人のユーザID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendProfileImages(String userId, GetImagesParams params,
            GetProfileImagesCallbackHandler handler);

    /**
     * 認可ユーザが持つプロフィール画像を返します.
     * @param imageId 画像のID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyProfileImage(String imageId,
            GetProfileImagesCallbackHandler handler);

    /**
     * 認可ユーザが持つプロフィール画像の一覧を返します.
     * @param imageId 画像のID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getMyProfileImage(String imageId, GetImagesParams params,
            GetProfileImagesCallbackHandler handler);

    /**
     * 認可ユーザのある友人が持つプロフィール画像の一覧を返します.
     * @param userId 友人のユーザID
     * @param imageId 画像のID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendProfileImage(String userId, String imageId,
            GetProfileImagesCallbackHandler handler);

    /**
     * 認可ユーザが持つプロフィール画像の一覧を返します.
     * @param userId 友人のユーザID
     * @param imageId 画像のID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getFriendProfileImage(String userId, String imageId,
            GetImagesParams params, GetProfileImagesCallbackHandler handler);

    /**
     * プロフィール画像を新規に登録します.
     * @param in 画像の入力ストリーム
     * @param privacy 公開範囲
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void uploadProfileImage(InputStream in, Privacy privacy,
            GetIdCallbackHandler handler);

    /**
     * 認可ユーザが持つプロフィール画像を削除します.
     * @param imageId 画像のID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteMyProfileImage(String imageId, CallbackAdapter handler);

}
