package com.thienday.posmanagement.service;

import com.thienday.posmanagement.request.ProductOrderDto;
import org.springframework.data.domain.Page;

public interface ProductOrderService {
    ProductOrderDto getProductByPoNumber(String poCode);

    ProductOrderDto addProduct(ProductOrderDto productOrderDto);

    Page<ProductOrderDto> getAllProduct(Integer page,Integer size);

    ProductOrderDto updateProduct(ProductOrderDto productOrderDto);
}
