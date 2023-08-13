package poolside.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poolside.controller.dto.request.ProductSaveRequestDto;
import poolside.controller.dto.response.ProductResponseDto;
import poolside.entity.Product;
import poolside.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    //저장
    @Transactional
    public Long save(ProductSaveRequestDto saveProduct) {
        return productRepository.save(saveProduct.toEntity()).getId();
    }

    //변경
    @Transactional
    public Long update(Long id , ProductSaveRequestDto updateProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        product.update(updateProduct.getTotCnt(),
                updateProduct.getDescription(),
                updateProduct.getStdCnt(),
                updateProduct.getMaxCnt());
        return id;
    }

    //삭제 로직 확인 필요
    @Transactional
    public Long delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        productRepository.delete(product);
        return id;
    }

    //단건조회(id)
    public ProductResponseDto findProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        return new ProductResponseDto(product);
    }

    //전체조회
    public List<ProductResponseDto> findProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(product -> new ProductResponseDto(product))
                .collect(Collectors.toList());
    }

}
