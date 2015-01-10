package net.exoego.junit.ext.checker;

import java.net.URL;
import java.net.URLConnection;

public final class URLChecker implements Checker {
    private final String urlString;
    private final int timeoutMilliseconds;

    public URLChecker(String url) {
        this(url, 10 * 1000);
    }

    public URLChecker(String url, int timeoutMilliseconds) {
        this.urlString = url;
        this.timeoutMilliseconds = timeoutMilliseconds;
    }

    public boolean satisfy() {
        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setConnectTimeout(timeoutMilliseconds);
            urlConnection.connect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}