package crud.objectmapper.example.core.product.service;

import crud.objectmapper.example.core.product.entity.ProductEntity;
import crud.objectmapper.example.core.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<ProductEntity> findAll() {

        return productRepository.findAll();
    }


    public ProductEntity findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public ProductEntity createProduct(ProductEntity product){
        return productRepository.create(product);
    }


    public ProductEntity updateProductById(Long productId, ProductEntity product) throws Exception {


        Optional<ProductEntity> optionalProduct = Optional.ofNullable(findProductById(productId));
        optionalProduct.orElseThrow(NoSuchElementException::new);
        ProductEntity productOld = optionalProduct.get();
        productOld.setName(product.getName());
        productOld.setDescription(product.getDescription());
        productRepository.update(productOld);
        return productOld;
    }

    public ProductEntity deleteProduct(Long productID) {
        ProductEntity product = findProductById(productID);
        productRepository.delete(product);
        return product;
    }
}