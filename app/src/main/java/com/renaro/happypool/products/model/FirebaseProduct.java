package com.renaro.happypool.products.model;

import java.util.List;

/**
 * Created by renarosantos1 on 30/01/18.
 */

public class FirebaseProduct {

    private final String title;
    private final String description;
    private final List<String> image_url;
    private final Double old_price;
    private final Double price;

    public FirebaseProduct(final String title, final String description,
                           final List<String> image_url, final Double old_price, final Double price) {
        this.title = title;
        this.description = description;
        this.image_url = image_url;
        this.old_price = old_price;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImage_url() {
        return image_url;
    }

    public Double getOld_price() {
        return old_price;
    }

    public Double getPrice() {
        return price;
    }
}

