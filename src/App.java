package com.mtoliver.cicd;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class App {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8085), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8085");
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello from your CI/CD Java app!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}