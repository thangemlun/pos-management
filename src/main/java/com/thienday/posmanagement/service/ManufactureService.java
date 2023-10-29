package com.thienday.posmanagement.service;

import com.thienday.posmanagement.request.ManufactureDto;
import com.thienday.posmanagement.response.ManufactureResponse;

import java.util.List;
import java.util.Set;

public interface ManufactureService {
    ManufactureResponse saveManufacture(ManufactureDto dto);

    List<ManufactureResponse> getAllManufactures();

    boolean deleteManufactures(Set<Long> ids);
}
