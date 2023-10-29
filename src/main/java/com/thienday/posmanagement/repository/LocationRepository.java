package com.thienday.posmanagement.repository;

import com.thienday.posmanagement.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface LocationRepository extends JpaRepository<Location,Long> {

    List<Location> findAllByIsDeletedFalse();

    @Query(value = "update public.location set is_deleted = true where id in (:ids)",nativeQuery = true)
    @Transactional
    @Modifying
    void deleteLocationInIds(@Param("ids") Set<Long> ids);
}
