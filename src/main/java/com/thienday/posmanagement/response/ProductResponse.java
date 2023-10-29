package com.thienday.posmanagement.response;

import com.thienday.posmanagement.entity.Product;
import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String poNumber;
    private String imeiNumber;

    private String note;

    private String grade;

    private String kitted;

    private String unlockStatus;

    private String storage;
    private ProductDefinitionResponse productDefinition;

    public static synchronized ProductResponse toResponse(Product product){
        ProductResponse result = new ProductResponse();
        result.setId(product.getId());
        result.setNote(product.getNote());
        result.setGrade(product.getGrade());
        result.setKitted(product.getKitted());
        result.setPoNumber(product.getPoNumber());
        result.setImeiNumber(product.getImeiNumber());
        result.setUnlockStatus(product.getUnlockStatus());
        result.setProductDefinition(ProductDefinitionResponse.toResponse(product.getProductDefinition()));
        return result;
    }
}
