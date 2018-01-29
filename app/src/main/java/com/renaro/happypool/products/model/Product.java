package com.renaro.happypool.products.model;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class Product {
    private final String title;
    private final String description;
    private final double price;
    private final double oldPrice;
    private final String imageUrl;

    public Product(final String name, final String description, final double price, final double oldPrice, final String imageUrl) {
        this.title = name;
        this.description = description;
        this.price = price;
        this.oldPrice = oldPrice;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }
}
