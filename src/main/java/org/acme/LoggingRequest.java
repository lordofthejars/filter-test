package org.acme;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class LoggingRequest implements ContainerRequestFilter {

    @Context
    UriInfo info;

    @Override
    public void filter(ContainerRequestContext context) {
        System.out.println("Path info " + info.getRequestUri() +" " + info.getQueryParameters());
        System.out.println(context.getMethod());
        System.out.println(context.getHeaders());
        System.out.println(context.getMediaType());
        System.out.println(context.getDate());

        try {
            InputStream entityStream = context.getEntityStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            entityStream.transferTo(baos);
            InputStream firstClone = new ByteArrayInputStream(baos.toByteArray()); 
            InputStream secondClone = new ByteArrayInputStream(baos.toByteArray()); 

            System.out.println(convertInputStreamToString(firstClone));
            context.setEntityStream(secondClone);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

}