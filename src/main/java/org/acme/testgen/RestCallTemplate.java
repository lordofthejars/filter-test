package org.acme.testgen;

import com.squareup.javapoet.MethodSpec;

public interface RestCallTemplate {

    public void call(MethodSpec.Builder test, LoggedCall assertion);
}
