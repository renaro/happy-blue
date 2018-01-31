package com.renaro.happypool.products.model;

import com.renaro.happypool.network.BackendService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos1 on 30/01/18.
 */

public class FirebaseProductDAO extends ProductDAO {

    public static final int TIMEOUT = 30;
    private final BackendService mService;

    public FirebaseProductDAO(final BackendService backendService) {
        mService = backendService;
    }

    /*
    * retrieving products from a mocked server in Firebase I created.
    * I wanted to show how I usually do REST calls
    * */
    @Override
    public List<Product> fetchTrendingProducts() {
        ArrayList<Product> result = new ArrayList<>();
        try {
            List<FirebaseProduct> products = mService.getProducts().execute().body();
            if (products != null && !products.isEmpty()) {
                result.addAll(convertToProducts(products));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private ArrayList<Product> convertToProducts(final List<FirebaseProduct> products) {
        ArrayList<Product> result = new ArrayList<>();
        for (final FirebaseProduct firebaseProduct : products) {
            result.add(Product.from(firebaseProduct));
        }
        return result;
    }

    /*
    * I am mocking a search returning an specific item from my server, the idea is the same than retrieving many items
    * */
    @Override
    public ArrayList<Product> fetchProductsByText(final String text) {
        ArrayList<Product> result = new ArrayList<>();
        try {
            List<FirebaseProduct> products = mService.getProducts().execute().body();
            if (products != null && !products.isEmpty()) {
                ArrayList<FirebaseProduct> randomProducts = new ArrayList<>();
                randomProducts.add(products.get(2));
                result.addAll(convertToProducts(randomProducts));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
