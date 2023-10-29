package com.thienday.posmanagement.repository;

import com.thienday.posmanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    List<Supplier> findAllByIsDeletedFalse();

    @Query(value = "update public.supplier set is_deleted = true where id in (:ids)",nativeQuery = true)
    @Transactional
    @Modifying
    void deleteSupplierInIds(@Param("ids") Set<Long> ids);
}
