package com.thienday.posmanagement.request;

import com.thienday.posmanagement.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {

    private Long supplierId;
    private String supplierName;

    public SupplierDto(long id, String name) {
        this.supplierId = id ;
        this.supplierName = name;
    }

    public static Supplier create(SupplierDto dto){
        Supplier data = new Supplier();
        data.setName(dto.getSupplierName());
        return data;
    }

    public static Supplier update(Supplier data ,SupplierDto dto){
        data.setName(dto.getSupplierName());
        return data;
    }

    public static SupplierDto toDto(Supplier supplier){
        return new SupplierDto(supplier.getId(),supplier.getName());
    }
}
