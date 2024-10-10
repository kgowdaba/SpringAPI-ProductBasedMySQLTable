package com.example.SpringEcomProject.Controller;

import com.example.SpringEcomProject.model.Product;
import com.example.SpringEcomProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getproduct() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getproductbyId(id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addproduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product saveproduct = null;
        try {
            saveproduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(saveproduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product updatepro = null;
        try {
            updatepro = productService.addOrUpdateProduct(product, imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(updatepro, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        Product p = productService.getproductbyId(id);
        if(p!=null){
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Product>> search(@RequestParam String keyword)
//    {
//        List<Product> products=productService.search(keyword);
//        System.out.println(keyword);
//        return new ResponseEntity<>(products,HttpStatus.OK);
//    }


}
