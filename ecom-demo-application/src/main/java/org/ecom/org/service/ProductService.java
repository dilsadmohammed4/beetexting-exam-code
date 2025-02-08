package org.ecom.org.service;

import org.ecom.org.model.Product;
import org.ecom.org.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getProducts(String name, String category, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        if (name != null && category != null) {
            return (Page<Product>) productRepository.findAll(pageable)
                    .map(product -> product.getName().toLowerCase().contains(name.toLowerCase()) &&
                            product.getCategory().equalsIgnoreCase(category) ? product : null)
                    .filter(product -> product != null);
        } else {
            return productRepository.findAll(pageable);
        }
    }
}

