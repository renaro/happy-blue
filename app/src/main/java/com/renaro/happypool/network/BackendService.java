package com.renaro.happypool.network;

import com.renaro.happypool.products.model.FirebaseProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public interface BackendService {
    @GET("products.json")
    Call<List<FirebaseProduct>> getProducts();
}
