package com.thienday.posmanagement.validation;

import com.thienday.posmanagement.entity.CompoundQueryItem.LocationManufactureCategorySupplier;
import com.thienday.posmanagement.request.ProductDefinitionDto;

public interface ProductDefinitionValidation {
    void validateProductDefinition(ProductDefinitionDto productDefinitionDto);
    void validateSaveProductDefinition(LocationManufactureCategorySupplier compoundData);
}
