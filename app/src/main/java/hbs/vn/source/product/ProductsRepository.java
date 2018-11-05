package hbs.vn.source.product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import hbs.vn.model.Product;

public class ProductsRepository {

    public List<Product> getProducts() {
        List products = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Product item = new Product(i, "title", "description", "thumbnail", true);
            products.add(item);
        }
        return products;
    }

    public Product like(Product product) {
        // TODO: 2018/10/20 Network processing
        product.liked = true;
        return product;
    }

    public Product unlike(Product product) {
        // TODO: 2018/10/20 Network processing
        product.liked = false;
        return product;
    }
}