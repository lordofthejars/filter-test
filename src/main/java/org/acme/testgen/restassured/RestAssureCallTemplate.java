package org.acme.testgen.restassured;

import com.squareup.javapoet.MethodSpec;
import org.acme.testgen.LoggedCall;
import org.acme.testgen.RestCallTemplate;

public class RestAssureCallTemplate implements RestCallTemplate {

    @Override
    public void call(MethodSpec.Builder test, LoggedCall loggedCall) {
        StringBuffer statement = new StringBuffer()
                .append("when().get(\"").append(loggedCall.getPath()).append("\").")
                .append("then().statusCode(").append(loggedCall.getStatus()).append(")");
        test.addStatement(statement.toString());
    }
}
