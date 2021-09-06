package com.khanhhoang.helllo.repository;

import com.khanhhoang.helllo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserEntityByStatusAndName(Integer status, String name);

    List<UserEntity> findByName(String name);
}
