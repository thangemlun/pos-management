package com.trangroup.posmanagement.validation.impl;

import com.trangroup.posmanagement.repository.ProductOrderRepository;
import com.trangroup.posmanagement.request.ProductOrderDto;
import com.trangroup.posmanagement.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Consumer;

import static com.trangroup.posmanagement.constant.Constants.CAN_NOT_BE_NULL;
import static com.trangroup.posmanagement.constant.Constants.EXIST_IMEI;

@Service
public class ProductValidationImpl implements ProductValidation {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    Consumer<ProductOrderDto> validateField = (data) -> {
        Objects.requireNonNull(data.getPoNumber(),CAN_NOT_BE_NULL("Product Number"));
        Objects.requireNonNull(data.getModelName(),CAN_NOT_BE_NULL("Model name"));
        Objects.requireNonNull(data.getImeiNumber(),CAN_NOT_BE_NULL("Imei"));
    };

    Consumer<String> validateExistImei = (imei) -> {
        Objects.requireNonNull(imei,CAN_NOT_BE_NULL("Imei number"));
        if(Objects.nonNull(productOrderRepository.findByImeiNumber(imei))){
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
