package com.renaro.happypool.products.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class ProductBO {

    private final ProductDAO mDAO;

    public ProductBO(final ProductDAO registerDAO) {
        mDAO = registerDAO;
    }

    public List<Product> fetchTrendingProducts() {
        List<Product> products = mDAO.fetchTrendingProducts();
        ArrayList<Product> result = updateProductsOldPrices(products);
        return result;
    }

    public ArrayList<Product> fetchProductsByText(final String text) {
        ArrayList<Product> products = mDAO.fetchProductsByText(text);
        ArrayList<Product> result = updateProductsOldPrices(products);
        return result;
    }


    /*
    * If the older price of this item is lower than current price, I don't want that the
    * old price be visible to the user, so I will set it to zero.
    * This is just an example of what kind o logic the BO should hold.
    * I don't want to change the current list I have, the Immutability principle states that I should create a
    * new object/list instead.
    * */
    ArrayList<Product> updateProductsOldPrices(final List<Product> products) {
        ArrayList<Product> output = new ArrayList<>();
        if (products.isEmpty()) {
            return output;
        }
        for (final Product product : products) {
            if (product.getOldPrice() < product.getPrice()) {
                output.add(new Product(product.getTitle(), product.getDescription(), product.getPrice(), 0f, product.getImages()));
            } else {
                output.add(new Product(product.getTitle(), product.getDescription(), product.getPrice(), product.getOldPrice(), product.getImages()));
            }
        }
        return output;
    }
}
