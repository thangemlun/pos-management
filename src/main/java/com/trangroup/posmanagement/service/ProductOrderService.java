package com.trangroup.posmanagement.service;

import com.trangroup.posmanagement.request.ProductOrderDto;
import org.springframework.data.domain.Page;

public interface ProductOrderService {
    ProductOrderDto getProductByPoNumber(String poCode);

    ProductOrderDto addProduct(ProductOrderDto productOrderDto);

    Page<ProductOrderDto> getAllProduct(Integer page,Integer size);

    ProductOrderDto updateProduct(ProductOrderDto productOrderDto);
}
