import dto.Comment;
import web.service.CommentWebServiceClient;
import web.service.CommentWebServiceClientBuilder;

public class Main {

    public static void main(String[] args) {
        CommentWebServiceClient commentClient = CommentWebServiceClientBuilder.build("127.0.0.1");
        Comment comment = new Comment();
        comment.setName("External comment");
        comment.setComment("External comment body");
        comment.setEmail("test@com");

        commentClient.save(comment);
        System.out.println(commentClient.findAll());
    }
}
