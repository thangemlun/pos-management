package com.trangroup.posmanagement.controller;

import com.trangroup.posmanagement.request.ProductOrderDto;
import com.trangroup.posmanagement.response.DataResponse;
import com.trangroup.posmanagement.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/api/product-order")
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping("/getByProductNumber")
    public ResponseEntity getProductByPoNumber(@RequestParam(name = "poNumber",required = true) String poNumber){
        return this.execute(t -> productOrderService.getProductByPoNumber(poNumber),"Get Product Successfully");
    }

    @PostMapping("/addProduct")
    public ResponseEntity addProductOrder(@RequestBody ProductOrderDto productOrderDto){
        return this.execute(t -> productOrderService.addProduct(productOrderDto),"Add Product Successfully");
    }

    @PutMapping("/updateProduct")
    public ResponseEntity updateProductOrder(@RequestBody ProductOrderDto productOrderDto){
        return this.execute(t -> productOrderService.updateProduct(productOrderDto),"Update Product Successfully");
    }

    @GetMapping("/all")
    public ResponseEntity getAllProduct(@RequestParam(name = "page",defaultValue = "0") Integer page,
                                        @RequestParam(name = "size",defaultValue = "1000") Integer size){
        return this.execute(t -> productOrderService.getAllProduct(page,size)
                ,"Retrieved Products Successfully");
    }

    public <R> ResponseEntity<?> execute(Function<R,?> service,String message){
        try{
            return ResponseEntity.ok(DataResponse.apiResult(service.apply(null)
                    ,message));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(DataResponse.apiError(e.getMessage()));
        }
    }
}
