package com.pigatron.shop.catalogue;

import com.pigatron.TestApplication;
import com.pigatron.admin.security.AbstractAdminSecurityIntegrationTest;
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
import static com.pigatron.shop.catalogue.entity.Product.ProductBuilder.aProduct;
import static com.pigatron.shop.catalogue.entity.option.SelectProduct.SelectProductBuilder.aSelectProduct;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest
public class ProductControllerTest extends AbstractAdminSecurityIntegrationTest {

    private static final String API_URL = "/catalogue/product";

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() {
        super.setup(API_URL);
    }

    @Test
    public void testAdminGetIsOptionFalse() {
        createProductWithOption();
        given()
                .auth().basic("admin", "password")
        .when()
                .get(adminApiUrl + "?isOption=false")
        .then()
                .log().all()
                .body("", hasSize(1))
                .body("[0].name", equalTo("Main Product"));
    }

    @Test
    public void testAdminGetIsOptionTrue() {
        createProductWithOption();
        given()
                .auth().basic("admin", "password")
        .when()
                .get(adminApiUrl + "?isOption=true")
        .then()
                .log().all()
                .body("", hasSize(1))
                .body("[0].name", equalTo("Option Product"));
    }

    @Test
    public void testAdminGetHasOptionsFalse() {
        createProductWithOption();
        given()
                .auth().basic("admin", "password")
        .when()
                .get(adminApiUrl + "?hasOptions=false")
        .then()
                .log().all()
                .body("", hasSize(1))
                .body("[0].name", equalTo("Option Product"));
    }

    @Test
    public void testAdminGetHasOptionsTrue() {
        createProductWithOption();
        given()
                .auth().basic("admin", "password")
        .when()
                .get(adminApiUrl + "?hasOptions=true")
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
