package com.thienday.posmanagement.repository;

import com.thienday.posmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByIsDeletedFalse();

    @Query(value = "update public.category set is_deleted = true where id in (:ids)",nativeQuery = true)
    void deleteCategoryInIds(@Param("ids") Set<Long> ids);
}
