package com.trangroup.posmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "product_order",schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder extends BaseEntity implements Serializable {
    @Column(name="model_name")
    private String modelName;

    @Column(name="imei_number")
    private String imeiNumber;

    @Column(name="po_number")
    private String poNumber;

    @Column(name = "storage")
    private String storage;

    @Column(name = "description")
    private String description;

    @Column(name = "brand_name")
    private String brandName;
}
