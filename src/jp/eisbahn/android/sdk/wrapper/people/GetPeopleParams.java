package jp.eisbahn.android.sdk.wrapper.people;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.common.AbstractParams;
import jp.eisbahn.android.sdk.wrapper.common.Field;

/**
 * 友人のプロフィール情報を取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetPeopleParams extends AbstractParams {

    /** 開始インデックス. */
    private int startIndex = -1;

    /** 取得件数. */
    private int count = -1;

    /** 並び替え条件. */
    private SortBy sortBy = null;

    /** 並び替えの方向. */
    private SortOrder sortOrder = null;

    /** 取得したい項目. */
    private Field[] fields = null;

    /** プロフィール画像の取得条件. */
    private ThumbnailPrivacy thumbnailPrivacy = null;

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
     * 並び替え条件をセットします.
     * @param sortBy 並び替え条件
     */
    public void setSortBy(final SortBy sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * 並び替えの方向をセットします.
     * @param sortOrder 並び替えの方向
     */
    public void setSortOrder(final SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * プロフィール画像の取得条件をセットします.
     * @param thumbnailPrivacy プロフィール画像の取得条件
     */
    public void setThumbnailPrivacy(final ThumbnailPrivacy thumbnailPrivacy) {
        this.thumbnailPrivacy = thumbnailPrivacy;
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
        if (sortBy != null) {
            params.put("sortBy", sortBy.toString());
        }
        if (sortOrder != null) {
            params.put("sortOrder", sortOrder.toString());
        }
        if (thumbnailPrivacy != null) {
            params.put("thumbnailPrivacy", thumbnailPrivacy.toString());
        }
        if (fields != null) {
            params.put("fields", convertArrayToStringWithComma(fields));
        }
        return params;
    }

}
