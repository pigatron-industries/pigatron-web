package com.pigatron.shop.catalogue;

import com.pigatron.TestApplication;
import com.pigatron.admin.security.AbstractAdminSecurityIntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest
public class ProductCategoryControllerTest extends AbstractAdminSecurityIntegrationTest {

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
