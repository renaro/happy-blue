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
        products.add(new Product("Blackview S8 4G Smartphone 5.7 Android OctaCore 4GB+64GB Unlocked Mobile Phone", "New: A brand-new, unused, unopened, undamaged item in its original packaging (where packaging is applicable). Packaging should be the same as what is found in a retail store, unless the item is handmade or was packaged by the manufacturer in non-retail packaging, such as an unprinted box or plastic bag. See the seller's listing for full details.", 345f, 370f,"https://i.ebayimg.com/images/g/~kIAAOSw-09aKOCv/s-l1600.jpg" ));
        products.add(new Product("Mikasa 200 Volleyball For Indoor Olympic Game Official Ball Size 5 Blue/Yellow", "This ball was created for the club volleyball teams and players. \n" +
                "The new 8 panel swirl design gives players a larger surface area in which to touch and control the ball improving passes and sets. \n" +
                "The seams of the ball are adhered to the carcass trapping air in between the panels giving the ball a softer feel with out losing any of the balls explosive characteristics. \n" +
                "The microfiber cover has dimples on the surface allowing for the ball to fly truer through the air. \n" +
                "The eight panel spiral construction gives players more surface area to touch the ball allowing for better passing and set accuracy. \n" +
                "The panel adhesion process traps air below the panel giving the ball a softer feel with out losing any of its power. \n" +
                "The FIVB has adopted this ball as the official and exclusive ball of international competitions. \n" +
                "Official size and weight; Nylon wound bladder; \n" +
                "Composite cover. Blue/yellow; \n" +
                "1-year warranty.", 26.99f, 85f,"https://i.ebayimg.com/images/g/d0QAAOSwXQZZc1eu/s-l500.jpg"));
        products.add(new Product("Drone 1km", "The is the most incredible drone you will see!", 800f, 1000f,"https://images-americanas.b2w.io/produtos/01/00/sku/26997/5/26997570_3SZ.jpg"));
        products.add(new Product("Waterproof Swiss Travel Backpack Men 15\"Laptop multifunction Outdoor School Bag", "\t\n" +
                "New with tags: A brand-new, unused, and unworn item (including handmade items) in the original packaging", 20f, 25f,"https://i.ebayimg.com/images/g/ooMAAOSwYIxX7l1f/s-l1600.jpg"));
        return products;
    }

    @Override
    public ArrayList<Product> fetchProductsByText(final String text) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Apple Watch Series 2 Nike+ 38mm Aluminum Case Black/Volt Sport Band - MP082LL/A","New: A brand-new, unused, unopened, undamaged item in its original packaging ",264.00f,280f,"https://i.ebayimg.com/images/g/XiUAAOSwH-daKshn/s-l500.jpg"));
        return products;
    }
}
