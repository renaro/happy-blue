package com.renaro.happypool.products.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class AppProductDAO extends ProductDAO {

    /*
        * Creating mocked products
        * */
    @Override
    public List<Product> fetchTrendingProducts() {
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<String> imagesProduct1 = new ArrayList<>();
        ArrayList<String> imagesProduct2 = new ArrayList<>();
        ArrayList<String> imagesProduct3 = new ArrayList<>();
        ArrayList<String> imagesProduct4 = new ArrayList<>();
        ArrayList<String> imagesProduct5 = new ArrayList<>();
        imagesProduct1.add("https://www.parrot.com/global/sites/default/files/styles/product_teaser_hightlight/public/bebop_2_white.png?itok=K0RhDMwb");
        imagesProduct2.add("https://i.ebayimg.com/images/g/~kIAAOSw-09aKOCv/s-l1600.jpg");
        imagesProduct3.add("https://i.ebayimg.com/images/g/d0QAAOSwXQZZc1eu/s-l500.jpg");
        imagesProduct4.add("https://images-americanas.b2w.io/produtos/01/00/sku/26997/5/26997570_3SZ.jpg");
        imagesProduct5.add("https://i.ebayimg.com/images/g/ooMAAOSwYIxX7l1f/s-l1600.jpg");

        products.add(new Product("Drone 4k", "This Drone is awesome! You have to buy it!", 645f, 690f, imagesProduct1));
        products.add(new Product("Blackview S8 4G Smartphone 5.7 Android OctaCore 4GB+64GB Unlocked Mobile Phone", "New: A brand-new, unused, unopened, undamaged item in its original packaging (where packaging is applicable). Packaging should be the same as what is found in a retail store, unless the item is handmade or was packaged by the manufacturer in non-retail packaging, such as an unprinted box or plastic bag. See the seller's listing for full details.", 345f, 370f, imagesProduct2));
        products.add(new Product("Mikasa 200 Volleyball For Indoor Olympic Game Official Ball Size 5 Blue/Yellow", "This ball was created for the club volleyball teams and players. \n" +
                "The new 8 panel swirl design gives players a larger surface area in which to touch and control the ball improving passes and sets. \n" +
                "1-year warranty.", 26.99f, 25f, imagesProduct3));
        products.add(new Product("Drone 1km", "The is the most incredible drone you will see!", 800f, 1000f, imagesProduct4));
        products.add(new Product("Waterproof Swiss Travel Backpack Men 15\"Laptop multifunction Outdoor School Bag", "\t\n" +
                "New with tags: A brand-new, unused, and unworn item (including handmade items) in the original packaging", 20f, 25f, imagesProduct5));
        return products;
    }

    @Override
    public ArrayList<Product> fetchProductsByText(final String text) {
        ArrayList<Product> products = new ArrayList<>();
        String image = "https://i.ebayimg.com/images/g/XiUAAOSwH-daKshn/s-l500.jpg";
        ArrayList<String> images = new ArrayList<>();
        images.add(image);
        products.add(new Product("Apple Watch Series 2 Nike+ 38mm Aluminum Case Black/Volt Sport Band - MP082LL/A", "New: A brand-new, unused, unopened, undamaged item in its original packaging ", 264.00f, 280f, images));
        return products;
    }
}
