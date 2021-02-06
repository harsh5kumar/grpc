package com.inpg.paytm.gRPC.entities;

import javax.persistence.*;

@Entity
@Table(name="wallet")
public class WalletEntity {

    private int phoneId;
    private int phone;
    private int wallBalance;

    public WalletEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public WalletEntity(int phoneId, int phone, int wallBalance) {
        super();
        this.phoneId = phoneId;
        this.phone = phone;
        this.wallBalance = wallBalance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getWallBalance() {
        return wallBalance;
    }

    public void setWallBalance(int wallBalance) {
        this.wallBalance = wallBalance;
    }

    public void updateBalance(Integer update){
        this.wallBalance += update;
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
                "phoneId=" + phoneId +
                ", phone=" + phone +
                ", wallBalance=" + wallBalance +
                '}';
    }
}


