package com.thienday.posmanagement.validation.impl;

import com.thienday.posmanagement.entity.CompoundQueryItem.LocationManufactureCategorySupplier;
import com.thienday.posmanagement.constant.Constants;
import com.thienday.posmanagement.request.ProductDefinitionDto;
import com.thienday.posmanagement.validation.ProductDefinitionValidation;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Consumer;

@Service
public class ProductDefinitionValidationImpl implements ProductDefinitionValidation {

    Consumer<ProductDefinitionDto> validateProductDefinition = (data) -> {
        Objects.requireNonNull(data.getCategoryId(), Constants.CAN_NOT_BE_NULL("Category id"));
        Objects.requireNonNull(data.getManufactureId(), Constants.CAN_NOT_BE_NULL("Manufacture id"));
        Objects.requireNonNull(data.getSupplierId(), Constants.CAN_NOT_BE_NULL("Supplier id"));
        Objects.requireNonNull(data.getLocationId(), Constants.CAN_NOT_BE_NULL("Location id"));
        Objects.requireNonNull(data.getModelName(),Constants.CAN_NOT_BE_NULL("Model name"));
        Objects.requireNonNull(data.getModel(),Constants.CAN_NOT_BE_NULL("Model"));
    };

    Consumer<LocationManufactureCategorySupplier> validateFieldsToSavingData = (data) -> {
        Objects.requireNonNull(data.getCategory(),Constants.NOT_FOUND("Category id"));
        Objects.requireNonNull(data.getSupplier()
                ,Constants.NOT_FOUND("Supplier id"));
        Objects.requireNonNull(data.getManufacture()
                ,Constants.NOT_FOUND("Manufacture id"));
        Objects.requireNonNull(data.getLocation()
                ,Constants.NOT_FOUND("Location id"));

    };

    @Override
    public void validateProductDefinition(ProductDefinitionDto productDefinitionDto) {
        this.validateProductDefinition.accept(productDefinitionDto);
    }

    @Override
    public void validateSaveProductDefinition(LocationManufactureCategorySupplier compoundData) {
        this.validateFieldsToSavingData.accept(compoundData);
    }
}
