package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractParams;

/**
 * 周辺のスポット情報を取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetSpotsParams extends AbstractParams {

    /** 取得開始インデックス. */
    private int startIndex = -1;

    /** 取得件数. */
    private int count = -1;

    /** 取得したい項目. */
    private SpotField[] fields = null;

    /**
     * 取得開始インデックスをセットします.
     * @param startIndex 取得開始インデックス
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
     * 取得したい項目をセットします.
     * @param fields 取得したい項目
     */
    public void setFields(final SpotField[] fields) {
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
        if (fields != null) {
            params.put("fields", convertArrayToStringWithComma(fields));
        }
        return params;
    }

}
