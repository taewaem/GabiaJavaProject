package cart;

import product.Product;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart {

//    private List<CartItem> items = new ArrayList<>();
//
//    public void addNutrient(Product product, int quantity) {
//        for (CartItem item : items) {
//            if (item.getProduct().getId() == product.getId()) {
//                item.setQuantity(item.getQuantity() + quantity);
//                return;
//            }
//        }
//        items.add(new CartItem(product, quantity));
//    }
//
//    public void removeNutrientByName(String name) {
//        items.removeIf(item -> item.getProduct().getName().equals(name));
//    }
//
//    public void clear() {
//        items.clear();
//    }
//
//    public List<CartItem> getItems() {
//        return items;
//    }
//
//    public double getTotalPrice() {
//        return items.stream()
//                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
//                .sum();
//    }


    private List<CartItem> items = new ArrayList<>();
    private User user;

    public void addProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public void deleteProduct(Product product) {
        items.removeIf(item -> item.getProduct().getName().equals(product.getName()));
    }

    public void updateProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                System.out.println("수량 변경 전 " + item.getQuantity());
                item.setQuantity(quantity);
                System.out.println("수량 변경 후 " + item.getQuantity());
            }
        }
    }

    public void clear() {
        items.clear();
    }

    public List<CartItem> getItems() {
        return items;

    }

    public int getTotalPrice() {
        return items.stream()
                .mapToInt(item -> (int) (item.getProduct().getPrice() * item.getQuantity()))
                .sum();
    }
}
