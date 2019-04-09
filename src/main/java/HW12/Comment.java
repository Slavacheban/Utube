package HW12;


import com.google.api.client.util.DateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Comment {
    private String nameAuthor;
    private String textComment;
    private Long likes;
    private DateTime dateOfLastModification;
}
