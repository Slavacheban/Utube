package HW12;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentSnippet;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

public class UtubeParser {
    private static YouTube youtube;
    private List<UtubeVideo> listOfVideos = Lists.newArrayList();
    private static List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.force-ssl");

    public void init() {
        Credential credential = null;
        try {
            credential = Authorization.authorize(scopes, "comments");
        } catch (IOException e) {
            e.printStackTrace();
        }
        youtube = new YouTube.Builder(Authorization.HTTP_TRANSPORT, Authorization.JSON_FACTORY, credential)
                .setApplicationName("youtube-comments-parser").build();
    }

    public void getCommentsFromVideos(List<String> videoIds) {
        for (String videoId : videoIds) {
            List<CommentThread> videoComments = getCommentThreads(videoId);
            CommentSnippet snippet;
            UtubeVideo youtubeVideo = new UtubeVideo();

            for (CommentThread videoComment : videoComments) {
                Comment comment = new Comment();
                snippet = videoComment.getSnippet().getTopLevelComment().getSnippet();
                comment.setNameAuthor(snippet.getAuthorDisplayName());
                comment.setTextComment(snippet.getTextDisplay());
                comment.setLikes(snippet.getLikeCount());
                comment.setDateOfLastModification(snippet.getPublishedAt());
                youtubeVideo.getComments().add(comment);
            }
            listOfVideos.add(youtubeVideo);
        }
    }

    private static List<CommentThread> getCommentThreads(String videoId) {
        CommentThreadListResponse videoCommentsListResponse = null;
        try {
            videoCommentsListResponse = youtube.commentThreads().list("snippet")
                    .setVideoId(videoId).setTextFormat("plainText").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return videoCommentsListResponse.getItems();
    }

    public List<UtubeVideo> getListOfVideos() {
        return listOfVideos;
    }
}
