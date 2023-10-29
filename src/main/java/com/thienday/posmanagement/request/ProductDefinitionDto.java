package com.thienday.posmanagement.request;

import com.thienday.posmanagement.entity.CompoundQueryItem.LocationManufactureCategorySupplier;
import com.thienday.posmanagement.entity.ProductDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDefinitionDto {
    private String modelName;

    private String model;

    private String color;

    private Long locationId;
    private Long supplierId;

    private Long manufactureId;

    private Long categoryId;

    public static ProductDefinition toData(ProductDefinitionDto productDefinitionDto,
                                           LocationManufactureCategorySupplier compoundData){
        ProductDefinition productDefinition = new ProductDefinition();
        productDefinition.setLocation(compoundData.getLocation());
        productDefinition.setManufacture(compoundData.getManufacture());
        productDefinition.setSupplier(compoundData.getSupplier());
        productDefinition.setCategory(compoundData.getCategory());
        productDefinition.setColor(productDefinitionDto.getColor());
        productDefinition.setModelName(productDefinitionDto.getModelName());
        productDefinition.setModel(productDefinitionDto.getModel());
        return productDefinition;
    }

    public static ProductDefinition updateData(ProductDefinition toBeUpdated,
                                               ProductDefinitionDto productDefinitionDto,
                                               LocationManufactureCategorySupplier compoundData){
        toBeUpdated.setLocation(compoundData.getLocation());
        toBeUpdated.setManufacture(compoundData.getManufacture());
        toBeUpdated.setSupplier(compoundData.getSupplier());
        toBeUpdated.setCategory(compoundData.getCategory());
        toBeUpdated.setColor(productDefinitionDto.getColor());
        toBeUpdated.setModelName(productDefinitionDto.getModelName());
        toBeUpdated.setModel(productDefinitionDto.getModel());
        return toBeUpdated;
    }
}
