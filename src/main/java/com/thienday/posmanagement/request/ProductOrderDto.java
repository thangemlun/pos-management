package com.thienday.posmanagement.request;

import com.thienday.posmanagement.entity.Product;
import com.thienday.posmanagement.entity.ProductDefinition;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

@Data
public class ProductOrderDto {
    private Long id;

    private Long productDefinitionId;
    @SafeHtml
    private String poNumber;
    @SafeHtml
    private String imeiNumber;
    @SafeHtml
    private String storage;
    @SafeHtml
    private String note;
    @SafeHtml
    private String unlockStatus;
    @SafeHtml
    private String kitted;
    @SafeHtml
    private String grade;

    public static synchronized ProductOrderDto toDto(Product product){
        ProductOrderDto result = new ProductOrderDto();
        result.setId(product.getId());
        result.setPoNumber(product.getPoNumber());
        result.setImeiNumber(product.getImeiNumber());
        result.setStorage(product.getStorage());
        result.setNote(product.getNote());
        result.setUnlockStatus(product.getUnlockStatus());
        result.setKitted(product.getKitted());
        result.setGrade(product.getGrade());
        return result;
    }

    public static synchronized Product toData(ProductOrderDto dto, ProductDefinition productDefinition){
        Product product = new Product();
        product.setPoNumber(dto.getPoNumber());
        product.setImeiNumber(dto.getImeiNumber());
        product.setStorage(dto.getStorage());
        product.setNote(dto.getNote());
        product.setUnlockStatus(dto.getUnlockStatus());
        product.setKitted(dto.getKitted());
        product.setGrade(dto.getGrade());
        product.setProductDefinition(productDefinition);
        return product;
    }

    public static synchronized ProductOrderDto updateData(
            ProductOrderDto dto ,
            Product order,
            ProductDefinition productDefinition){
        order.setImeiNumber(dto.getImeiNumber());
        order.setPoNumber(dto.getPoNumber());
        order.setStorage(dto.getStorage());
        order.setNote(dto.getNote());
        order.setKitted(dto.getKitted());
        order.setGrade(dto.getGrade());
        order.setUnlockStatus(dto.getUnlockStatus());
        order.setProductDefinition(productDefinition);
        return dto;
    }
}
