package org.rahulin.hw17.controller;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getById(@PathVariable("productId") Long productId) {
        Optional<ProductDTO> productOptional = productService.getById(productId);
        ProductDTO product = null;
        if(productOptional.isPresent()) {
            product = productOptional.get();
        }
        if(product != null) {
            return ResponseEntity.ok(product);
        }
        return (ResponseEntity<ProductDTO>) ResponseEntity.notFound();
    }

//    Власне, проба на ApiResponse
//    @GetMapping("/{productId}")
//    public ApiResponse<ProductDTO> getById(@PathVariable("productId") Long productId) {
//        ApiResponse<ProductDTO> response = new ApiResponse<>();
//        ProductDTO product = productService.getById(productId);
//        if(product != null) {
//            response.setSuccess(true);
//            response.setData(product);
//        }
//        return response;
//    }

    @CrossOrigin("*")
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> products = productService.getAll();
        if(!CollectionUtils.isEmpty(products)) {
            return ResponseEntity.ok(products);
        }
        return (ResponseEntity<List<ProductDTO>>) ResponseEntity.notFound();
    }

    @CrossOrigin("*")
    @GetMapping("/getFromOrder/{orderId}")
    public ResponseEntity<List<ProductDTO>> getByOrderId(@PathVariable("orderId") Long orderId) {
        List<ProductDTO> products = productService.getByOrderId(orderId);
        if(!CollectionUtils.isEmpty(products)) {
            return ResponseEntity.ok(products);
        }
        return (ResponseEntity<List<ProductDTO>>) ResponseEntity.notFound();
    }

    @CrossOrigin("*")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody ProductDTO product) {
        productService.add(product);
    }

    @CrossOrigin("*")
    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ProductDTO product) {
        productService.update(product);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("productId") Long productId) {
        productService.deleteById(productId);
    }

}
