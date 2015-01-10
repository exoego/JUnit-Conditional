package net.exoego.junit.ext.checker;

import java.net.InetSocketAddress;
import java.net.Socket;

public final class SocketChecker implements Checker {
    private final String host;
    private final int port;
    private final int timeoutMilliseconds;

    public SocketChecker(String host, int port) {
        this(host, port, 10 * 1000);
    }

    public SocketChecker(String host, int port, int timeoutMilliseconds) {
        this.host = host;
        this.port = port;
        this.timeoutMilliseconds = timeoutMilliseconds;
    }

    public boolean satisfy() {
        try (final Socket socket = new Socket()) {
            socket.bind(null);
            final InetSocketAddress address = new InetSocketAddress(this.host, this.port);
            socket.connect(address, this.timeoutMilliseconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}