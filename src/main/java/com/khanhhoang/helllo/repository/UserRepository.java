package com.khanhhoang.helllo.repository;

import com.khanhhoang.helllo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserEntityByStatusAndName(Integer status, String name);

    List<UserEntity> findByName(String name);

    UserEntity findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query(value = "select  * from user where MATCH(name, username) AGAINST (?1)", nativeQuery = true)
    List<UserEntity> fullTextSearchUsernameAndName(String keyword);


}
