package com.renaro.happypool.products.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public abstract class ProductDAO {

    public abstract List<Product> fetchTrendingProducts();

    public abstract ArrayList<Product> fetchProductsByText(final String text);
}
