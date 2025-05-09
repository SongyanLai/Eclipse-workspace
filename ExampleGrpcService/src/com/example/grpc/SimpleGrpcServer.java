package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class SimpleGrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Opening server port 8080");
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl())
                .build();
        server.start();
        System.out.println("Server Started");
        server.awaitTermination();
    }

    static class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
        @Override
        public void greet(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            System.out.println("Incoming request: " + request);
            HelloResponse response = HelloResponse.newBuilder()
                    .setGreeting("Hello " + request.getFirstname())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}