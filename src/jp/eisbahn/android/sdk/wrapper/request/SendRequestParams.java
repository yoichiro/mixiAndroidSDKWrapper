package jp.eisbahn.android.sdk.wrapper.request;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.common.AbstractParams;

/**
 * mixiアプリ向けAPIであるリクエスト送信を行うために必要となる
 * パラメータを持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class SendRequestParams extends AbstractParams {

    /** 本文. */
    private String message;

    /** 送信先のユーザIDの配列. */
    private String[] recipients;

    /** PC向けのこのリクエストの飛び先のURL. */
    private String url;

    /** Feature-phone向けのこのリクエストの飛び先のURL. */
    private String mobileUrl;

    /** 画像のURL. */
    private String image;

    /**
     * 指定された情報でこのインスタンスを初期化します.
     * @param newMessage 本文
     * @param newRecipients 送信先のユーザIDの配列
     * @param newUrl PC向けのこのリクエストの飛び先のURL
     * @param newMobileUrl Feature-phone向けのこのリクエストの飛び先のURL
     * @param newImage 画像のURL
     */
    public SendRequestParams(
            final String newMessage,
            final String[] newRecipients,
            final String newUrl,
            final String newMobileUrl,
            final String newImage) {
        super();
        this.message = newMessage;
        this.recipients = newRecipients;
        this.url = newUrl;
        this.mobileUrl = newMobileUrl;
        this.image = newImage;
    }

    /**
     * 本文を返します.
     * @return 本文
     */
    public final String getMessage() {
        return message;
    }

    /**
     * 本文をセットします.
     * @param newMessage 本文
     */
    public final void setMessage(final String newMessage) {
        this.message = newMessage;
    }

    /**
     * 送信先のユーザIDの配列を返します.
     * @return 送信先のユーザIDの配列
     */
    public final String[] getRecipients() {
        return recipients;
    }

    /**
     * 送信先のユーザIDの配列をセットします.
     * @param newRecipients 送信先のユーザIDの配列
     */
    public final void setRecipients(final String[] newRecipients) {
        this.recipients = newRecipients;
    }

    /**
     * PC向けのこのリクエストの飛び先のURLを返します.
     * @return PC向けのこのリクエストの飛び先のURL
     */
    public final String getUrl() {
        return url;
    }

    /**
     * PC向けのこのリクエストの飛び先のURLをセットします.
     * @param newUrl PC向けのこのリクエストの飛び先のURL
     */
    public final void setUrl(final String newUrl) {
        this.url = newUrl;
    }

    /**
     * Feature-phone向けのこのリクエストの飛び先のURLを返します.
     * @return Feature-phone向けのこのリクエストの飛び先のURL
     */
    public final String getMobileUrl() {
        return mobileUrl;
    }

    /**
     * Feature-phone向けのこのリクエストの飛び先のURLをセットします.
     * @param newMobileUrl Feature-phone向けのこのリクエストの飛び先のURL
     */
    public final void setMobileUrl(final String newMobileUrl) {
        this.mobileUrl = newMobileUrl;
    }

    /**
     * 画像のURLを返します.
     * @return 画像のURL
     */
    public final String getImage() {
        return image;
    }

    /**
     * 画像のURLをセットします.
     * @param newImage 画像のURL
     */
    public final void setImage(final String newImage) {
        this.image = newImage;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.AbstractParams#convertParameterMap()
     */
    @Override
    public final Map<String, String> convertParameterMap() {
        Map<String, String> result = new HashMap<String, String>();
        putParameter(result, "message", message);
        putParameter(result, "recipients",
                convertArrayToStringWithComma(recipients));
        putParameter(result, "url", url);
        putParameter(result, "mobileUrl", mobileUrl);
        putParameter(result, "image", image);
        return result;
    }

}
