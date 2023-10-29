package com.thienday.posmanagement.service;

import com.thienday.posmanagement.paging.PagingRequest;
import com.thienday.posmanagement.request.ProductDefinitionDto;
import com.thienday.posmanagement.response.ProductDefinitionResponse;
import org.springframework.data.domain.Page;

public interface ProductDefinitionService {
    ProductDefinitionResponse getProductDefinitionById(Long id);
    ProductDefinitionResponse saveProductDefinition(ProductDefinitionDto dto,Long productDefinitionId);

    Page<ProductDefinitionResponse> getListPagingProductDefinition(PagingRequest paging);
}
