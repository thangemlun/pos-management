package com.thienday.posmanagement.response;

import com.thienday.posmanagement.entity.Manufacture;
import com.thienday.posmanagement.entity.Supplier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ManufactureResponse {
    private Long id;
    private String manufactureName;

    public static ManufactureResponse toResponse(Manufacture manufacture){
        return ManufactureResponse.builder()
                .id(manufacture.getId())
                .manufactureName(manufacture.getName())
                .build();
    }
}
