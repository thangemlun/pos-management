package com.thienday.posmanagement.response;

import com.thienday.posmanagement.entity.ProductDefinition;
import com.thienday.posmanagement.request.CategoryDto;
import com.thienday.posmanagement.request.LocationDto;
import com.thienday.posmanagement.request.ManufactureDto;
import com.thienday.posmanagement.request.SupplierDto;
import lombok.Data;

@Data
public class ProductDefinitionResponse {
    private Long id;
    private String modelName;
    private String model;
    private ManufactureDto manufacture;
    private CategoryDto category;
    private LocationDto location;
    private SupplierDto supplier;
    private String color;

    public static synchronized ProductDefinitionResponse toResponse(ProductDefinition productDefinition){
        ProductDefinitionResponse result = new ProductDefinitionResponse();
        result.setId(productDefinition.getId());
        result.setCategory(CategoryDto.toDto(productDefinition.getCategory()));
        result.setColor(productDefinition.getColor());
        result.setLocation(LocationDto.toDto(productDefinition.getLocation()));
        result.setModel(productDefinition.getModel());
        result.setManufacture(ManufactureDto.toDto(productDefinition.getManufacture()));
        result.setSupplier(SupplierDto.toDto(productDefinition.getSupplier()));
        result.setModelName(productDefinition.getModelName());
        return  result;
    }
}
