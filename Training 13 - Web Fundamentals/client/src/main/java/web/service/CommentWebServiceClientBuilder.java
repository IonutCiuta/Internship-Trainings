package web.service;

import com.google.gson.Gson;
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
import java.util.Arrays;
import java.util.List;

/**
 * Created by iciuta on 7/27/2016.
 */
public class CommentWebServiceClientBuilder {
    private CommentWebServiceClientBuilder() {}

    public static CommentWebServiceClient build(final String ip) {
        return new CommentWebServiceClient() {
            private final String URL_SCHEME = "http";
            private final String URL_PATH_SEGMENT = "restful";
            private final String URL_PATH_SINGLE_ENDPOINT = "comment";
            private final String URL_PATH_MULTIPLE_ENDPOINT = "comments";
            private final int URL_PORT = 8080;

            private final HttpClient client = HttpClientBuilder.create().build();

            public Comment save(Comment comment) {
                Comment result = null;
                try {
                    String url = getGenericCommentUrl(ip);
                    StringEntity stringEntity = prepareObject(comment);
                    HttpPost post = new HttpPost(url);
                    post.setEntity(stringEntity);
                    post.setHeader("Content-type", "application/json");

                    HttpResponse response = client.execute(post);
                    printCode(response);
                    result = extractResponseAsSingleEntity(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
            }

            public Comment update(Comment comment) {
                Comment result = null;
                try {
                    String url = getGenericCommentUrl(ip);
                    StringEntity stringEntity = prepareObject(comment);
                    HttpPut put = new HttpPut(url);
                    put.setEntity(stringEntity);
                    put.setHeader("Content-type", "application/json");

                    HttpResponse response = client.execute(put);
                    printCode(response);
                    result = extractResponseAsSingleEntity(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
            }

            public Comment findById(Long commentId) {
                Comment result = null;
                try {
                    String url = getSpecificCommentUrl(ip, commentId.toString());
                    HttpGet request = new HttpGet(url);

                    HttpResponse response = client.execute(request);
                    printCode(response);
                    result = extractResponseAsSingleEntity(response);
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
                    request.setHeader("Content-type", "application/x-spring-data+json");

                    HttpResponse response = client.execute(request);
                    printCode(response);
                    result = extractResponseAsList(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
            }

            public void delete(Long commentId) {
                try {
                    String url = getGenericCommentUrl(ip);
                    HttpDelete request = new HttpDelete(url);

                    HttpResponse response = client.execute(request);
                    printCode(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private Gson initGson() {
                Gson gson = new Gson();
                return gson;
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
                return getUrl(host) + "/" + URL_PATH_SINGLE_ENDPOINT;
            }

            private String getSpecificCommentUrl(String host, String param) {
                return getGenericCommentUrl(host) + "/" + param;
            }

            private String getAllCommentsUrl(String host) {
                return getUrl(host) + "/" + URL_PATH_MULTIPLE_ENDPOINT;
            }

            private StringEntity prepareObject(Comment comment) throws IOException{
                return new StringEntity(initGson().toJson(comment));
            }

            private Comment extractResponseAsSingleEntity(HttpResponse response) throws IOException{
                String content  = EntityUtils.toString(response.getEntity());
                Gson gson = initGson();
                return gson.fromJson(content, Comment.class);
            }

            private List<Comment> extractResponseAsList(HttpResponse response) throws IOException {
                String content  = EntityUtils.toString(response.getEntity());
                Gson gson = initGson();
                Comment[] comments = gson.fromJson(content, Comment[].class);
                return Arrays.asList(comments);
            }

            private void printCode(HttpResponse response) {
                System.out.println("RESPONSE CODE: " + response.getStatusLine().getStatusCode());
            }
        };
    }
}

