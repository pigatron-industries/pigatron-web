package com.pigatron.cms.content.test.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pigatron.TestApplication;
import com.pigatron.web.admin.security.test.AbstractAdminSecurityIntegrationTest;
import com.pigatron.web.cms.content.entity.Page;
import com.pigatron.web.cms.content.repository.ContentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.pigatron.web.cms.content.entity.Page.Builder.aPage;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest
public class ContentEndpointTest extends AbstractAdminSecurityIntegrationTest {

    private static final String API_URL = "/cms/content";
    private static final String SETUP_PAGE_URLKEY = "page_url";
    private static final String SETUP_PAGE_TITLE = "Page Title";
    private static final String SETUP_PAGE_CONTENT = "<p>Page Content</p>";

    @Autowired
    private ContentRepository contentRepository;

    @Before
    @Override
    public void setup() {
        super.setup(API_URL);
    }

    @Test
    public void testAdminCreatePage() {
        String id = given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(CONTENTTYPE_APPLICATION_JSON)
                .body(createPage())
        .when()
                .post(adminApiUrl)
        .then()
                .log().all()
                .body("id", notNullValue())
                .body("type", equalTo("Page"))
                .body("urlKey", equalTo(SETUP_PAGE_URLKEY))
                .body("title", equalTo(SETUP_PAGE_TITLE))
                .body("content", equalTo(SETUP_PAGE_CONTENT))
                .extract().path("id");

        Page savedPage = (Page)contentRepository.findOne(id);
        assertThat(savedPage).isNotNull();
        assertThat(savedPage.getUrlKey()).isEqualTo(SETUP_PAGE_URLKEY);
        assertThat(savedPage.getTitle()).isEqualTo(SETUP_PAGE_TITLE);
        assertThat(savedPage.getContent()).isEqualTo(SETUP_PAGE_CONTENT);
    }

    @Test
    public void testAdminGetPageById() {
        Page page = createPage();
        contentRepository.save(page);
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
        .when()
                .get(adminApiUrl + "/{id}", page.getId())
        .then()
                .log().all()
                .body("id", equalTo(page.getId()));
    }

    @Test
    public void testPublicGetPageByUrlKey() throws JsonProcessingException {
        Page page = createPage();
        contentRepository.save(page);
        when()
            .get(publicApiUrl + "/page?urlKey={urlKey}", SETUP_PAGE_URLKEY)
        .then()
            .log().all()
            .body("id", equalTo(page.getId()))
            .body("type", equalTo("Page"))
            .body("content", equalTo(SETUP_PAGE_CONTENT))
            .body("urlKey", equalTo(SETUP_PAGE_URLKEY))
            .body("title", equalTo(SETUP_PAGE_TITLE));

    }

    private Page createPage() {
        return aPage()
                .withUrlKey(SETUP_PAGE_URLKEY)
                .withTitle(SETUP_PAGE_TITLE)
                .withContent(SETUP_PAGE_CONTENT)
                .withEnabled(true)
                .build();
    }

}
