package poolside.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import poolside.common.dto.Response;
import poolside.controller.dto.request.ProductSaveRequestDto;
import poolside.controller.dto.response.ProductResponseDto;
import poolside.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public Response<Long> addProduct(@RequestBody ProductSaveRequestDto saveProduct) {
        return Response.ok(productService.save(saveProduct));
    }

    @PutMapping("/products/{id}")
    public Response<Long> updateProduct(@PathVariable Long id, ProductSaveRequestDto updateProduct){
        return Response.ok(productService.update(id, updateProduct));
    }

    @DeleteMapping("/products/{id}")
    public Response<Long> deleteProduct(@PathVariable Long id) {
        return Response.ok(productService.delete(id));
    }

    @GetMapping("/products/{id}")
    public Response<ProductResponseDto> findProductById(@PathVariable Long id) {
        return Response.ok(productService.findProductById(id));
    }

    @GetMapping("/products")
    public Response<List<ProductResponseDto>> findProducts() {
        return Response.ok(productService.findProducts());
    }

}
