package com.thienday.posmanagement.request;

import com.thienday.posmanagement.entity.Manufacture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufactureDto {
    private Long manufactureId;
    private String manufactureName;

    public ManufactureDto(long id, String name) {
        this.manufactureId = id ;
        this.manufactureName = name;
    }

    public static Manufacture create(ManufactureDto dto){
        Manufacture data = new Manufacture();
        data.setName(dto.getManufactureName());
        return data;
    }

    public static Manufacture update(Manufacture data ,ManufactureDto dto){
        data.setName(dto.getManufactureName());
        return data;
    }

    public static ManufactureDto toDto(Manufacture manufacture){
        return new ManufactureDto(manufacture.getId(),manufacture.getName());
    }
}
