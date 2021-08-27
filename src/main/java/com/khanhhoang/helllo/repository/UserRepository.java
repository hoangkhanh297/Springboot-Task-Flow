package com.khanhhoang.helllo.repository;

import com.khanhhoang.helllo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.status = ?1 and u.name = ?2")
    UserEntity findUserByStatusAndName(Integer status, String name);

    @Query("SELECT u FROM UserEntity u WHERE u.name = ?1")
    List<UserEntity> findByName(String name);
}
