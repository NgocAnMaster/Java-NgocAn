package org.example.storesearch;

import org.apache.lucene.util.SloppyMath;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Zipcode> zipcodeList = List.of(
                Zipcode.builder()
                        .zip(20476)
                        .lng(104.294642)
                        .lat(30.238460)
                        .address("Hoan Kiem")
                        .build(),
                Zipcode.builder()
                        .zip(20235)
                        .lng(103.337631)
                        .lat(34.384635)
                        .address("Cau Giay")
                        .build(),
                Zipcode.builder()
                        .zip(20293)
                        .lng(101.303822)
                        .lat(22.403924)
                        .address("Xuan Mai")
                        .build(),
                Zipcode.builder()
                        .zip(20381)
                        .lng(103.394824)
                        .lat(20.394546)
                        .address("Xuan Thuy")
                        .build()
        );
        List<Store> stores = List.of(
                Store.builder().zip(20476).name("Adidas Hoan Kiem").address("").code("A1").build(),
                Store.builder().zip(20235).name("Nike Cau Giay").address("").code("A2").build(),
                Store.builder().zip(20293).name("Joma Xuan Mai").address("").code("A3").build(),
                Store.builder().zip(20381).name("Kappa Xuan Thuy").address("").code("A4").build()
        );
        List<Product> products = List.of(
                Product.builder().name("Quan").price(12400).sku("AB4").build(),
                Product.builder().name("Ao").price(24400).sku("AB5").build(),
                Product.builder().name("Giay").price(23500).sku("AB6").build()
        );
        List<Inventory> inventories = List.of(
                Inventory.builder().sku("AB4").quantity(4).storeCode("A1").build(),
                Inventory.builder().sku("AB6").quantity(2).storeCode("A4").build(),
                Inventory.builder().sku("AB4").quantity(11).storeCode("A2").build(),
                Inventory.builder().sku("AB4").quantity(0).storeCode("A1").build(),
                Inventory.builder().sku("AB5").quantity(0).storeCode("A3").build(),
                Inventory.builder().sku("AB6").quantity(8).storeCode("A3").build()
        );

        final Integer targetZipcode = 20235;
        final String targetSku = "AB4";

        //Q1
        Zipcode zipcode = zipcodeList.stream()
                .filter(zipcode1 -> zipcode1.getZip().equals(20235))
                .findFirst()
                .orElse(null);

        //Q2
        List<Zipcode> nearbyZipcodes = zipcodeList.stream()
                .filter(zip ->
                        SloppyMath.haversinMeters(
                                zip.getLat(), zip.getLng(),
                                zipcode.getLat(), zipcode.getLng()) <= 10000)
                .collect(Collectors.toList());

        //Q3
        List<Integer> nearbyZipCodeInteger = nearbyZipcodes.stream()
                .map(Zipcode::getZip)
                .collect(Collectors.toList());

        List<Store> nearbyStores = stores.stream()
                .filter(s -> nearbyZipCodeInteger.contains(s.getZip()))
                .collect(Collectors.toList());

        System.out.println(nearbyStores);

        //Q4
        List<String> storeCodes = stores.stream()
                .map(Store::getCode)
                .collect(Collectors.toList());
        List<Inventory> result = inventories.stream()
                .filter(i -> storeCodes.contains(i.getStoreCode()))
                .filter(i -> i.getSku().equals(targetSku))
                .filter(i -> i.getQuantity() > 0)
                .toList();
    }
}
