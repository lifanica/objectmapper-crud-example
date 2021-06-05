package crud.objectmapper.example.core.product.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import crud.objectmapper.example.core.product.entity.ProductEntity;
import crud.objectmapper.example.utils.utils.DTO;


@DTO
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {


    private String name;

    private String description;

    public ProductDTO(){
    }

    public ProductDTO(ProductEntity product){
        this.name = product.getName();
        this.description = product.getDescription();
    }

    public String getName() { return name;}

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
}