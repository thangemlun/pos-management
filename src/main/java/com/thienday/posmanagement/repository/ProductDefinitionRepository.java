package com.thienday.posmanagement.repository;

import com.thienday.posmanagement.entity.ProductDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDefinitionRepository extends JpaRepository<ProductDefinition,Long> {
}
