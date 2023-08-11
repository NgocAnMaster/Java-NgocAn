package org.example.storesearch;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Inventory {
    private String sku;
    private Integer quantity;
    private String storeCode;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public Inventory(String sku, Integer quantity, String storeCode) {
        this.sku = sku;
        this.quantity = quantity;
        this.storeCode = storeCode;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "sku='" + sku + '\'' +
                ", quantity=" + quantity +
                ", storeCode='" + storeCode + '\'' +
                '}';
    }
}
