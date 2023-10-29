package com.thienday.posmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "product",schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity implements Serializable {
    @Column(name="imei_number")
    private String imeiNumber;

    @Column(name="po_number")
    private String poNumber;

    @Column(name = "note")
    private String note;

    @Column(name = "grade")
    private String grade;

    @Column(name = "unlock_status")
    private String unlockStatus;

    @Column(name = "kitted")
    private String kitted;

    @Column(name = "storage")
    private String storage;

    @ManyToOne
    @JoinColumn(name = "product_definition_id")
    private ProductDefinition productDefinition;
}
