package com.johnoct.projects.shoppingbasket;
import java.util.*;

/**
 * @author John Octubre
 * @date 2018-01-29
 */

/**
 * A model of an Item
 *
 */
public class Item {

    private String itemName;
    private double itemPrice;
    private boolean isImported;
    private boolean isTaxable;

    /**
     *  Initialize an Item
     *
     * @param itemName      the name of the item to be initialized
     * @param itemPrice     the price of the item to be initialized
     * @param isTaxable     is the item subject to base tax
     * @param isImported    is the item subject to import tax
     *
     */
    public Item(String itemName, double itemPrice, boolean isTaxable, boolean isImported){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isTaxable = isTaxable;
        this.isImported = isImported;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

}
