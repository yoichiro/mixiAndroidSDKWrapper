package jp.eisbahn.android.sdk.wrapper.check;

import jp.eisbahn.android.sdk.wrapper.common.Visibility;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * mixiチェックの投稿を行う際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class PostCheckParams {

    /** 公開範囲. */
    private Visibility visibility;

    /** グループID. */
    private String group;

    /** チェックする対象の説明文. */
    private String description;

    /** ユーザの入力したコメント. */
    private String comment;

    /** 18 歳未満非対応の場合は “1″. */
    private String contentRating;

    /** サムネイル画像の URL. */
    private String image;

    /** PC 向けページの URL. */
    private String pcUrl;

    /** スマートフォン向けページの URL. */
    private String smartPhoneUrl;

    /** 携帯電話（すべてのキャリア）向けページの URL. */
    private String mobileUrl;

    /** 携帯電話（DoCoMo）向けページの URL. */
    private String mobileDocomoUrl;

    /** 携帯電話（au）向けページの URL. */
    private String mobileAuUrl;

    /** 携帯電話（softbank）向けページの URL. */
    private String mobileSoftbankUrl;

    /**
     * 公開範囲を返します.
     * @return 公開範囲
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * 公開範囲をセットします.
     * @param visibility 公開範囲
     */
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    /**
     * グループIDを返します.
     * @return グループID
     */
    public String getGroup() {
        return group;
    }

    /**
     * グループIDをセットします.
     * @param group グループID
     */
    public void setGroup(final String group) {
        this.group = group;
    }

    /**
     * チェックする対象の説明文を返します.
     * @return チェックする対象の説明文
     */
    public String getDescription() {
        return description;
    }

    /**
     * チェックする対象の説明文をセットします.
     * @param description チェックする対象の説明文
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * ユーザの入力したコメントを返します.
     * @return ユーザの入力したコメント
     */
    public String getComment() {
        return comment;
    }

    /**
     * ユーザの入力したコメントをセットします.
     * @param comment ユーザの入力したコメント
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * 18 歳未満非対応の場合は “1″を返します.
     * @return 18 歳未満非対応の場合は “1″
     */
    public String getContentRating() {
        return contentRating;
    }

    /**
     * 18 歳未満非対応の場合は “1″をセットします.
     * @param contentRating 18 歳未満非対応の場合は “1″
     */
    public void setContentRating(final String contentRating) {
        this.contentRating = contentRating;
    }

    /**
     * サムネイル画像の URLを返します.
     * @return サムネイル画像の URL
     */
    public String getImage() {
        return image;
    }

    /**
     * サムネイル画像の URLをセットします.
     * @param image サムネイル画像の URL
     */
    public void setImage(final String image) {
        this.image = image;
    }

    /**
     * PC 向けページの URLを返します.
     * @return PC 向けページの URL
     */
    public String getPcUrl() {
        return pcUrl;
    }

    /**
     * PC 向けページの URLをセットします.
     * @param pcUrl PC 向けページの URL
     */
    public void setPcUrl(final String pcUrl) {
        this.pcUrl = pcUrl;
    }

    /**
     * スマートフォン向けページの URLを返します.
     * @return スマートフォン向けページの URL
     */
    public String getSmartPhoneUrl() {
        return smartPhoneUrl;
    }

    /**
     * スマートフォン向けページの URLをセットします.
     * @param smartPhoneUrl スマートフォン向けページの URL
     */
    public void setSmartPhoneUrl(final String smartPhoneUrl) {
        this.smartPhoneUrl = smartPhoneUrl;
    }

    /**
     * 携帯電話（すべてのキャリア）向けページの URLを返します.
     * @return 携帯電話（すべてのキャリア）向けページの URL
     */
    public String getMobileUrl() {
        return mobileUrl;
    }

    /**
     * 携帯電話（すべてのキャリア）向けページの URLをセットします.
     * @param mobileUrl 携帯電話（すべてのキャリア）向けページの URL
     */
    public void setMobileUrl(final String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    /**
     * 携帯電話（DoCoMo）向けページの URLを返します.
     * @return 携帯電話（DoCoMo）向けページの URL
     */
    public String getMobileDocomoUrl() {
        return mobileDocomoUrl;
    }

    /**
     * 携帯電話（DoCoMo）向けページの URLをセットします.
     * @param mobileDocomoUrl 携帯電話（DoCoMo）向けページの URL
     */
    public void setMobileDocomoUrl(final String mobileDocomoUrl) {
        this.mobileDocomoUrl = mobileDocomoUrl;
    }

    /**
     * 携帯電話（au）向けページの URLを返します.
     * @return 携帯電話（au）向けページの URL
     */
    public String getMobileAuUrl() {
        return mobileAuUrl;
    }

    /**
     * 携帯電話（au）向けページの URLをセットします.
     * @param mobileAuUrl 携帯電話（au）向けページの URL
     */
    public void setMobileAuUrl(final String mobileAuUrl) {
        this.mobileAuUrl = mobileAuUrl;
    }

    /**
     * 携帯電話（Softbank）向けページの URLを返します.
     * @return 携帯電話（Softbank）向けページの URL
     */
    public String getMobileSoftbankUrl() {
        return mobileSoftbankUrl;
    }

    /**
     * 携帯電話（Softbank）向けページの URLをセットします.
     * @param mobileSoftbankUrl 携帯電話（Softbank）向けページの URL
     */
    public void setMobileSoftbankUrl(final String mobileSoftbankUrl) {
        this.mobileSoftbankUrl = mobileSoftbankUrl;
    }

    /**
     * セットされた情報を、指定されたJSONオブジェクトに追加します.
     * @param json 追加対象のJSONオブジェクト
     * @return 追加された結果のJSONオブジェクト
     */
    public JSONObject appendParams(final JSONObject json) {
        try {
            if (visibility != null) {
                if (visibility.equals(Visibility.group)) {
                    JSONObject privacy = new JSONObject("{\"visibility\":\""
                            + visibility.toString() + "\",\"group\":\""
                            + group + "\"}");
                    json.put("privacy", privacy);
                } else {
                    JSONObject privacy = new JSONObject("{\"visibility\":\""
                            + visibility.toString() + "\"}");
                    json.put("privacy", privacy);
                }
            }
            if (description != null) {
                json.put("description", description);
            }
            if (comment != null) {
                json.put("comment", comment);
            }
            if (contentRating != null) {
                json.put("content_rating", contentRating);
            }
            if (image != null) {
                json.put("image", image);
            }
            if (pcUrl != null) {
                json.put("pc_url", pcUrl);
            }
            if (smartPhoneUrl != null) {
                json.put("smartphone_url", smartPhoneUrl);
            }
            if (mobileUrl != null) {
                json.put("mobile_url", mobileUrl);
            }
            if (mobileDocomoUrl != null) {
                json.put("mobile_docomo_url", mobileDocomoUrl);
            }
            if (mobileAuUrl != null) {
                json.put("mobile_au_url", mobileAuUrl);
            }
            if (mobileSoftbankUrl != null) {
                json.put("mobile_softbank_url", mobileSoftbankUrl);
            }
            return json;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

}
