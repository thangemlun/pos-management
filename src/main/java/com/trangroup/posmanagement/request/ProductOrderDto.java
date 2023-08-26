package com.trangroup.posmanagement.request;

import com.trangroup.posmanagement.entity.ProductOrder;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

@Data
public class ProductOrderDto {
    private Long id;
    @SafeHtml
    private String poNumber;
    @SafeHtml
    private String modelName;
    @SafeHtml
    private String imeiNumber;
    @SafeHtml
    private String storage;
    @SafeHtml
    private String brandName;
    @SafeHtml
    private String description;

    public static synchronized ProductOrderDto toDto(ProductOrder product){
        ProductOrderDto result = new ProductOrderDto();
        result.setId(product.getId());
        result.setPoNumber(product.getPoNumber());
        result.setStorage(product.getStorage());
        result.setBrandName(product.getBrandName());
        result.setModelName(product.getModelName());
        result.setImeiNumber(product.getImeiNumber());
        result.setDescription(product.getDescription());
        return result;
    }

    public static synchronized ProductOrder toData(ProductOrderDto dto){
        ProductOrder productOrder = new ProductOrder();
        productOrder.setBrandName(dto.getBrandName());
        productOrder.setDescription(dto.getDescription());
        productOrder.setPoNumber(dto.getPoNumber());
        productOrder.setModelName(dto.getModelName());
        productOrder.setImeiNumber(dto.getImeiNumber());
        productOrder.setStorage(dto.getStorage());
        return productOrder;
    }

    public static synchronized ProductOrderDto updateData(ProductOrderDto dto ,ProductOrder order){
        order.setStorage(dto.getStorage());
        order.setDescription(dto.getDescription());
        order.setImeiNumber(dto.getImeiNumber());
        order.setBrandName(dto.getBrandName());
        order.setModelName(dto.getModelName());
        order.setPoNumber(dto.getPoNumber());
        return dto;
    }
}
