package com.pigatron;

import com.pigatron.admin.security.test.AbstractAdminSecurityIntegrationTest;
import org.gradle.tooling.BuildLauncher;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest
public class RunFunctionalTests extends AbstractAdminSecurityIntegrationTest {

    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void runProtractorTests() {
        runProtractorTask();
    }

    private void runProtractorTask() {
        ProjectConnection connection = GradleConnector.newConnector()
                .forProjectDirectory(new File(".")).connect();
        BuildLauncher build = connection.newBuild();
        build.forTasks("protractorTests");
        build.setStandardOutput(System.out);
        build.run();
    }

}
