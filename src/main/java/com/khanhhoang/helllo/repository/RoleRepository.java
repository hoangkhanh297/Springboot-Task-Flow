package com.khanhhoang.helllo.repository;

import com.khanhhoang.helllo.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query(value = "select * from role join user_role on role.role_id = user_role.role_id where user_role.user_id = ?1",
            nativeQuery = true)
    List<RoleEntity> findByUserId(Long userId);

    RoleEntity findByName(String name);
}
