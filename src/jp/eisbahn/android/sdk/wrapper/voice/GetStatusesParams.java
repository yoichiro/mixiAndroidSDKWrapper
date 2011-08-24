package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Map;

/**
 * mixiボイスのつぶやき一覧を取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetStatusesParams extends GetStatusParams {

    /** 開始インデックス. */
    private int startIndex = -1;

    /** 取得したい件数. */
    private int count = -1;

    /** 最新のつぶやき一覧を取得する際の起点となるつぶやきのID. */
    private String sinceId;

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
     * 最新のつぶやき一覧を取得する際の起点となるつぶやきのIDをセットします.
     * @param sinceId 最新のつぶやき一覧を取得する際の起点となるつぶやきのID
     */
    public void setSinceId(final String sinceId) {
        this.sinceId = sinceId;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.AbstractParams#convertParameterMap()
     */
    @Override
    public Map<String, String> convertParameterMap() {
        Map<String, String> params = super.convertParameterMap();
        if (startIndex >= 0) {
            params.put("start_index", String.valueOf(startIndex));
        }
        if (count >= 0) {
            params.put("count", String.valueOf(count));
        }
        if (sinceId != null) {
            params.put("since_id", sinceId);
        }
        return params;
    }

}
