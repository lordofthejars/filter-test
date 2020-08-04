package org.acme.testgen;

import com.squareup.javapoet.MethodSpec;

public interface TestClassTemplate {

    MethodSpec buildTest(LoggedCall call, RestCallTemplate callTemplate);
}
