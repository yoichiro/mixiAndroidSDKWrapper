package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractParams;

/**
 * 周辺のスポット情報を取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class SearchSpotsParams extends AbstractParams {

    /** 取得件数. */
    private int count = -1;

    /** 取得したい項目. */
    private SpotField[] fields = null;

    /** 取得結果の基点となる Spot-ID. */
    private String sinceId = null;

    /** 検索対象となる範囲の中心地点. */
    private String center = null;

    /** キーワード検索の検索文字列. */
    private String keyword = null;

    /** sinceId を基点として、結果を取得する範囲. */
    private ResultsDirection resultsDirection = null;

    /**
     * 取得件数をセットします.
     * @param count 取得件数
     */
    public void setCount(final int count) {
        this.count = count;
    }

    /**
     * sinceId を基点として、結果を取得する範囲をセットします.
     * @param resultsDirection sinceId を基点として、結果を取得する範囲
     */
    public void setResultsDirection(final ResultsDirection resultsDirection) {
        this.resultsDirection = resultsDirection;
    }

    /**
     * キーワード検索の検索文字列をセットします.
     * @param keyword キーワード検索の検索文字列
     */
    public void setKeyword(final String keyword) {
        this.keyword = keyword;
    }

    /**
     * 取得結果の基点となる Spot-IDをセットします.
     * @param sinceId 取得結果の基点となる Spot-ID
     */
    public void setSinceId(final String sinceId) {
        this.sinceId = sinceId;
    }

    /**
     * 検索対象となる範囲の中心地点をセットします.
     * @param latitude 緯度
     * @param longitude 軽度
     */
    public void setCenter(final double latitude, final double longitude) {
        center = Double.toString(latitude) + "," + Double.toString(longitude);
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
        if (count >= 0) {
            params.put("count", String.valueOf(count));
        }
        if (sinceId != null) {
            params.put("sinceId", sinceId);
        }
        if (center != null) {
            params.put("center", center);
        }
        if (keyword != null) {
            params.put("q", keyword);
        }
        if (resultsDirection != null) {
            params.put("resultsDirection", resultsDirection.toString());
        }
        if (fields != null) {
            params.put("fields", convertArrayToStringWithComma(fields));
        }
        return params;
    }

}
