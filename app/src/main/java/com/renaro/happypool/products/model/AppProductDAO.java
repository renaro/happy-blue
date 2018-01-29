package com.renaro.happypool.products.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class AppProductDAO extends ProductDAO {

    @Override
    public List<Product> fetchTrendingProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Drone 4k", "This Drone is awesome! You have to buy it!", 645f, 690f, "https://www.parrot.com/global/sites/default/files/styles/product_teaser_hightlight/public/bebop_2_white.png?itok=K0RhDMwb"));
        products.add(new Product("Drone", "This Drone is great!", 345f, 370f,"https://images-americanas.b2w.io/produtos/01/00/sku/24400/2/24400290_1SZ.jpg" ));
        products.add(new Product("Water Drone", "This drone is waterprof", 444f, 450f,"https://images-americanas.b2w.io/produtos/01/00/sku/26997/5/26997570_2SZ.jpg"));
        products.add(new Product("Drone 1km", "The is the most incredible drone you will see!", 800f, 1000f,"https://images-americanas.b2w.io/produtos/01/00/sku/26997/5/26997570_3SZ.jpg"));
        return products;
    }
}
