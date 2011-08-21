package jp.eisbahn.android.sdk.wrapper.message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.MessageAPI;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Message APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class MessageProxyImpl extends AbstractProxyImpl implements MessageAPI {

    /** 送信者. */
    private static final String SENDER = "sender";
    /** 受信者. */
    private static final String RECIPIENT = "recipient";

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public MessageProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getReceivedMessages(final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(SENDER);
        getContainer().send("/messages/@me/@inbox", handler);
    }

    @Override
    public void getReceivedMessage(final String messageId,
            final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(SENDER);
        getContainer().send("/messages/@me/@inbox/" + messageId, handler);
    }

    @Override
    public void getSentMessages(final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(RECIPIENT);
        getContainer().send("/messages/@me/@outbox", handler);
    }

    @Override
    public void getSentMessage(final String messageId,
            final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(RECIPIENT);
        getContainer().send("/messages/@me/@outbox/" + messageId, handler);
    }

    @Override
    public void getReceivedMessages(final GetMessagesParams params,
            final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(SENDER);
        params.setRelatedUserType(SENDER);
        getContainer().send("/messages/@me/@inbox",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getReceivedMessage(final String messageId,
            final GetMessagesParams params,
            final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(SENDER);
        params.setRelatedUserType(SENDER);
        getContainer().send("/messages/@me/@inbox/" + messageId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getSentMessages(final GetMessagesParams params,
            final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(RECIPIENT);
        params.setRelatedUserType(RECIPIENT);
        getContainer().send("/messages/@me/@outbox",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getSentMessage(final String messageId,
            final GetMessagesParams params,
            final GetMessagesCallbackHandler handler) {
        handler.setRelatedUserType(RECIPIENT);
        params.setRelatedUserType(RECIPIENT);
        getContainer().send("/messages/@me/@outbox/" + messageId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void sendMessage(final String title, final String body,
            final String recipient, final GetIdCallbackHandler handler) {
        try {
            JSONObject json = new JSONObject();
            json.put("title", title);
            json.put("body", body);
            JSONArray recipients = new JSONArray();
            recipients.put(recipient);
            json.put("recipients", recipients);
            getContainer().send("/messages/@me/@self/@outbox", json, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void replyMessage(final String title, final String body,
            final String inReplyTo, final GetIdCallbackHandler handler) {
        try {
            JSONObject json = new JSONObject();
            json.put("title", title);
            json.put("body", body);
            json.put("inReplyTo", inReplyTo);
            getContainer().send("/messages/@me/@self/@outbox", json, handler);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteReceivedMessage(final String messageId,
            final CallbackAdapter handler) {
        getContainer().send("/messages/@me/@self/@inbox/" + messageId,
                HttpMethod.DELETE, handler);
    }

    @Override
    public void deleteSentMessage(final String messageId,
            final CallbackAdapter handler) {
        getContainer().send("/messages/@me/@self/@outbox/" + messageId,
                HttpMethod.DELETE, handler);
    }

}
