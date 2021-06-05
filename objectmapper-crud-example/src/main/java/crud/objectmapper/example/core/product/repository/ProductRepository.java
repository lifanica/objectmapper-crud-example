package crud.objectmapper.example.core.product.repository;


import crud.objectmapper.example.core.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;



@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

     default ProductEntity create(ProductEntity product){
          product.setCreatedBy(1l);
          product.setCreationDate(LocalDateTime.now());
          return this.save(product);
     }

     default ProductEntity update(ProductEntity product) throws Exception {
          if (product.getId() == null) {
               throw new Exception("Product does not existe");
          }

          product.setUpdateDate(LocalDateTime.now());

          return this.save(product);
     }



}
