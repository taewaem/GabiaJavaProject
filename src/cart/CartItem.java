package cart;

import product.Product;

public class CartItem {

    private Product product;

    private int quantity;

//    private User user;


//    public CartItem(Product product, int quantity, User user) {
//        this.product = product;
//        this.quantity = quantity;
//        this.user = user;
//    }
//
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
