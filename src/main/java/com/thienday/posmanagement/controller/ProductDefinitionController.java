package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.paging.PagingRequest;
import com.thienday.posmanagement.request.ProductDefinitionDto;
import com.thienday.posmanagement.response.DataResponse;
import com.thienday.posmanagement.service.ProductDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/api/product-definition")
public class ProductDefinitionController {

    @Autowired
    private ProductDefinitionService productDefinitionService;

    @GetMapping("/{id}")
    public ResponseEntity getProductiDefinitionById(@PathVariable("id") Long id){
        return this.execute(t -> productDefinitionService.getProductDefinitionById(id)
                ,"Get product definition successfully");
    }

    @PostMapping("/save")
    public ResponseEntity addProductDefinition(@RequestBody ProductDefinitionDto productDefinitionDto){
        return this.execute(t -> productDefinitionService.saveProductDefinition(productDefinitionDto,null),
                "Save product definition successfully");
    }

    @PutMapping("/{productDefinitionId}/update")
    public ResponseEntity addProductDefinition(
            @PathVariable("productDefinitionId") Long productDefinitionId,
            @RequestBody ProductDefinitionDto productDefinitionDto){
        return this.execute(t -> productDefinitionService.saveProductDefinition(
                productDefinitionDto,productDefinitionId),
                "Save product definition successfully");
    }

    @PostMapping("/list")
    public ResponseEntity getListPagingProductDefinition(
            @RequestBody PagingRequest paging){
        return this.execute(t -> productDefinitionService.getListPagingProductDefinition(paging),
                "Retrieved list product definition successfully");
    }
    public <R> ResponseEntity<?> execute(Function<R,?> service, String message){
        try{
            return ResponseEntity.ok(DataResponse.apiResult(service.apply(null)
                    ,message));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(DataResponse.apiError(e.getMessage()));
        }
    }
}
