package org.acme.testgen;


import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import javax.ws.rs.HttpMethod;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMapperTest {

    public static TestMapper mapper = new TestMapper();

    @Test
    public void should_return_a_simple_get_path() {
        String methodName = mapper.toTestMethod(
                new LoggedCall(HttpMethod.GET, "/api", Collections.emptyMap(),
                Collections.emptyMap(), "", "", HttpStatus.SC_OK));

        assertEquals("should_get_api", methodName);
    }

    @Test
    public void should_return_a_composite_get_path() {
        String methodName = mapper.toTestMethod(
                new LoggedCall(HttpMethod.GET, "/api/doc", Collections.emptyMap(),
                        Collections.emptyMap(), "", "", HttpStatus.SC_OK));
        assertEquals("should_get_api_doc", methodName);
    }

    @Test
    public void should_support_root_paths() {
        String methodName = mapper.toTestMethod(
                new LoggedCall(HttpMethod.GET, "/", Collections.emptyMap(),
                        Collections.emptyMap(), "", "", HttpStatus.SC_OK));

        assertEquals("should_get", methodName);
    }
}
