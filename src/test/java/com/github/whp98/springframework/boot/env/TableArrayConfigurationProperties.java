package com.github.whp98.springframework.boot.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author whp98
 */
@Component
@ConfigurationProperties(prefix = "")
public class TableArrayConfigurationProperties {
    private Object products;

    public Object getProducts() {
        return products;
    }

    public void setProducts(Object products) {
        this.products = products;
    }
}
