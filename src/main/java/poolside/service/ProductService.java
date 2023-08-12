package poolside.service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import poolside.entity.Product;
import poolside.repository.ProductRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow( () -> new NoSuchElementException("값이 존재하지 않습니다"));
    }
}
