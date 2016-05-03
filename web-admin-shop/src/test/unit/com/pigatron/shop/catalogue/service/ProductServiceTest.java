package com.pigatron.shop.catalogue.service;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.pigatron.shop.catalogue.entity.Product.ProductBuilder.aProduct;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @Before
    public void setup() {
        productService = new ProductService(productRepository);
    }

    @Test
    public void testGenerateUrlKey() {
        Product product = aProduct().id("1").name("Product Name").build();
        productService.generateUrlKey(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name");
    }

    @Test
    public void testGenerateUrlKey2() {
        Product product = aProduct().id("1").name("Product Name").build();
        given(productRepository.findByUrlKey("product_name")).willReturn(aProduct().id("2").build());
        productService.generateUrlKey(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name2");
    }

    @Test
    public void testGenerateUrlKey3() {
        Product product = aProduct().id("1").name("Product Name").build();
        given(productRepository.findByUrlKey("product_name")).willReturn(aProduct().id("2").build());
        given(productRepository.findByUrlKey("product_name2")).willReturn(aProduct().id("3").build());
        productService.generateUrlKey(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name3");
    }

    @Test
    public void testGenerateUrlKeySameProduct() {
        Product product = aProduct().id("1").name("Product Name").build();
        given(productRepository.findByUrlKey("product_name")).willReturn(product);
        productService.generateUrlKey(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name");
    }

}
