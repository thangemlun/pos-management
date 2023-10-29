package com.thienday.posmanagement.service;

import com.thienday.posmanagement.request.LocationDto;
import com.thienday.posmanagement.response.LocationResponse;

import java.util.List;
import java.util.Set;

public interface LocationService {
    LocationResponse saveLocation(LocationDto locationDto);

    List<LocationResponse> getAllLocation();

    boolean deleteLocations(Set<Long> ids);
}
