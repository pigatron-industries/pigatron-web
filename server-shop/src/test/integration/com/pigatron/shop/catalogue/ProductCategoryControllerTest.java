package com.pigatron.shop.catalogue;

import com.pigatron.AbstractIntegrationTest;
import com.pigatron.TestApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest
public class ProductCategoryControllerTest extends AbstractIntegrationTest {

    private static final String API_URL = "/catalogue/category";

    @Before
    public void setup() {
        super.setup(API_URL);
    }

    @Test
    public void testPublicGetRoot() {
        when()
            .get(publicApiUrl + "/root")
        .then()
            .log().all()
            .body("id", equalTo("root"))
            .body("name", equalTo("Shop"));
    }

    @Test
    public void testAdminGetRoot() {
        given()
            .auth().basic("admin", "password")
        .when()
            .get(adminApiUrl + "/root")
        .then()
            .log().all()
            .body("id", equalTo("root"))
            .body("name", equalTo("Shop"));
    }

}
