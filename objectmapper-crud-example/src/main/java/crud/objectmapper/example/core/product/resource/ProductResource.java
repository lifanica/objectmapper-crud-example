package crud.objectmapper.example.core.product.resource;


import crud.objectmapper.example.core.product.dto.ProductDTO;
import crud.objectmapper.example.core.product.entity.ProductEntity;
import crud.objectmapper.example.core.product.service.ProductService;
import crud.objectmapper.example.utils.utils.RequestDTO;
import crud.objectmapper.example.utils.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<ProductDTO> listAllProducts(){
        return productService.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Transactional
    public ResponseDTO<ProductDTO> createProduct (@RequestDTO(ProductDTO.class) @Validated @RequestBody ProductEntity product){
        return ResponseDTO.accepted().convertTo(productService.createProduct(product), ProductDTO.class);
    }


    @GetMapping("{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }


    @PutMapping("update/{id}")
    public ResponseEntity<ProductEntity> updateProductById(@PathVariable("id") Long productId, @RequestBody @Validated ProductEntity product) throws Exception {
        return  ResponseEntity.ok(productService.updateProductById(productId, product));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ProductEntity> deleteProductById(@PathVariable("id") Long productID){
        return ResponseEntity.ok(productService.deleteProduct(productID));
    }

}