package org.acme.testgen.junit5;

import com.squareup.javapoet.MethodSpec;
import org.acme.testgen.LoggedCall;
import org.acme.testgen.TestMapper;
import org.acme.testgen.RestCallTemplate;
import org.acme.testgen.TestClassTemplate;

public class Junit5TestCallTemplate implements TestClassTemplate {
    @Override
    public MethodSpec buildTest(LoggedCall call, RestCallTemplate callTemplate) {
        String methodName = new TestMapper().toTestMethod(call);
        MethodSpec.Builder builder = MethodSpec.methodBuilder(methodName);
        callTemplate.call(builder, call);
        return builder.build();
    }


}
