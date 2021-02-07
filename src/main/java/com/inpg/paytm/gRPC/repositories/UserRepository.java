package com.inpg.paytm.gRPC.repositories;

import com.inpg.paytm.gRPC.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    public List<UserEntity> findByEmailid(String emailid);

    public List<UserEntity> findByUserName(String userName);

    public List<UserEntity> findByMobileNumber(Integer mobileNumber);

    public List<UserEntity> findByuserid(int userid);


}
