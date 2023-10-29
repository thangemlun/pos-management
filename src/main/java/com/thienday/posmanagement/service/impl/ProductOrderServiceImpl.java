package com.thienday.posmanagement.service.impl;

import com.thienday.posmanagement.entity.ProductDefinition;
import com.thienday.posmanagement.repository.ProductDefinitionRepository;
import com.thienday.posmanagement.repository.ProductRepository;
import com.thienday.posmanagement.entity.Product;
import com.thienday.posmanagement.request.ProductOrderDto;
import com.thienday.posmanagement.service.ProductOrderService;
import com.thienday.posmanagement.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.thienday.posmanagement.constant.Constants.CAN_NOT_BE_NULL;
import static com.thienday.posmanagement.constant.Constants.NOT_FOUND;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductValidation productValidation;

    @Autowired
    private ProductDefinitionRepository productDefinitionRepository;

    @Override
    public ProductOrderDto getProductByPoNumber(String poNumber){
        Product data = productRepository.findProductByPoNumber(poNumber);
        if(Objects.isNull(data)){
            throw new RuntimeException("Product not found");
        }
        return ProductOrderDto.toDto(data);
    }

    @Override
    public ProductOrderDto addProduct(ProductOrderDto productOrderDto) {
        productValidation.validateProduct(productOrderDto);
        productValidation.checkExistImei(productOrderDto);
        ProductDefinition productDefinition = productDefinitionRepository
                .findById(productOrderDto.getProductDefinitionId()).orElse(null);
        Objects.requireNonNull(productDefinition
                ,NOT_FOUND("Product definition"));
        return ProductOrderDto.toDto(productRepository.save(ProductOrderDto
                .toData(productOrderDto,productDefinition)));
    }

    @Override
    public Page<ProductOrderDto> getAllProduct(Integer page,Integer size) {
        Page<ProductOrderDto> result = productRepository.findAll(PageRequest.of(page,size))
                .map(ProductOrderDto::toDto);
        return result;
    }

    @Override
    public ProductOrderDto updateProduct(ProductOrderDto productOrderDto) {
        Objects.requireNonNull(productOrderDto.getId(),CAN_NOT_BE_NULL("Product id"));
        productValidation.validateProduct(productOrderDto);
        Product existed = productRepository.findById(productOrderDto.getId()).orElse(null);
        Objects.requireNonNull(existed,NOT_FOUND("Product order"));
        ProductDefinition productDefinition = productDefinitionRepository
                .findById(productOrderDto.getProductDefinitionId()).orElse(null);
        Objects.requireNonNull(productDefinition
                ,NOT_FOUND("Product definition"));
        ProductOrderDto.updateData(productOrderDto,existed,productDefinition);
        return ProductOrderDto.toDto(productRepository.save(existed));
    }
}
