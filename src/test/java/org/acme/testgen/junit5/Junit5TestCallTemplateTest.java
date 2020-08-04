package org.acme.testgen.junit5;

import com.squareup.javapoet.MethodSpec;
import org.acme.testgen.LoggedCall;
import org.acme.testgen.restassured.RestAssureCallTemplate;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import javax.ws.rs.HttpMethod;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Junit5TestCallTemplateTest {

    @Test
    public void should_generate_a_test_method_per_call() {
        Junit5TestCallTemplate template = new Junit5TestCallTemplate();
        LoggedCall call = new LoggedCall(HttpMethod.GET, "/api",
                Collections.emptyMap(), Collections.emptyMap(), "", "", HttpStatus.SC_OK);
        MethodSpec generatedMethod = template.buildTest(call, new RestAssureCallTemplate());

        assertNotNull(generatedMethod);
        assertEquals("should_get_api", generatedMethod.name);
        assertNotNull(generatedMethod.code);
    }
}
