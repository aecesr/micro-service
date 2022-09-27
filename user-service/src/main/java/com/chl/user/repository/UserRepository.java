package com.chl.user.repository;

import com.chl.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByMobileAndPassword(String phone, String password);

}
