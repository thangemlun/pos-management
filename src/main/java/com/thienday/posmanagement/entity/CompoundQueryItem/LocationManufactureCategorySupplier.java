package com.thienday.posmanagement.entity.CompoundQueryItem;

import com.thienday.posmanagement.entity.Category;
import com.thienday.posmanagement.entity.Location;
import com.thienday.posmanagement.entity.Manufacture;
import com.thienday.posmanagement.entity.Supplier;
import lombok.Data;

@Data
public class LocationManufactureCategorySupplier {
    private Location location;

    private Manufacture manufacture;

    private Supplier supplier;

    private Category category;

}
