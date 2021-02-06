package com.inpg.paytm.gRPC;

import com.inpg.paytm.gRPC.services.WalletService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GRpcApplication {

	public static void main(String[] args) {

		SpringApplication.run(GRpcApplication.class, args);

		/*Server server = ServerBuilder
				.forPort(8080)
				.addService(new WalletService()).build();
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			server.awaitTermination();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

}
