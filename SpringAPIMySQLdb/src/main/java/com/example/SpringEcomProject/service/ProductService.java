package com.example.SpringEcomProject.service;

import com.example.SpringEcomProject.model.Product;
import com.example.SpringEcomProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getproductbyId(int id) {
        //return productRepository.findById(id).get();
        return productRepository.findById(id).orElse(null);
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepository.save(product);
    }


    public void delete(int id) {
        productRepository.deleteById(id);
    }

//    public List<Product> search(String keyword) {
//        return productRepository.search(keyword);
//    }
}
