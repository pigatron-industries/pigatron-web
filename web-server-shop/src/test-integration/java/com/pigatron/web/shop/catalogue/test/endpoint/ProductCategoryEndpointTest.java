package com.pigatron.web.shop.catalogue.test.endpoint;

import com.pigatron.TestApplication;
import com.pigatron.web.admin.security.test.AbstractAdminSecurityIntegrationTest;
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
public class ProductCategoryEndpointTest extends AbstractAdminSecurityIntegrationTest {

    private static final String API_URL = "/catalogue/category";

    @Before
    @Override
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
            .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
        .when()
            .get(adminApiUrl + "/root")
        .then()
            .log().all()
            .body("id", equalTo("root"))
            .body("name", equalTo("Shop"));
    }

    @Test
    public void testAdminCreateCategory() {
        //TODO
    }

}
