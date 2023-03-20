/**
 * Name: Jisoo Kang
 * Campus: Trafalgar Campus
 * Assignment1
 * Date: May 18, 2022
 * Student #: 991636291
 */
import java.util.Scanner;

public class Product {

    int itemQty;
    String itemName;
    double itemPrice;

    // Accessor methods

    public int getItemQty() {
        return itemQty;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    // Mutator methods

    public void setItemQty(int itemQty) throws Exception {
        if (itemQty == 0)
            throw new Exception("Item Price can't be 0.");
        this.itemQty = itemQty;
    }

    public void setItemName(String itemName) throws Exception {
        if (itemName == null || itemName.equals(""))
            throw new Exception("Item name can't be empty.");

        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) throws Exception {
        if (itemPrice == 0)
            throw new Exception("Item Price can't be 0.");
        this.itemPrice = itemPrice;
    }

    public double calcTotal(int itemQty) {
        return (itemQty * itemPrice) / this.itemQty;
    }
    public String toString() {
        return itemName + " : " +
                itemQty + " for $" + itemPrice;
    }
}

