package com.mycompany.connor_murray_a1.model;

import java.util.Random;

/**
 *
 * @author Conman
 */
public class PizzaOrder {
    
   

    private String firstName, phoneNumber;

    private String[] toppings;
    private String size;

    private boolean delivery;

    public PizzaOrder() {
        toppings = getToppings();
        size = getSize();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        toppings = this.toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        size = this.size;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean getDelivery() {
        return delivery;
    }

    public double RandomDouble() {
        Random gen = new Random(System.currentTimeMillis());
        double randomDouble = gen.nextDouble() * 0.5;
        return randomDouble;
    }

    public double getPrice(String size, boolean delivery, String[] toppings) {
       double price = 0;
       if (size.equalsIgnoreCase("small")) {
            price += 5;
        } else if (size.equalsIgnoreCase("medium")) {
            price += 7;
        } else if (size.equalsIgnoreCase("large")) {
            price += 9;
        } else {
            price += 0;
        }
        if (delivery = true) {
            price += 2;
        } else {
            price += 0;
        }
        for(int i = 0; i < toppings.length; i++) {
            price++;
        }

        return price;
    }
}
