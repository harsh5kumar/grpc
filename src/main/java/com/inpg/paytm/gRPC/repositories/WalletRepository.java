package com.inpg.paytm.gRPC.repositories;

import com.inpg.paytm.gRPC.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<WalletEntity,Integer> {

    public List<WalletEntity> findByPhone(int phone);
}
