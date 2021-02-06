package com.inpg.paytm.gRPC.entities;

import javax.persistence.*;

@Entity
@Table(name="txndata")
//@Document(indexName = "transactions", indexStoreType = "transaction",shards = 2)
public class TransactionEntity {

    private int txnid;
    private int payerphonenumber;
    private int payeephonenumber;
    private int txnamount;

    public TransactionEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TransactionEntity(int txnid, int payerphonenumber, int payeephonenumber, int txnamount) {
        super();
        this.txnid = txnid;
        this.payerphonenumber = payerphonenumber;
        this.payeephonenumber = payeephonenumber;
        this.txnamount = txnamount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTxnid() {
        return txnid;
    }

    public void setTxnid(int txnid) {
        this.txnid = txnid;
    }

    public int getPayerphonenumber() {
        return payerphonenumber;
    }

    public void setPayerphonenumber(int payerphonenumber) {
        this.payerphonenumber = payerphonenumber;
    }

    public int getPayeephonenumber() {
        return payeephonenumber;
    }

    public void setPayeephonenumber(int payeephonenumber) {
        this.payeephonenumber = payeephonenumber;
    }

    public int getTxnamount() {
        return txnamount;
    }

    public void setTxnamount(int txnamount) {
        this.txnamount = txnamount;
    }

}

