package com.platzimarket.web.controllers;

import com.platzimarket.domain.ProductMap;
import com.platzimarket.domain.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author aguileradev
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/all")
    @Operation(summary = "Get all products available on the supermarket")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<ProductMap>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get a product by an ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "OK"),
            @ApiResponse(responseCode = "404" , description = "NOT_FOUND")
    })
    @Parameter(description = "Id from a product", required = true, example = "7")
    public ResponseEntity<ProductMap> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping(path ="/category/{id}")
    @Operation(summary = "Get a product by its category")
    @Parameter(description = "The category ID", required = true, example = "1")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND")
    })
    public ResponseEntity<List<ProductMap>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/save")
    @Operation(summary = "Save a product in a database")
    @Parameter(description = "A product", required = true)
    @ApiResponse(responseCode = "201" , description = "CREATED")
    public ResponseEntity<ProductMap> save(@RequestBody ProductMap productMap){
        return new ResponseEntity<>(productService.save(productMap), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Delete a product by ID")
    @Parameter(description = "the id for the product to be removed")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND")
    })
    public ResponseEntity<Boolean> delete(@PathVariable("id") int productId){
        boolean status = productService.delete(productId);
        if(!status){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
