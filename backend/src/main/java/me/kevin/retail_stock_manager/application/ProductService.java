package me.kevin.retail_stock_manager.application;

import lombok.RequiredArgsConstructor;
import me.kevin.retail_stock_manager.domain.Product;
import me.kevin.retail_stock_manager.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductBySku(String sku) {
        return productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé : " + sku));
    }

    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}