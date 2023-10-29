package com.thienday.posmanagement.validation.impl;

import com.thienday.posmanagement.repository.ProductDefinitionRepository;
import com.thienday.posmanagement.repository.ProductRepository;
import com.thienday.posmanagement.request.ProductOrderDto;
import com.thienday.posmanagement.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Consumer;

import static com.thienday.posmanagement.constant.Constants.CAN_NOT_BE_NULL;
import static com.thienday.posmanagement.constant.Constants.EXIST_IMEI;

@Service
public class ProductValidationImpl implements ProductValidation {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDefinitionRepository productDefinitionRepository;

    Consumer<ProductOrderDto> validateField = (data) -> {
        Objects.requireNonNull(data.getProductDefinitionId(),CAN_NOT_BE_NULL("Product definition id"));
        Objects.requireNonNull(data.getPoNumber(),CAN_NOT_BE_NULL("Product Number"));
        Objects.requireNonNull(data.getImeiNumber(),CAN_NOT_BE_NULL("Imei"));
        Objects.requireNonNull(data.getUnlockStatus(),CAN_NOT_BE_NULL("Unlock status"));
        Objects.requireNonNull(data.getStorage(),CAN_NOT_BE_NULL("Storage"));
        Objects.requireNonNull(data.getKitted(),CAN_NOT_BE_NULL("Kitted"));
    };

    Consumer<String> validateExistImei = (imei) -> {
        Objects.requireNonNull(imei,CAN_NOT_BE_NULL("Imei number"));
        if(Objects.nonNull(productRepository.findByImeiNumber(imei))){
         throw new RuntimeException(EXIST_IMEI(imei));
        }
    } ;
    @Override
    public void validateProduct(ProductOrderDto productOrderDto) {
        validateField.accept(productOrderDto);
    }

    @Override
    public void checkExistImei(ProductOrderDto productOrderDto) {
        validateExistImei.accept(productOrderDto.getImeiNumber());
    }
}
