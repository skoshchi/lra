package io.narayana.lra.arquillian.appender;


import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.test.spi.enricher.resource.ResourceProvider;

import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CustomURLProvider implements ResourceProvider {

    @Override
    public boolean canProvide(Class<?> type) {
        return type.equals(URL.class);
    }

    @Override
    public Object lookup(ArquillianResource resource, Annotation... qualifiers) {
        try {
            return URI.create("http://localhost:8081/tck-test").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}