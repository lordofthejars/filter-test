package org.acme.testgen.restassured;

import com.squareup.javapoet.MethodSpec;
import org.acme.testgen.LoggedCall;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import javax.ws.rs.HttpMethod;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestAssureCallTemplateTest {

    @Test
    public void should_generate_rest_assured_statements_for_get_path() {
        RestAssureCallTemplate template = new RestAssureCallTemplate();
        MethodSpec.Builder testBuilder = MethodSpec.methodBuilder("my_get_test_method");
        template.call(testBuilder, new LoggedCall(HttpMethod.GET,
                "/api",
                Collections.emptyMap(), Collections.emptyMap(), "", "",
                HttpStatus.SC_OK));

        String code = testBuilder.build().code.toString();

        assertEquals("when().get(\"/api\").then().statusCode(200);", code.trim());
    }
}
