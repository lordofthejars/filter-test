package org.acme.testgen;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public class LoggedCall {
    private final String method;
    private final String path;
    private final Map<String, String> headers;
    private final Map<String, Object> parameters;
    private final InputStream body;
    private final InputStream expectedOutput;
    private final int status;

    public LoggedCall(String method,
                      String path,
                      Map<String, String> headers,
                      Map<String, Object> parameters,
                      InputStream body,
                      InputStream expectedOutput,
                      int status) {
        this.method = method;
        this.path = path;
        this.headers = headers;
        this.parameters = parameters;
        this.body = body;
        this.expectedOutput = expectedOutput;
        this.status = status;
    }

    public LoggedCall(String method,
                      String path,
                      Map<String, String> headers,
                      Map<String, Object> parameters,
                      String body,
                      String expectedOutput,
                      int status) {
        this(method, path, headers, parameters,
                new ByteArrayInputStream(body.getBytes()),
                new ByteArrayInputStream(expectedOutput.getBytes()), status);
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public InputStream getBody() {
        return body;
    }

    public InputStream getExpectedOutput() {
        return expectedOutput;
    }

    public int getStatus() {
        return status;
    }
}
