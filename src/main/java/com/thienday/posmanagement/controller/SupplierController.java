package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.request.SupplierDto;
import com.thienday.posmanagement.service.SupplierService;
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
@RequestMapping("/api/supplier")
public class SupplierController extends BaseController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/save")
    public ResponseEntity saveSupplier(@RequestBody SupplierDto supplierDto){
        return this.execute(t -> supplierService.saveSupplier(supplierDto),"Save supplier successfully");
    }

    @GetMapping("/all")
    public ResponseEntity getAllSuppliers(){
        return this.execute(t -> supplierService.getAllData(),"Retrieved data successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody Set<Long> ids){
        return this.execute(t -> supplierService.deleteSuppliers(ids),"Deleted suppliers successfully");
    }
}
