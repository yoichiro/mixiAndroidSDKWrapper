package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractParams;

/**
 * mixiボイスのつぶやき一覧を取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetFeedbacksParams extends AbstractParams {

    /** 開始インデックス. */
    private int startIndex = -1;

    /** 取得したい件数. */
    private int count = -1;

    /** ユーザ情報として欲しい情報を選別するためのパラメータ. */
    private TrimUser trimUser = null;

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
     * ユーザ情報として欲しい情報を選別するためのパラメータをセットします.
     * @param trimUser ユーザ情報として欲しい情報を選別するためのパラメータ
     */
    public void setTrimUser(final TrimUser trimUser) {
        this.trimUser = trimUser;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.AbstractParams#convertParameterMap()
     */
    @Override
    public Map<String, String> convertParameterMap() {
        Map<String, String> params = new HashMap<String, String>();
        if (startIndex >= 0) {
            params.put("start_index", String.valueOf(startIndex));
        }
        if (count >= 0) {
            params.put("count", String.valueOf(count));
        }
        if (trimUser != null) {
            params.put("trim_user", trimUser.getReal());
        }
        return params;
    }

}
