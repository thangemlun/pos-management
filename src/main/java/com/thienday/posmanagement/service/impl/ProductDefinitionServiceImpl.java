package com.thienday.posmanagement.service.impl;

import com.thienday.posmanagement.entity.CompoundQueryItem.LocationManufactureCategorySupplier;
import com.thienday.posmanagement.entity.ProductDefinition;
import com.thienday.posmanagement.paging.PagingRequest;
import com.thienday.posmanagement.repository.CategoryRepository;
import com.thienday.posmanagement.repository.LocationRepository;
import com.thienday.posmanagement.repository.ManufactureRepository;
import com.thienday.posmanagement.repository.SupplierRepository;
import com.thienday.posmanagement.request.ProductDefinitionDto;
import com.thienday.posmanagement.response.ProductDefinitionResponse;
import com.thienday.posmanagement.service.ProductDefinitionService;
import com.thienday.posmanagement.validation.ProductDefinitionValidation;
import com.thienday.posmanagement.constant.Constants;
import com.thienday.posmanagement.repository.ProductDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductDefinitionServiceImpl implements ProductDefinitionService {
    @Autowired
    private ProductDefinitionRepository productDefinitionRepository;
    @Autowired
    private ProductDefinitionValidation productDefinitionValidation;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ManufactureRepository manufactureRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public ProductDefinitionResponse getProductDefinitionById(Long id) {
        Objects.requireNonNull(id, Constants.CAN_NOT_BE_NULL("Product definition id can not be null"));
        ProductDefinition productDefinition = productDefinitionRepository.findById(id).orElse(null);
        if(Objects.isNull(productDefinition)){
            throw new RuntimeException(Constants.NOT_FOUND(String.format("Product id : %s",id)));
        }
        return ProductDefinitionResponse.toResponse(productDefinition);
    }

    @Override
    public ProductDefinitionResponse saveProductDefinition(ProductDefinitionDto dto) {
        productDefinitionValidation.validateProductDefinition(dto);
        LocationManufactureCategorySupplier compoundData = getAllMandatoryDataForProductDefinition(dto);
        productDefinitionValidation.validateSaveProductDefinition(compoundData);
        if(Objects.nonNull(dto.getProductDefinitionId())) {
            ProductDefinition oldOne = productDefinitionRepository.findById(dto.getProductDefinitionId())
                    .orElse(null);
            Objects.requireNonNull(oldOne,
                    Constants.NOT_FOUND("Product definition id "+ dto.getProductDefinitionId()));
            return ProductDefinitionResponse.toResponse(productDefinitionRepository.save(ProductDefinitionDto
                    .updateData(oldOne,dto,compoundData)));
        }
        return ProductDefinitionResponse.toResponse(productDefinitionRepository
                .save(ProductDefinitionDto.toData(dto,compoundData)));
    }

    @Override
    public Page<ProductDefinitionResponse> getListPagingProductDefinition(PagingRequest paging) {
        PageRequest pageRequest = PageRequest.of(paging.getPage(), paging.getSize()
                ,Sort.by(Sort.Direction.fromString(paging.getSortDirection()),paging.getProperties()));

        return productDefinitionRepository.findAll(pageRequest).map(ProductDefinitionResponse::toResponse);
    }

    private LocationManufactureCategorySupplier getAllMandatoryDataForProductDefinition(ProductDefinitionDto dto){
        LocationManufactureCategorySupplier result = new LocationManufactureCategorySupplier();
        List<CompletableFuture<?>> concurrencyMultiTaskQuery = new ArrayList<>();

        //Get Location
        concurrencyMultiTaskQuery.add(CompletableFuture.runAsync(() -> {
            result.setLocation(locationRepository.findById(dto.getLocationId()).orElse(null));
        }));
        //Get Manufacture
        concurrencyMultiTaskQuery.add(CompletableFuture.runAsync(() -> {
            result.setManufacture(manufactureRepository.findById(dto.getManufactureId()).orElse(null));
        }));
        //Get Category
        concurrencyMultiTaskQuery.add(CompletableFuture.runAsync(() -> {
            result.setCategory(categoryRepository.findById(dto.getCategoryId()).orElse(null));
        }));
        //Get Supplier
        concurrencyMultiTaskQuery.add(CompletableFuture.runAsync(() -> {
            result.setSupplier(supplierRepository.findById(dto.getSupplierId()).orElse(null));
        }));

        CompletableFuture.allOf(concurrencyMultiTaskQuery
                .toArray(new CompletableFuture[concurrencyMultiTaskQuery.size()])).join();

        return result;
    }
}
