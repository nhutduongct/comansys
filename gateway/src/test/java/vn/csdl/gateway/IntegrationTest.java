package vn.csdl.gateway;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import vn.csdl.gateway.ComansysgatewayApp;
import vn.csdl.gateway.config.TestSecurityConfiguration;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { ComansysgatewayApp.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
}
