package com.inpg.paytm.gRPC.server;

import com.inpg.paytm.gRPC.services.WalletService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Grpcserver {

    public static void main(String args[]){
        /*Server server= ServerBuilder.forPort(9091).addService(new WalletService()).build();

        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Server started on " + server.getPort());

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
