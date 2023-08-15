package org.example.exception.addproduct;

public class OutOfStockException extends RuntimeException{
    public OutOfStockException() {
        super("Stock not enough");
    }
}
