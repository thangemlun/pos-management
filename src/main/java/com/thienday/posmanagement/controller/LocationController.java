package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.request.LocationDto;
import com.thienday.posmanagement.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/location")
public class LocationController extends BaseController{
    @Autowired
    private LocationService locationService;

    @PostMapping("/save")
    public ResponseEntity saveLocation(@RequestBody LocationDto locationDto){
        return this.execute(t -> locationService.saveLocation(locationDto),"Save location successfully");
    }

    @GetMapping("/all")
    public ResponseEntity getAllLocations(){
        return this.execute(t -> locationService.getAllLocation(),"Retrieved data successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteManufactures(@RequestBody Set<Long> ids){
        return this.execute(t -> locationService.deleteLocations(ids),"Deleted locations successfully");
    }
}
