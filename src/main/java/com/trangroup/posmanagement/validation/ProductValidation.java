package com.trangroup.posmanagement.validation;

import com.trangroup.posmanagement.request.ProductOrderDto;

public interface ProductValidation {
    void validateProduct(ProductOrderDto productOrderDto);

    void checkExistImei(ProductOrderDto productOrderDto);
}
