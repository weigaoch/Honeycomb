package com.polycom.mediasuite.api;

import com.polycom.MediaSuite;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wgao on 6/16/2016.
 */
public abstract class RestApiClient<T> {
    private static Logger logger = LoggerFactory.getLogger(RestApiClient.class);

    public final MediaSuite mediaSuite;
    public T loginResult;

    public RestApiClient(MediaSuite mediaSuite) {
        this.mediaSuite = mediaSuite;
    }

    public HttpResponse send(HttpRequest request) {
        if (!isLoggedIn()) {
            login();
        }

        addToken2Header(request);

        HttpResponse response = request.send();
        int statusCode = response.statusCode();
        if (statusCode == 401) {
            logger.info("send():token is out of date, will relogin and send request again:response\n" +response.toString());
            login();
            addToken2Header(request);

            logger.info("send():request\n" + request.toString());
            response = request.send();
        }
        return response;
    }


    protected abstract void login();

    protected abstract HttpRequest addToken2Header(HttpRequest request);

    private boolean isLoggedIn() {
        return loginResult != null;
    }
}
