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
        return mDAO.fetchTrendingProducts();
    }

    public ArrayList<Product> fetchProductsByText(final String text) {
        return mDAO.fetchProductsByText(text);
    }
}
