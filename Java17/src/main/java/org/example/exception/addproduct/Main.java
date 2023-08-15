package org.example.exception.addproduct;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Q2.a
        List<Product> products = List.of(
                new Product("F523", "Tomato", "Food", 1.5, 589),
                new Product("A763", "Zara shirt", "Appearance", 12.0, 90),
                new Product("H320", "Kitchen table", "Household", 299.0, 13),
                new Product("E092", "IPhone", "Electronic", 1000.0, 4),
                new Product("S108", "Football", "Sport", 19.9, 2)
        );
        System.out.println(products);
        System.out.println("--------------------------------------------------");
        // Q2.b
        Order mtOrder = new Order();
        mtOrder.setCustomerName("Mike Tyson");
        mtOrder.setTransactionTime(LocalDateTime.of(2023, 8, 8, 11, 30, 0));
        // Add 5 "Tomato" into the order (note index: F523=0, A763=1, H320=2, E092=3, S108=4)
        System.out.println("Adding 5 \"Tomato\" into the order...");
        boolean res = mtOrder.addProduct(products.get(0), 5);
        System.out.println("Addition result: " + res + " - total cost: " + mtOrder.cost());
        System.out.println("--------------------------------------------------");
        // Add 2 "IPhone" into the order (note index: F523=0, A763=1, H320=2, E092=3, S108=4)
        System.out.println("Adding 2 \"IPhone\" into the order...");
        res = mtOrder.addProduct(products.get(3), 2);
        System.out.println("Addition result: " + res + " - total cost: " + mtOrder.cost());
        System.out.println("--------------------------------------------------");
        // Add 4 "Football" into the order (note index: F523=0, A763=1, H320=2, E092=3, S108=4)
        System.out.println("Adding 4 \"Football\" into the order...");
        try {
            res = mtOrder.addProduct(products.get(4), 4);
            System.out.println("Addition result: " + res + " - total cost: " + mtOrder.cost());
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("An error encounted while adding product (" + e + ") - this product will not be added.");

        }
        System.out.println("--------------------------------------------------");
        System.out.println(mtOrder.getCustomerName() + "'s Order (" + mtOrder.getTransactionTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) + ")");
        System.out.println(mtOrder.getLineItems());
        System.out.println("Total cost: " + mtOrder.cost());
        System.out.println("--------------------------------------------------");
        // Q2.c
        DeliveryOrder ceOrder = new DeliveryOrder();
        ceOrder.setCustomerName("ChrisEvans");
        ceOrder.setTransactionTime(LocalDateTime.of(2023, 8, 9, 13, 14, 0));
        // Add 3 "Zara shirt" into the order (note index: F523=0, A763=1, H320=2, E092=3, S108=4)
        System.out.println("Adding 3 \"Zara shirt\" into the order...");
        res = ceOrder.addProduct(products.get(1), 3);
        System.out.println("Addition result: " + res + " - total cost: " + ceOrder.cost());
        System.out.println("--------------------------------------------------");
        // Add 3 "IPhone" into the order (note index: F523=0, A763=1, H320=2, E092=3, S108=4)
        System.out.println("Adding 3 \"IPhone\" into the order...");
        try {
            res = ceOrder.addProduct(products.get(3), 3);
            System.out.println("Addition result: " + res + " - total cost: " + ceOrder.cost());
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("An error encounted while adding product (" + e + ") - this product will not be added.");
        }
        System.out.println("--------------------------------------------------");
        System.out.println(ceOrder.getCustomerName() + "'s Order (" + ceOrder.getTransactionTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) + ")");
        System.out.println(ceOrder.getLineItems());
        System.out.println("Total cost: " + ceOrder.cost());
        System.out.println("--------------------------------------------------");
        System.out.println("The Stunts 23, a Master Events Original - Diamond Sponsors: Red Bull, HP, Apple, Samsung, LoL Esports");
        System.out.println("(c) 2023 Master Group. All rights reserved.");
    }
}
