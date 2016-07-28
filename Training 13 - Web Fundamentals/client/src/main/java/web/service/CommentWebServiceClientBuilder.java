package web.service;

import com.google.gson.Gson;
import dto.Comment;
import dto.CommentContainer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by iciuta on 7/27/2016.
 */
public class CommentWebServiceClientBuilder {
    private CommentWebServiceClientBuilder() {}

    public static CommentWebServiceClient build(final String ip) {
        return new CommentWebServiceClient() {
            /*strings used to display messages*/
            private final String MESSAGE_SAVE   = "POST";
            private final String MESSAGE_UPDATE = "PUT";
            private final String MESSAGE_FIND   = "GET";
            private final String MESSAGE_DELETE = "DELETE";

            /*strings used to build urls*/
            private final String URL_SCHEME         = "http";
            private final String URL_PATH_SEGMENT   = "restful";
            private final String URL_PATH_ENDPOINT  = "comment";
            private final int URL_PORT              = 8080;

            private final HttpClient client = HttpClientBuilder.create().build();

            public void save(Comment comment) {
                try {
                    String url = getGenericCommentUrl(ip);
                    StringEntity stringEntity = prepareObject(comment);
                    HttpPost post = new HttpPost(url);
                    post.setEntity(stringEntity);
                    post.setHeader("Content-type", "application/json");

                    HttpResponse response = client.execute(post);
                    printCode(response, MESSAGE_SAVE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void update(Comment comment) {
                try {
                    String url = getSpecificCommentUrl(ip, comment.getId() + "");
                    StringEntity stringEntity = prepareObject(comment);
                    HttpPut put = new HttpPut(url);
                    put.setEntity(stringEntity);
                    put.setHeader("Content-type", "application/json");

                    HttpResponse response = client.execute(put);
                    printCode(response, MESSAGE_UPDATE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public Comment findById(Long commentId) {
                Comment result = null;
                try {
                    String url = getSpecificCommentUrl(ip, commentId.toString());
                    HttpGet request = new HttpGet(url);

                    HttpResponse response = client.execute(request);
                    printCode(response, MESSAGE_FIND);
                    result = (Comment) responseToObject(response, Comment.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            public List<Comment> findAll() {
                List<Comment> result = null;
                try {
                    String url = getGenericCommentUrl(ip);
                    HttpGet request = new HttpGet(url);
                    request.setHeader("Content-type", "application/json");

                    HttpResponse response = client.execute(request);
                    printCode(response, MESSAGE_FIND);
                    CommentContainer container = (CommentContainer) responseToObject(response, CommentContainer.class);
                    result = container.getEmbeddedData().getComment();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            public void delete(Comment commentId) {
                try {
                    String url = getSpecificCommentUrl(ip, commentId.getId() + "");
                    HttpDelete request = new HttpDelete(url);

                    HttpResponse response = client.execute(request);
                    printCode(response, MESSAGE_DELETE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private Gson initGson() {
                return new Gson();
            }

            private String getUrl(String host) {
                URIBuilder uriBuilder = new URIBuilder();
                String query = uriBuilder.setScheme(URL_SCHEME)
                                         .setHost(host)
                                         .setPort(URL_PORT).toString();
                query += "/" + URL_PATH_SEGMENT;
                return query;
            }

            private String getGenericCommentUrl(String host) {
                return getUrl(host) + "/" + URL_PATH_ENDPOINT;
            }

            private String getSpecificCommentUrl(String host, String param) {
                return getGenericCommentUrl(host) + "/" + param;
            }

            private StringEntity prepareObject(Comment comment) throws IOException{
                return new StringEntity(initGson().toJson(comment));
            }

            private Object responseToObject(HttpResponse response, Class clazz) throws IOException{
                String content  = EntityUtils.toString(response.getEntity());
                Gson gson = initGson();
                Object result =  gson.fromJson(content, clazz);
                return result;
            }

            private void printCode(HttpResponse response, String message) {
                System.out.println(message + " RESPONSE CODE: " + response.getStatusLine().getStatusCode());
            }
        };
    }
}

