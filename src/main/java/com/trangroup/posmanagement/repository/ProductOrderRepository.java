package com.trangroup.posmanagement.repository;

import com.trangroup.posmanagement.entity.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Long> {
    ProductOrder findProductByPoNumber(String poNumber);

    ProductOrder findByImeiNumber(String imei);

    @Query("select po from ProductOrder po where po.isDeleted is false")
    Page<ProductOrder> findAll(Pageable pageable);
}
