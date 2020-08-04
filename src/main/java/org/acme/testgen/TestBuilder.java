package org.acme.testgen;

import org.acme.testgen.restassured.RestAssureCallTemplate;

public class TestBuilder {

    private RestCallTemplate restCaller;

    public TestBuilder() {
        withRestAssured();
    }

    public TestBuilder withRestAssured() {
        this.restCaller = new RestAssureCallTemplate();
        return this;
    }
}
