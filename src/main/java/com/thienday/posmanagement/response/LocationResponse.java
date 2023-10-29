package com.thienday.posmanagement.response;

import com.thienday.posmanagement.entity.Location;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationResponse {
    private Long id ;
    private String locationName;

    public static LocationResponse toResponse(Location location){
        return LocationResponse.builder()
                .id(location.getId())
                .locationName(location.getName())
                .build();
    }
}
