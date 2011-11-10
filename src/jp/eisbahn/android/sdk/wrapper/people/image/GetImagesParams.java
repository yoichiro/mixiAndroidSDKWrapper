package jp.eisbahn.android.sdk.wrapper.people.image;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.common.AbstractParams;

/**
 * プロフィール画像の情報を取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetImagesParams extends AbstractParams {

    /** 開始インデックス. */
    private int startIndex = -1;

    /** 取得件数. */
    private int count = -1;

    /** メイン画像として設定されている画像のみを取得するかどうか. */
    private boolean primary = false;

    /** 公開範囲. */
    private Privacy privacy = null;

    /** 取得したい項目. */
    private Field[] fields = null;

    /**
     * 開始インデックスをセットします.
     * @param startIndex 開始インデックス
     */
    public void setStartIndex(final int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 取得件数をセットします.
     * @param count 取得件数
     */
    public void setCount(final int count) {
        this.count = count;
    }

    /**
     * メイン画像として設定されている画像のみを取得するかどうかをセットします.
     * @param primary メイン画像として設定されている画像のみを取得するかどうか
     */
    public void setPrimary(final boolean primary) {
        this.primary = primary;
    }

    /**
     * 公開範囲をセットします.
     * @param privacy 公開範囲
     */
    public void setPrivacy(final Privacy privacy) {
        this.privacy = privacy;
    }

    /**
     * 取得したい項目をセットします.
     * @param fields 取得したい項目
     */
    public void setFields(final Field[] fields) {
        this.fields = fields;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.AbstractParams#convertParameterMap()
     */
    @Override
    public Map<String, String> convertParameterMap() {
        Map<String, String> params = new HashMap<String, String>();
        if (startIndex >= 0) {
            params.put("startIndex", String.valueOf(startIndex));
        }
        if (count >= 0) {
            params.put("count", String.valueOf(count));
        }
        if (primary) {
            params.put("primary", "true");
        }
        if (privacy != null) {
            params.put("privacy", privacy.toString());
        }
        if (fields != null) {
            params.put("fields", convertArrayToStringWithComma(fields));
        }
        return params;
    }

}
