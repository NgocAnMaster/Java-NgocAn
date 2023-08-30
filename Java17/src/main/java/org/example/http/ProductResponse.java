package org.example.http;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private List<Product> products;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
