package com.thienday.posmanagement.repository;

import com.thienday.posmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select count(scan) > 0 from public.user scan " +
            "where scan.user_name = :userName and scan.password = :password ",nativeQuery = true)
    boolean isExistUserInfoByUserNameAndPassword(@Param("userName") String userName,
                                                 @Param("password") String password);

    @Query(value = "select u.* from public.user u where u.user_name = :userName and u.password = :password " ,nativeQuery = true)
    User getUserInfoByUserNameAndPassword(@Param("userName") String userName,
                                          @Param("password") String password);
}
