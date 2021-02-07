package com.inpg.paytm.gRPC.services;

import com.inpg.grpc.wallet.v1.WalletPostRes;
import com.inpg.grpc.wallet.v2.TxnGetRes;
import com.inpg.grpc.wallet.v3.*;
import com.inpg.paytm.gRPC.entities.UserEntity;
import com.inpg.paytm.gRPC.repositories.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void postuser(UserPostReq userPostReq, StreamObserver<UserPostRes> responseObserver) {

        UserEntity userEntity= new UserEntity(userPostReq.getUserid(),userPostReq.getUserName(),
                userPostReq.getFirstName(),userPostReq.getLastName(),userPostReq.getMobileNumber(),
                userPostReq.getEmailid(),userPostReq.getAddress1(),userPostReq.getAddress2());

        List<UserEntity> email_id=userRepository.findByEmailid(userPostReq.getEmailid());
        List<UserEntity> user_name=userRepository.findByUserName(userPostReq.getUserName());
        List<UserEntity> phone_number=userRepository.findByMobileNumber(userPostReq.getMobileNumber());

        UserPostRes userPostRes;

        if(!email_id.isEmpty()) {
            userPostRes= UserPostRes.newBuilder().setUsermessg("user exists with similar emailid").build();
        }


        else if(!user_name.isEmpty()){
            userPostRes= UserPostRes.newBuilder().setUsermessg("user exists with similar userName").build();
        }

        else if(!phone_number.isEmpty())
        {
            userPostRes= UserPostRes.newBuilder().setUsermessg("user exists with similar phoneNumber").build();
        }
        else {
            userRepository.save(userEntity);
            String usermessg= "wallet created"+"  with phonenum :: " + userPostReq.getMobileNumber();
            userPostRes= UserPostRes.newBuilder().setUsermessg(usermessg).build();
        }
        responseObserver.onNext(userPostRes);
        responseObserver.onCompleted();


    }

    @Override
    public void getuser(UserGetReq userGetReq, StreamObserver<UserGetRes> responseObserver) {

        List<UserEntity> user=userRepository.findByuserid(userGetReq.getUserid());

        int u_id=user.get(0).getUserid();
        String user_name=user.get(0).getUserName();
        String first_name=user.get(0).getFirstName();
        String last_name=user.get(0).getLastName();
        String email_id=user.get(0).getEmailid();
        int mob_num=user.get(0).getMobileNumber();
        String add1=user.get(0).getAddress1();
        String add2=user.get(0).getAddress2();

        UserGetRes.Builder userGetRes= UserGetRes.newBuilder();

        userGetRes.setUserName(user_name);
        userGetRes.setUserid(u_id);
        userGetRes.setFirstName(first_name);
        userGetRes.setLastName(last_name);
        userGetRes.setMobileNumber(mob_num);
        userGetRes.setEmailid(email_id);
        userGetRes.setAddress1(add1);
        userGetRes.setAddress2(add2);
       // UserGetRes userGetRes= UserGetRes.newBuilder().setMobileNumber(mob_num).build();

        responseObserver.onNext(userGetRes.build());
        responseObserver.onCompleted();

    }
}
