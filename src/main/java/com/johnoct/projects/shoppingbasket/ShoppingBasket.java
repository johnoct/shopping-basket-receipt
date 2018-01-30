package com.johnoct.projects.shoppingbasket;

/**
 * @author John Octubre
 * @date 1/28/2018
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shopping Basket
 *
 */
public class ShoppingBasket {

    // Sales tax percentage for everything other than books, food, drugs
    private final int salesTax = 10;
    // Additional sales tax percentage for imported goods
    private final int importTax = 100;
    private double totalTax =  0.0;
    private double totalCost =  0.0;
    private Map<Item, Integer> itemBasket = new LinkedHashMap<Item, Integer>();

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     *  Add an item to the basket
     *
     *  @param item the item to be added to the basket
     *
     */
    public void addItem(Item item){

        // If the item is already in the basket, increment the quantity
        if (itemBasket.containsKey(item)){
            itemBasket.put(item, itemBasket.get(item) + 1);
        } else {
            itemBasket.put(item, 1);
        }
    }


    /**
     *  Calculate total tax in the shopping cart
     *
     *  @return the total tax of the items in the shopping cart
     */
    public double calcTotalTax(){

        for(Map.Entry<Item, Integer> entry : itemBasket.entrySet()){

            Item item = entry.getKey();
            int quantity = entry.getValue();

            int totalTaxPercentage = 0;

            if (item.isImported()) {
                totalTaxPercentage += this.importTax;
            }
            if (item.isTaxable()) {
                totalTaxPercentage += this.salesTax;
            }

            this.totalTax += quantity * (item.getItemPrice() * totalTaxPercentage/100.0);

        }
        return Math.round(this.totalTax * 100.0)/100.0;
    }

    /**
     *  Calculate total Cost in the shopping cart
     *
     *  @return the total cost of the items in the shopping cart
     */
    public double calcTotalCost(){

        for(Map.Entry<Item, Integer> entry : itemBasket.entrySet()){

            Item item = entry.getKey();
            int quantity = entry.getValue();

            totalCost += quantity * (item.getItemPrice());
        }

        totalCost += this.totalTax;

        return Math.round(totalCost * 20.0)/20.0;
    }

    /**
     *  Need to be able to get the map of the shopping cart for unit tests
     *
     *  @return the map of the items and their respective quantities in the shopping cart
     *
     */
    public Map<Item, Integer> getItemBasket(){
        return this.itemBasket;
    }

    /**
     *  Print the receipt
     *
     *  @return the string of the receipt
     *
     */
    public String getReceipt(){
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Item, Integer> entry : this.itemBasket.entrySet()){

            Item item = entry.getKey();
            Integer quantity = entry.getValue();

            sb.append(quantity + " " + item.getItemName() + " " + item.getItemPrice() + System.getProperty("line.separator"));

        }

        setTotalTax(calcTotalTax());
        setTotalCost(calcTotalCost());

        sb.append("Sales Tax: " + getTotalTax() + System.getProperty("line.separator"));
        sb.append("Total: " + getTotalCost());

        return sb.toString();
    }
}
