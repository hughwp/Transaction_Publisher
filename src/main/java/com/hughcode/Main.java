package com.hughcode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(
                    LocalDateTime.class,
                    (JsonSerializer<LocalDateTime>) (timestamp, type, context) ->
                            new JsonPrimitive(timestamp.toString()))
            .create();
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/stream", exchange -> {
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Content-Type", "text/event-stream");
            exchange.sendResponseHeaders(200, 0);

            OutputStream out = exchange.getResponseBody();
            try {
                while (true) {
                    Transaction transaction = RandomClassFactory.generateRandomTransaction();
                    String json = gson.toJson(transaction);
                    logger.info("Streaming transaction: " + json);
                    out.write(("data: " + json + "\n\n").getBytes(StandardCharsets.UTF_8));
                    out.flush();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                logger.log(Level.INFO, "Client disconnected", e);
            } finally {
                try {
                    out.close();
                    exchange.close();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error closing connection", e);
                }
            }
        });
        server.start();
        logger.info("Server started on port 8080");
    }
}