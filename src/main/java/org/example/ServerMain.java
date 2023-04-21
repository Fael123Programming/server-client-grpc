package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.services.CalculatorServiceImpl;
import java.io.IOException;

public class ServerMain {
    private static final Logger logger = LoggerFactory.getLogger(ServerMain.class);

    public static void main(String[] args) {
        Server server = ServerBuilder
                .forPort(Constants.PORT)
                .addService(new CalculatorServiceImpl())
                .build();
        try {
            server.start();
            logger.info("Server started at port {}", server.getPort());
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
