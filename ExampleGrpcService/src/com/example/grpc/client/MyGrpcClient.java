package com.example.grpc.client;
import com.example.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
    public static void main(String[] args) {
        System.out.println("Creating Channel to Server");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = 
            GreetingServiceGrpc.newBlockingStub(channel);
        HelloResponse response = stub.greet(HelloRequest.newBuilder()
                .setFirstname("Dermot")
                .addHobbies("Photography")
                .build());
        System.out.println("Response: " + response.getGreeting());
        channel.shutdown();
    }
}