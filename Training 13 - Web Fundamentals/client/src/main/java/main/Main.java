package main;

import web.service.Comment;
import web.service.CommentWebServiceClient;
import web.service.CommentWebServiceClientBuilder;

/**
 * Created by iciuta on 7/27/2016.
 */
public class Main {
    public static void main(String[] args) {
        final String IP = "127.0.0.1";

        Comment comment1 = new Comment();
        comment1.setComment("I'm testing you");
        comment1.setEmail("ion@test");
        comment1.setName("This is my name");
        comment1.setId(1);

        Comment comment2 = new Comment();
        comment2.setComment("I'm testing you again");
        comment2.setEmail("ion@test");
        comment2.setName("This is my name again");
        comment2.setId(2);

        CommentWebServiceClient webClient = CommentWebServiceClientBuilder.build(IP);
        comment1 = webClient.save(comment1);
        comment2 = webClient.save(comment2);

        System.out.println(webClient.findAll());

        comment2.setName("Updated comment");
        comment2 = webClient.update(comment2);
        System.out.println(webClient.findById(comment2.getId()));

        webClient.delete(comment1.getId());
        webClient.delete(comment2.getId());
        System.out.println(webClient.findAll());
    }
}
