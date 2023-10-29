package com.thienday.posmanagement.service.impl;

import com.thienday.posmanagement.repository.LocationRepository;
import com.thienday.posmanagement.request.LocationDto;
import com.thienday.posmanagement.response.LocationResponse;
import com.thienday.posmanagement.entity.Location;
import com.thienday.posmanagement.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationResponse saveLocation(LocationDto dto) {
        if(Objects.nonNull(dto.getLocationId())) {
            Location update = locationRepository.getReferenceById(dto.getLocationId());
            if(update == null){
                throw new RuntimeException("Supplier id not found !");
            }
            return LocationResponse.toResponse(locationRepository.save(LocationDto.update(update,dto)));
        }
        return LocationResponse.toResponse(locationRepository.save(LocationDto.create(dto)));
    }

    @Override
    public List<LocationResponse> getAllLocation() {
        return locationRepository.findAllByIsDeletedFalse().stream()
                .map(LocationResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteLocations(Set<Long> ids) {
        locationRepository.deleteLocationInIds(ids);
        return true;
    }
}
