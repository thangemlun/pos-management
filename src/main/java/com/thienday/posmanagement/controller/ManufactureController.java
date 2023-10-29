package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.entity.Manufacture;
import com.thienday.posmanagement.request.ManufactureDto;
import com.thienday.posmanagement.service.ManufactureService;
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
@RequestMapping("/api/manufacture")
public class ManufactureController extends BaseController{
    @Autowired
    private ManufactureService manufactureService;
    @PostMapping("/save")
    public ResponseEntity saveManufacture(@RequestBody ManufactureDto dto){
        return this.execute(t -> manufactureService.saveManufacture(dto),"Save manufacture successfully !");
    }

    @GetMapping("/all")
    public ResponseEntity getAllManufactures(){
        return this.execute(t -> manufactureService.getAllManufactures(),"Retrieved data successfully !");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteManufactures(@RequestBody Set<Long> ids){
        return this.execute(t -> manufactureService.deleteManufactures(ids),"Deleted manufactures successfully");
    }
}
