package org.acme.testgen;

public class TestMapper {

    private static String SLASH = "/";
    private static String SEPARATOR = "_";

    public String toTestMethod(LoggedCall call) {
        StringBuffer result = new StringBuffer("should")
                .append(SEPARATOR)
                .append(call.getMethod().toLowerCase());

       String path = call.getPath().toLowerCase().trim();

       if (!path.isEmpty() && !SLASH.equals(path)) {
           String methodName = path.replaceAll(SLASH, SEPARATOR);
           if (!methodName.startsWith(SEPARATOR)) {
               result = result.append(SEPARATOR);
           }

           result = result.append(methodName);
       }

       return result.toString();
    }
}
