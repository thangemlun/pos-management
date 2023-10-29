package com.thienday.posmanagement.repository;

import com.thienday.posmanagement.entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface ManufactureRepository extends JpaRepository<Manufacture,Long> {
    List<Manufacture> findAllByIsDeletedFalse();

    @Query(value = "update public.manufacture set is_deleted = true where id in (:ids)",nativeQuery = true)
    @Transactional
    @Modifying
    void deleteManufactureInIds(@Param("ids") Set<Long> ids);
}
