package jp.eisbahn.android.sdk.wrapper.voice;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.VoiceAPI;
import jp.eisbahn.android.sdk.wrapper.common.AbstractProxyImpl;
import jp.eisbahn.android.sdk.wrapper.common.CallbackAdapter;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;

/**
 * Voice APIを扱うコンテナクラスです.
 * @author Yoichiro Tanaka
 *
 */
public class VoiceProxyImpl extends AbstractProxyImpl implements VoiceAPI {

    /**
     * 指定されたパラメータでこのインスタンスを初期化します.
     * @param newContainer MixiContainerオブジェクト
     */
    public VoiceProxyImpl(final MixiContainer newContainer) {
        super(newContainer);
    }

    @Override
    public void getMyStatuses(final GetStatusesCallbackHandler handler) {
        getFriendStatuses("@me", handler);
    }

    @Override
    public void getMyStatuses(final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getFriendStatuses("@me", params, handler);
    }

    @Override
    public void getFriendStatuses(final String userId,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + userId + "/user_timeline",
                handler);
    }

    @Override
    public void getFriendStatuses(final String userId,
            final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + userId + "/user_timeline",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getFriendsStatuses(final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline", handler);
    }

    @Override
    public void getFriendsStatuses(final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline",
                params.convertParameterMap(), handler);
    }

    @Override
    public void getGroupStatuses(final String groupId,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline/" + groupId,
                handler);
    }

    @Override
    public void getGroupStatuses(final String groupId,
            final GetStatusesParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/friends_timeline/" + groupId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getStatus(final String postId,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + postId, handler);
    }

    @Override
    public void getStatus(final String postId, final GetStatusParams params,
            final GetStatusesCallbackHandler handler) {
        getContainer().send("/voice/statuses/" + postId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getStatusComments(final String postId,
            final GetCommentsCallbackHandler handler) {
        getContainer().send("/voice/replies/" + postId, handler);
    }

    @Override
    public void getStatusComments(final String postId,
            final GetFeedbacksParams params,
            final GetCommentsCallbackHandler handler) {
        getContainer().send("/voice/replies/" + postId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void getStatusFavorites(final String postId,
            final GetUsersCallbackHandler handler) {
        getContainer().send("/voice/favorites/" + postId, handler);
    }

    @Override
    public void getStatusFavorites(final String postId,
            final GetFeedbacksParams params,
            final GetUsersCallbackHandler handler) {
        getContainer().send("/voice/favorites/" + postId,
                params.convertParameterMap(), handler);
    }

    @Override
    public void postStatus(final String status,
            final GetStatusesCallbackHandler handler) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("status", URLEncoder.encode(status, "UTF-8"));
            getContainer().send("/voice/statuses", HttpMethod.POST, params,
                    handler);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void postStatus(final String status, final InputStream image,
            final GetStatusesCallbackHandler handler) {
        try {
            getContainer().send(
                    "/voice/statuses?status="
                            + URLEncoder.encode(status, "UTF-8"),
                    "image/jpeg",
                    image,
                    image.available(),
                    handler);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteStatus(final String postId,
            final CallbackAdapter handler) {
        getContainer().send("/voice/statuses/" + postId, HttpMethod.DELETE,
                handler);
    }

    @Override
    public void postStatusComment(final String postId, final String text,
            final CallbackAdapter handler) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("text", URLEncoder.encode(text, "UTF-8"));
            getContainer().send("/voice/replies/" + postId, HttpMethod.POST,
                    params, handler);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteStatusComment(final String postId, final String commentId,
            final CallbackAdapter handler) {
        getContainer().send("/voice/replies/" + postId + "/" + commentId,
                HttpMethod.DELETE, handler);
    }

    @Override
    public void postStatusFavorite(final String postId,
            final CallbackAdapter handler) {
        getContainer().send("/voice/favorites/" + postId, HttpMethod.POST,
                handler);
    }

    @Override
    public void deleteStatusFavorite(final String postId, final String userId,
            final CallbackAdapter handler) {
        getContainer().send("/voice/favorites/" + postId + "/" + userId,
                HttpMethod.DELETE, handler);
    }

}
