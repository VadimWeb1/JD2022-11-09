package by.it.vasileuskaya.jd02_03.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    Customer customer;
    public List<Good> goodsInCart;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.goodsInCart = new ArrayList<>();
    }

    public int addToCart(Good good) {
        goodsInCart.add(good);
        return goodsInCart.size();
    }
}
