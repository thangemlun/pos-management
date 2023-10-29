package com.thienday.posmanagement.validation;

import com.thienday.posmanagement.request.ProductOrderDto;

public interface ProductValidation {
    void validateProduct(ProductOrderDto productOrderDto);

    void checkExistImei(ProductOrderDto productOrderDto);
}
