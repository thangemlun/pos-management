package com.thienday.posmanagement.repository;

import com.thienday.posmanagement.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByPoNumber(String poNumber);

    Product findByImeiNumber(String imei);

    @Query("select po from Product po where po.isDeleted is false")
    Page<Product> findAll(Pageable pageable);
}
