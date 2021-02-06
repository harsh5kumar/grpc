package com.inpg.paytm.gRPC.repositories;

import com.inpg.paytm.gRPC.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {
}
