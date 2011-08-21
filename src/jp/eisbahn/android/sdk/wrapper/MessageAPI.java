package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.message.GetMessagesCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.message.GetMessagesParams;

/**
 * Message API を規定するインタフェースです.
 * @author Yoichiro Tanaka
 *
 */
public interface MessageAPI {

    /**
     * 受信メッセージの一覧を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getReceivedMessages(GetMessagesCallbackHandler handler);

    /**
     * 受信メッセージの一覧を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getReceivedMessages(GetMessagesParams params,
            GetMessagesCallbackHandler handler);

    /**
     * 受信メッセージを取得します.
     * @param messageId メッセージID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getReceivedMessage(String messageId,
            GetMessagesCallbackHandler handler);

    /**
     * 受信メッセージを取得します.
     * @param messageId メッセージID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getReceivedMessage(String messageId, GetMessagesParams params,
            GetMessagesCallbackHandler handler);

    /**
     * 送信メッセージの一覧を取得します.
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSentMessages(GetMessagesCallbackHandler handler);

    /**
     * 送信メッセージの一覧を取得します.
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSentMessages(GetMessagesParams params,
            GetMessagesCallbackHandler handler);

    /**
     * 送信メッセージを取得します.
     * @param messageId メッセージID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSentMessage(String messageId,
            GetMessagesCallbackHandler handler);

    /**
     * 送信メッセージを取得します.
     * @param messageId メッセージID
     * @param params 取得条件を持つオブジェクト
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void getSentMessage(String messageId, GetMessagesParams params,
            GetMessagesCallbackHandler handler);

    /**
     * メッセージを送信します.
     * @param title メッセージのタイトル
     * @param body メッセージの本文
     * @param recipient 送信先のユーザID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void sendMessage(String title, String body, String recipient,
            GetIdCallbackHandler handler);

    /**
     * あるメッセージに返信します.
     * @param title メッセージのタイトル
     * @param body メッセージの本文
     * @param inReplyTo 返信対象のメッセージID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void replyMessage(String title, String body, String inReplyTo,
            GetIdCallbackHandler handler);

    /**
     * 受信したメッセージを削除します.
     * @param messageId メッセージID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteReceivedMessage(String messageId, CallbackAdapter handler);

    /**
     * 送信済みのメッセージを削除します.
     * @param messageId メッセージID
     * @param handler 処理結果を扱うためのハンドラオブジェクト
     */
    void deleteSentMessage(String messageId, CallbackAdapter handler);

}
