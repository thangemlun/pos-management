package com.thienday.posmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product_definition",schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDefinition extends BaseEntity{
    @Column(name="model_name")
    private String modelName;

//    @Column(name = "model")
//    private String model;
//
//    @Column(name = "color")
//    private String color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;

    @OneToMany(mappedBy = "productDefinition"
            ,fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Product> products;
}
