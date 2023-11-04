package com.thienday.posmanagement.response;

import com.thienday.posmanagement.entity.ProductDefinition;
import com.thienday.posmanagement.request.CategoryDto;
import com.thienday.posmanagement.request.LocationDto;
import com.thienday.posmanagement.request.ManufactureDto;
import com.thienday.posmanagement.request.SupplierDto;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDefinitionResponse {
    private Long sku;
    private String modelName;
    private ManufactureDto manufacture;
    private CategoryDto category;
    private LocationDto location;
    private SupplierDto supplier;
    private Long createdTime;
    private Long updatedTime;

    public static synchronized ProductDefinitionResponse toResponse(ProductDefinition productDefinition){
        ProductDefinitionResponse result = new ProductDefinitionResponse();
        result.setSku(productDefinition.getId());
        result.setCategory(CategoryDto.toDto(productDefinition.getCategory()));
        result.setLocation(LocationDto.toDto(productDefinition.getLocation()));
        result.setManufacture(ManufactureDto.toDto(productDefinition.getManufacture()));
        result.setSupplier(SupplierDto.toDto(productDefinition.getSupplier()));
        result.setModelName(productDefinition.getModelName());
        result.setCreatedTime(productDefinition.getCreatedTime().getTime());
        result.setUpdatedTime(productDefinition.getUpdatedTime().getTime());
        return  result;
    }
}
