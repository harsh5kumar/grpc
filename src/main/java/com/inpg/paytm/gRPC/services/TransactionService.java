package com.inpg.paytm.gRPC.services;

import com.inpg.grpc.wallet.v1.WalletPostRes;
import com.inpg.grpc.wallet.v2.*;
import com.inpg.paytm.gRPC.entities.TransactionEntity;
import com.inpg.paytm.gRPC.entities.WalletEntity;
import com.inpg.paytm.gRPC.repositories.TransactionRepository;
import com.inpg.paytm.gRPC.repositories.WalletRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class TransactionService extends TransactionServiceGrpc.TransactionServiceImplBase {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void posttxn(TxnPostReq txnPostReq, StreamObserver<TxnPostRes> responseObserver) {

        TransactionEntity transaction=new TransactionEntity(txnPostReq.getTxnid()
                ,txnPostReq.getPayerphonenumber(), txnPostReq.getPayeephonenumber()
                , txnPostReq.getTxnamount() );

        List<WalletEntity> payer_num=walletRepository.findByPhone(txnPostReq.getPayerphonenumber());
        List<WalletEntity> payee_num=walletRepository.findByPhone(txnPostReq.getPayeephonenumber());

        TxnPostRes txnPostRes;

        int payer_balance=payer_num.get(0).getWallBalance();
        int txnAmount=transaction.getTxnamount();

        if(!payer_num.isEmpty())
        {
            if(!payee_num.isEmpty())
            {
                if(payer_balance>=txnAmount)
                {
                    transactionRepository.save(transaction);

                    WalletEntity payer=payer_num.get(0);
                    WalletEntity payee=payee_num.get(0);

                    payer.updateBalance(-txnAmount);
                    payee.updateBalance(txnAmount);

                    walletRepository.save(payer);
                    walletRepository.save(payee);

                    String txnmessg= "Transaction done"+"  with txnid :: " + txnPostReq.getTxnid();
                    txnPostRes= TxnPostRes.newBuilder().setTxnmessg(txnmessg).build();
                }
                else txnPostRes= TxnPostRes.newBuilder().setTxnmessg("Insufficient funds").build();
            } else txnPostRes= TxnPostRes.newBuilder().setTxnmessg("payee doesn't exists").build();
        } else txnPostRes= TxnPostRes.newBuilder().setTxnmessg("payer doesn't exists").build();


        responseObserver.onNext(txnPostRes);
        responseObserver.onCompleted();
    }

    @Override
    public void gettxn(TxnGetReq txnGetReq, StreamObserver<TxnGetRes> responseObserver) {

    }
}
