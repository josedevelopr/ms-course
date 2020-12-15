package com.digitallab.store.product.repository;

import com.digitallab.store.product.entity.Category;
import com.digitallab.store.product.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest
{   @Autowired
    private ProductRepository productRepository;

    @Test
    public void  whenFindByCategoryReturnListOfProducts()
    {
        Product product01 = Product.builder().name("Computer")
                                            .category(Category.builder().id(1L).build())
                                            .description("")
                                            .stock(Double.parseDouble("10"))
                                            .price(Double.parseDouble("1240.99"))
                                            .status("Created")
                                            .createAt(new Date()).build();

        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        assertThat(founds.size()).isEqualTo(1);

    }
}
