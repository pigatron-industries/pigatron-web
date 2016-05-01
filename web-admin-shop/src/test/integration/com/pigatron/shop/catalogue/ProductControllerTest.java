package com.pigatron.shop.catalogue;

import com.pigatron.AbstractIntegrationTest;
import com.pigatron.TestApplication;
import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.pigatron.shop.catalogue.entity.Product.ProductBuilder.aProduct;
import static com.pigatron.shop.catalogue.entity.option.SelectProduct.SelectProductBuilder.aSelectProduct;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest
public class ProductControllerTest extends AbstractIntegrationTest {

    private static final String API_URL = "/catalogue/product";

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() {
        super.setup(API_URL);
    }

    @Test
    public void testGetIsOptionFalse() {
        createProductWithOption();
        when()
            .get(publicApiUrl + "?isOption=false")
        .then()
            .body("", hasSize(1))
            .body("[0].name", equalTo("Main Product"));
    }

    @Test
    public void testGetIsOptionTrue() {
        createProductWithOption();
        when()
            .get(publicApiUrl + "?isOption=true")
        .then()
            .body("", hasSize(1))
            .body("[0].name", equalTo("Option Product"));
    }

    @Test
    public void testGetHasOptionsFalse() {
        createProductWithOption();
        when()
            .get(publicApiUrl + "?hasOptions=false")
        .then()
            .body("", hasSize(1))
            .body("[0].name", equalTo("Option Product"));
    }

    @Test
    public void testGetHasOptionsTrue() {
        createProductWithOption();
        when()
            .get(publicApiUrl + "?hasOptions=true")
        .then()
            .log().all()
            .body("", hasSize(1))
            .body("[0].name", equalTo("Main Product"));
    }


    private Product createProductWithOption() {
        Product optionProduct =
                aProduct()
                .name("Option Product")
                .urlKey("option_product")
                .sku("op")
                .isOption(true)
                .build();
        Product mainProduct =
                aProduct()
                .name("Main Product")
                .urlKey("main_product")
                .sku("mp")
                .option(aSelectProduct()
                        .name("Select Product")
                        .product(optionProduct)
                        .build())
                .build();
        productRepository.save(optionProduct);
        productRepository.save(mainProduct);
        return mainProduct;
    }

}
