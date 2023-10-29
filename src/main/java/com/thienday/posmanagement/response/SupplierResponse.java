package com.thienday.posmanagement.response;

import com.thienday.posmanagement.entity.Supplier;
import lombok.Data;

@Data
public class SupplierResponse {
    private Long id;
    private String supplierName;

    public static SupplierResponse toResponse(Supplier supplier){
        SupplierResponse response = new SupplierResponse();
        response.setId(supplier.getId());
        response.setSupplierName(supplier.getName());
        return response;
    }
}
