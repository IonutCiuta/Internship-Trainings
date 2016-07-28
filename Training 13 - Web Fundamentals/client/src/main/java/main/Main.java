package main;

import dto.Comment;
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
        comment1.setId(1L);

        Comment comment2 = new Comment();
        comment2.setComment("I'm testing you again");
        comment2.setEmail("ion@test");
        comment2.setName("This is my name again");
        comment2.setId(2L);

        CommentWebServiceClient webClient = CommentWebServiceClientBuilder.build(IP);
        webClient.save(comment1);
        webClient.save(comment2);

        System.out.println(webClient.findAll());

        /*comment1.setComment("New name");
        webClient.update(comment1);

        System.out.println(webClient.findAll());

        webClient.delete(comment2);
        System.out.println(webClient.findAll());*/
    }
}
