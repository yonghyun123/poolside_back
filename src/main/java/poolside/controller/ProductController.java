package poolside.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import poolside.entity.Product;
import poolside.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public void addProduct(Product product) {
        productService.save(product);
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }
}
