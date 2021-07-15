package vn.csdl.trackerapp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import vn.csdl.trackerapp.AbstractNeo4jIT;
import vn.csdl.trackerapp.TrackerappApp;
import vn.csdl.trackerapp.config.TestSecurityConfiguration;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { TrackerappApp.class, TestSecurityConfiguration.class })
@ExtendWith(AbstractNeo4jIT.class)
public @interface IntegrationTest {
}
