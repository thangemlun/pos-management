package com.trangroup.posmanagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_time")
    @UpdateTimestamp
    private Date updatedTime;

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_time")
    @CreationTimestamp
    private Date createdTime;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}
