package com.thienday.posmanagement.request;

import com.thienday.posmanagement.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long locationId;
    private String locationName;

    public LocationDto(long id, String name) {
        this.locationId = id ;
        this.locationName = name;
    }

    public static Location create(LocationDto dto){
        Location data = new Location();
        data.setName(dto.getLocationName());
        return data;
    }

    public static Location update(Location data ,LocationDto dto){
        data.setName(dto.getLocationName());
        return data;
    }

    public static LocationDto toDto(Location location){
        return new LocationDto(location.getId(),location.getName());
    }
}
