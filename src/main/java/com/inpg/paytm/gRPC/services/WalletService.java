package com.inpg.paytm.gRPC.services;

import com.inpg.grpc.wallet.v1.*;
import com.inpg.paytm.gRPC.entities.User;
import com.inpg.paytm.gRPC.entities.WalletEntity;
import com.inpg.paytm.gRPC.repositories.UserRepository;
import com.inpg.paytm.gRPC.repositories.WalletRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class WalletService extends WalletserviceGrpc.WalletserviceImplBase {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;


    ////////////POST request for WALLET/////////////////////////

    @Override
    public void postWallet(WalletPostReq walletPostReq, StreamObserver<WalletPostRes> responseObserver) {

        WalletEntity wallet=new WalletEntity(walletPostReq.getPhoneId(),
                walletPostReq.getPhone(),walletPostReq.getWallBalance());

        List<WalletEntity> phone_num=walletRepository.findByPhone(walletPostReq.getPhone());
        List<User> user_phone_number=userRepository.findByMobileNumber(walletPostReq.getPhone());

        WalletPostRes walletPostRes;

        if(!user_phone_number.isEmpty()) {
            if(phone_num.isEmpty()) {
                walletRepository.save(wallet);
                String wallmessg= "wallet created"+"  with phonenum :: " + walletPostReq.getPhone();
                walletPostRes= WalletPostRes.newBuilder().setWallmessg(wallmessg).build();
            }else {
                String wallmessg= "wallet already exists "+"  with phonenum :: " + walletPostReq.getPhone();
                walletPostRes= WalletPostRes.newBuilder().setWallmessg(wallmessg).build();
            }
        }else {
            String wallmessg= "user doesn't exists "+"  with phonenum :: " + walletPostReq.getPhone();
            walletPostRes= WalletPostRes.newBuilder().setWallmessg(wallmessg).build();
        }
        responseObserver.onNext(walletPostRes);
        responseObserver.onCompleted();

    }

    ////////////GET wallbalance for phone number//////////////////////////////////////////////

    @Override
    public void getWallet(WalletGetReq walletGetReq, StreamObserver<WalletGetRes> responseObserver) {

        System.out.println("showing wallBalance for phone_num :: "+ walletGetReq.getPhone());
        List<WalletEntity> phone_num=walletRepository.findByPhone(walletGetReq.getPhone());

        int bal=phone_num.get(0).getWallBalance();

        WalletGetRes walletGetRes=WalletGetRes.newBuilder().setWallBalance(bal).build();

        responseObserver.onNext(walletGetRes);
        responseObserver.onCompleted();

    }
}
