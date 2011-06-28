package jp.mixi.android.sdk.wrapper.photo;

import org.json.JSONObject;

/**
 * フォトアルバムの情報を持つクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class Album extends AbstractModel {

    /** Privacy object. */
    private Privacy privacy;

    /**
     * Initialize this instance.
     * @param newOriginal The JSON object which has information about Album.
     */
    protected Album(final JSONObject newOriginal) {
        super(newOriginal);
        privacy = new Privacy(getPropertyJSONObject("privacy"));
    }

    /**
     * Retrieve the description string.
     * @return The description.
     */
    public final String getDescription() {
        return getPropertyString("description");
    }

    /**
     * Retrieve the owner user's ID.
     * @return The owner user's ID string.
     */
    public final String getOwnerId() {
        return getPropertyString("ownerId");
    }

    /**
     * Retrieve the number of media items.
     * @return The count of media items which this has.
     */
    public final int getMediaItemCount() {
        return getPropertyInt("mediaItemCount");
    }

    /**
     * Retrieve the privacy.
     * @return The privacy object.
     */
    public final Privacy getPrivacy() {
        return privacy;
    }

}
