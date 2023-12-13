package org.rahulin.hw17.controller;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.service.product.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/id=1")
    public ProductDTO getWithId1() {
        return productService.getById(1L);
    }

    @GetMapping("/getAll")
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/addTelephoneToOrder3")
    public void addWithCurrentDate() {
        ProductDTO product = new ProductDTO();
        product.setName("telephone");
        product.setCost(1111F);
        product.setOrderId(3L);
        productService.add(product);
    }

    @GetMapping("/updateNameWhereId=1")
    public void updateNameWhereId1() {
        ProductDTO product = productService.getById(1L);
        product.setName("meow ULTIMA");
        productService.updateById(1L, product);
    }

    @GetMapping("/deleteWhereId=2")
    public void deleteWhereId2() {
        productService.deleteById(2L);
    }

    @GetMapping("/getProductsOfOrder1")
    public List<ProductDTO> getProductsOfOrder1() {
        return productService.getByOrderId(1L);
    }

    @GetMapping("/getProductsOfOrder2")
    public List<ProductDTO> getProductsOfOrder2() {
        return productService.getByOrderId(2L);
    }

    @GetMapping("/getProductsOfOrder3")
    public List<ProductDTO> getProductsOfOrder3() {
        return productService.getByOrderId(3L);
    }
}
