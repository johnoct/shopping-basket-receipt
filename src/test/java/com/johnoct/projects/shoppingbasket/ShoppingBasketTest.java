package com.johnoct.projects.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

/**
 * @author John Octubre
 * @date 2018-01-29
 */

public class ShoppingBasketTest {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private ShoppingBasket cart;

    @Before
    public void setUp() throws Exception {

        item1 = new Item("imported bottle of perfume", 33.50, true,true);
        item2 = new Item("bottle of perfume", 19.99, true, false);
        item3 = new Item("packet of headache pills", 9,true,false);
        item4 = new Item("imported box of chocolates", 9.99, true, true);
        cart = new ShoppingBasket();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);
    }

    @Test
    public void addItem() {
        Item item5 = new Item("imported furniture", 399.99, true, true);
        ShoppingBasket testCart = new ShoppingBasket();
        testCart.addItem(item5);
        assertTrue(testCart.getItemBasket().containsKey(item5));
    }

    @Test
    public void calcTotalTax() {
        cart.getReceipt();
        assertEquals(50.74, cart.getTotalTax(),0);
    }

    @Test
    public void calcTotalCost() {
        cart.getReceipt();
        assertEquals(123.20, cart.getTotalCost(),0);
    }

    @Test
    public void getItemBasket() {
        Map<Item, Integer> basket = cart.getItemBasket();
        assertTrue(basket.containsKey(item4));
    }

    @Test
    public void getReceipt() {
        String expected = "1 imported bottle of perfume 33.5\n" +
                "1 bottle of perfume 19.99\n" +
                "1 packet of headache pills 9.0\n" +
                "1 imported box of chocolates 9.99\n" +
                "Sales Tax: 50.74\n" +
                "Total: 123.2";
        assertEquals(cart.getReceipt(),expected);

    }




}