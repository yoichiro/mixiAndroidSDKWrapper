package jp.eisbahn.android.sdk.wrapper.updates;

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
public class GetFeedParams extends AbstractParams {

    /** 取得したい件数. */
    private int count = -1;

    /** 取得したい項目. */
    private Field[] fields = null;

    /** 送信日時の境界. */
    private Date updatedSince = null;

    /** 取得したいデバイス. */
    private Device device = null;

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
     * 取得したいデバイスをセットします.
     * @param device デバイスの種類
     */
    public void setDevice(final Device device) {
        this.device = device;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.AbstractParams#convertParameterMap()
     */
    @Override
    public Map<String, String> convertParameterMap() {
        Map<String, String> params = new HashMap<String, String>();
        if (count >= 0) {
            params.put("count", String.valueOf(count));
        }
        if (fields != null) {
            params.put("fields", convertArrayToStringWithComma(fields));
        }
        if (updatedSince != null) {
            params.put("updatedSince", DateUtils.convertDate(updatedSince));
        }
        if (device != null) {
            params.put("device", device.toString());
        }
        return params;
    }

}
