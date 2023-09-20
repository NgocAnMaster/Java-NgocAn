package org.example.xml.products;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.xml.pomfile.Project;

import java.io.File;
import java.io.IOException;

public class ProductsMain {
    public static void main(String[] args) throws IOException {
        File file = new File("products.xml");
        XmlMapper mapper = new XmlMapper();
        Store store = mapper.readValue(file, Store.class);
//        System.out.println(project);

        String pom = mapper.writeValueAsString(store);
        System.out.println(pom);
    }
}
