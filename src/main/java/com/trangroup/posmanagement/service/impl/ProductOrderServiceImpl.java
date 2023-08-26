package com.trangroup.posmanagement.service.impl;

import com.trangroup.posmanagement.entity.ProductOrder;
import com.trangroup.posmanagement.repository.ProductOrderRepository;
import com.trangroup.posmanagement.request.ProductOrderDto;
import com.trangroup.posmanagement.service.ProductOrderService;
import com.trangroup.posmanagement.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.trangroup.posmanagement.constant.Constants.CAN_NOT_BE_NULL;
import static com.trangroup.posmanagement.constant.Constants.NOT_FOUND;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductValidation productValidation;

    @Override
    public ProductOrderDto getProductByPoNumber(String poNumber){
        ProductOrder data = productOrderRepository.findProductByPoNumber(poNumber);
        if(Objects.isNull(data)){
            throw new RuntimeException("Product not found");
        }
        return ProductOrderDto.toDto(data);
    }

    @Override
    public ProductOrderDto addProduct(ProductOrderDto productOrderDto) {
        productValidation.validateProduct(productOrderDto);
        productValidation.checkExistImei(productOrderDto);
        return ProductOrderDto.toDto(productOrderRepository.save(ProductOrderDto.toData(productOrderDto)));
    }

    @Override
    public Page<ProductOrderDto> getAllProduct(Integer page,Integer size) {
        Page<ProductOrderDto> result = productOrderRepository.findAll(PageRequest.of(page,size))
                .map(ProductOrderDto::toDto);
        return result;
    }

    @Override
    public ProductOrderDto updateProduct(ProductOrderDto productOrderDto) {
        Objects.requireNonNull(productOrderDto.getId(),CAN_NOT_BE_NULL("Id product"));
        productValidation.validateProduct(productOrderDto);
        ProductOrder existed = productOrderRepository.findById(productOrderDto.getId()).orElse(null);
        Objects.requireNonNull(existed,NOT_FOUND("Id Product"));
        ProductOrderDto.updateData(productOrderDto,existed);
        return ProductOrderDto.toDto(productOrderRepository.save(existed));
    }
}
