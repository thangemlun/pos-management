package com.thienday.posmanagement.service.impl;

import com.thienday.posmanagement.repository.SupplierRepository;
import com.thienday.posmanagement.request.SupplierDto;
import com.thienday.posmanagement.response.SupplierResponse;
import com.thienday.posmanagement.entity.Supplier;
import com.thienday.posmanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierResponse> getAllData() {
        return supplierRepository.findAllByIsDeletedFalse().stream()
                .map(SupplierResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierResponse saveSupplier(SupplierDto dto) {
        if(Objects.nonNull(dto.getSupplierId())) {
            Supplier update = supplierRepository.getReferenceById(dto.getSupplierId());
            if(update == null){
                throw new RuntimeException("Supplier id not found !");
            }
            return SupplierResponse.toResponse(supplierRepository.save(SupplierDto.update(update,dto)));
        }
        return SupplierResponse.toResponse(supplierRepository.save(SupplierDto.create(dto)));
    }

    @Override
    public boolean deleteSuppliers(Set<Long> ids) {
        supplierRepository.deleteSupplierInIds(ids);
        return true;
    }
}
