package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractParams;

/**
 * mixiボイスのつぶやき一覧を取得する際に指定する条件を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class GetStatusParams extends AbstractParams {

    /** ユーザ情報として欲しい情報を選別するためのパラメータ. */
    private TrimUser trimUser = null;

    /** フォト情報を切り出して取得するかどうか. */
    private boolean attachPhoto = false;

    /**
     * ユーザ情報として欲しい情報を選別するためのパラメータをセットします.
     * @param trimUser ユーザ情報として欲しい情報を選別するためのパラメータ
     */
    public void setTrimUser(final TrimUser trimUser) {
        this.trimUser = trimUser;
    }

    /**
     * フォト情報を切り出して取得するかどうかをセットします.
     * @param attachPhoto フォト情報を切り出して取得するかどうか
     */
    public void setAttachPhoto(final boolean attachPhoto) {
        this.attachPhoto = attachPhoto;
    }

    /*
     * (non-Javadoc)
     * @see jp.mixi.android.sdk.wrapper.AbstractParams#convertParameterMap()
     */
    @Override
    public Map<String, String> convertParameterMap() {
        Map<String, String> params = new HashMap<String, String>();
        if (trimUser != null) {
            params.put("trim_user", trimUser.getReal());
        }
        if (attachPhoto) {
            params.put("attach_photo", "true");
        }
        return params;
    }

}
