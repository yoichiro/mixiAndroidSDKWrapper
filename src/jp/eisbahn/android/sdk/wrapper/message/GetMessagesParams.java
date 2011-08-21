package jp.eisbahn.android.sdk.wrapper.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractParams;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

/**
 * メッセージを取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetMessagesParams extends AbstractParams {

    /** 開始インデックス. */
    private int startIndex = -1;

    /** 取得したい件数. */
    private int count = -1;

    /** 取得したい項目. */
    private Field[] fields = null;

    /** 送信日時の境界. */
    private Date updatedSince = null;

    /** メッセージに関係するユーザの種別. */
    private String relatedUserType;

    /**
     * 開始インデックスをセットします.
     * @param startIndex 開始インデックス
     */
    public void setStartIndex(final int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 取得したい件数をセットします.
     * @param count 取得したい件数
     */
    public void setCount(final int count) {
        this.count = count;
    }

    /**
     * 取得したい項目をセットします.
     * @param fields 取得したい項目
     */
    public void setFields(final Field[] fields) {
        this.fields = fields;
    }

    /**
     * 送信日時の境界をセットします.
     * @param updatedSince 送信日時の境界
     */
    public void setUpdatedSince(final Date updatedSince) {
        this.updatedSince = updatedSince;
    }

    /**
     * メッセージに関係するユーザの種別をセットします.
     * @param relatedUserType メッセージに関係するユーザの種別
     */
    void setRelatedUserType(final String relatedUserType) {
        this.relatedUserType = relatedUserType;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.AbstractParams#convertParameterMap()
     */
    @Override
    public Map<String, String> convertParameterMap() {
        if (relatedUserType == null) {
            throw new IllegalStateException("relatedUserType not set.");
        }
        Map<String, String> params = new HashMap<String, String>();
        if (startIndex >= 0) {
            params.put("startIndex", String.valueOf(startIndex));
        }
        if (count >= 0) {
            params.put("count", String.valueOf(count));
        }
        if (fields != null) {
            String[] array = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if (field.isNeedPrefix()) {
                    array[i] = relatedUserType + "." + field.toString();
                } else {
                    array[i] = field.toString();
                }
            }
            params.put("fields", convertArrayToStringWithComma(array));
        }
        if (updatedSince != null) {
            params.put("updatedSince", DateUtils.convertDate(updatedSince));
        }
        return params;
    }

}
