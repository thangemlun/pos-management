package com.thienday.posmanagement.service;

import com.thienday.posmanagement.request.SupplierDto;
import com.thienday.posmanagement.response.SupplierResponse;

import java.util.List;
import java.util.Set;

public interface SupplierService {
    List<SupplierResponse> getAllData();
    SupplierResponse saveSupplier(SupplierDto dto);

    boolean deleteSuppliers(Set<Long> ids);
}
