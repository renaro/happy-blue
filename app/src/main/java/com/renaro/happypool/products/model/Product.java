package com.renaro.happypool.products.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class Product implements Serializable {
    private final String title;
    private final String description;
    private final double price;
    private final double oldPrice;
    private final List<String> images;

    public Product(final String title, final String description, final double price,
                   final double oldPrice, final List<String> images) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.oldPrice = oldPrice;
        this.images = images;
    }

    /*
        * This type of constructor is very useful when you know that classes is going to change.
        * So instead of passing, [5,6,7,...] parameters to construct a new Product we pass the object itself.
        * Then if changes are required, the method signature doesn't change
        * */
    public static Product from(final FirebaseProduct firebaseProduct) {
        return new Product(firebaseProduct.getTitle(), firebaseProduct.getDescription(),
                firebaseProduct.getPrice(), firebaseProduct.getOld_price(), firebaseProduct.getImage_url() );
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public List<String> getImages() {
        return images;
    }
}
