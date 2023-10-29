package com.thienday.posmanagement.service.impl;

import com.thienday.posmanagement.entity.Category;
import com.thienday.posmanagement.entity.Manufacture;
import com.thienday.posmanagement.repository.ManufactureRepository;
import com.thienday.posmanagement.request.CategoryDto;
import com.thienday.posmanagement.request.ManufactureDto;
import com.thienday.posmanagement.response.CategoryResponse;
import com.thienday.posmanagement.response.ManufactureResponse;
import com.thienday.posmanagement.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    private ManufactureRepository manufactureRepository;

    @Override
    public ManufactureResponse saveManufacture(ManufactureDto dto) {
        if(Objects.nonNull(dto.getManufactureId())) {
            Manufacture update = manufactureRepository.getReferenceById(dto.getManufactureId());
            if(update == null){
                throw new RuntimeException("Supplier id not found !");
            }
            return ManufactureResponse.toResponse(manufactureRepository.save(ManufactureDto.update(update,dto)));
        }
        return ManufactureResponse.toResponse(manufactureRepository.save(ManufactureDto.create(dto)));
    }

    @Override
    public List<ManufactureResponse> getAllManufactures() {
        return manufactureRepository.findAllByIsDeletedFalse()
                .stream()
                .map(ManufactureResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteManufactures(Set<Long> ids) {
        manufactureRepository.deleteManufactureInIds(ids);
        return true;
    }
}
