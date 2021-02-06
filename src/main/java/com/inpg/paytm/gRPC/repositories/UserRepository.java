package com.inpg.paytm.gRPC.repositories;

import com.inpg.paytm.gRPC.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByMobileNumber(Integer mobileNumber);
}
