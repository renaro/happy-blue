package com.renaro.happypool.products.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by renarosantos1 on 30/01/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductBOtest {

    private ProductBO mProductBO;
    @Mock
    private ProductDAO mDAO;

    @Before
    public void setUp() throws Exception {
        mProductBO = new ProductBO(mDAO);
    }

    /*
    * I want to ensure I am not showing a older price that is cheaper than my current price
    * */
    @Test
    public void testIfOldPricesAreReplacedForZero() {
        ArrayList<Product> products = new ArrayList<>();
        //The old price for p1 should be replaced for 0
        products.add(new Product("p1", "", 15f, 12f, new ArrayList<String>()));
        products.add(new Product("p2", "", 15f, 19f, new ArrayList<String>()));
        ArrayList<Product> result = mProductBO.updateProductsOldPrices(products);
        //assert that p1 product old price has the value of 0
        assertEquals(0, (int)result.get(0).getOldPrice());
    }

    /*
     * I want to ensure I am not mistaken removing the old prices when they are correct
     * */
    @Test
    public void testIfCorrectOldPricesAreKept() {
        ArrayList<Product> products = new ArrayList<>();
        //The old price for p1 should be replaced for 0
        products.add(new Product("p1", "", 15f, 16f, new ArrayList<String>()));
        products.add(new Product("p2", "", 15f, 19f, new ArrayList<String>()));
        ArrayList<Product> result = mProductBO.updateProductsOldPrices(products);
        //assert that p1 product old price has the value of 0
        assertEquals(16, (int)result.get(0).getOldPrice());
    }
}
