package com.pigatron.web.admin.security.test.endpoint;

import com.pigatron.TestApplication;
import com.pigatron.web.admin.security.test.AbstractAdminSecurityIntegrationTest;
import com.pigatron.web.security.entity.User;
import com.pigatron.web.security.repository.UserRepository;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest
public class UserEndpointTest extends AbstractAdminSecurityIntegrationTest {

    private static final String API_URL = "/security/user";
    private static final String SETUP_USERNAME = "test_username";
    private static final String SETUP_PASSWORD = "test_password";


    @Autowired
    private UserRepository userRepository;

    @Before
    @Override
    public void setup() {
        super.setup(API_URL);
    }

    @Test
    public void testAdminSaveUser() {
        User user = createUser();

        String id = given()
            .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
            .contentType(CONTENTTYPE_APPLICATION_JSON)
            .body(user)
        .when()
            .post(adminApiUrl)
        .then()
            .log().all()
            .statusCode(HttpStatus.SC_CREATED)
            .body("username", equalTo(SETUP_USERNAME))
            .extract().path("id");

        User savedUser = userRepository.findOne(id);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo(SETUP_USERNAME);
        assertThat(savedUser.getPassword()).isNotEqualTo(SETUP_PASSWORD);
        assertThat(savedUser.isEnabled()).isTrue();
    }

    @Test
    public void testAdminGetUsers() {
        //TODO
    }


    private User createUser() {
        return new User(SETUP_USERNAME, SETUP_PASSWORD, "ADMIN");
    }

}
