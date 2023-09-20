package org.example.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class MainJackson {
    public static void main(String[] args) throws IOException {
        File file = new File("class.xml");
        XmlMapper mapper = new XmlMapper();
        School school = mapper.readValue(file, School.class);
        System.out.println(school);
    }
}
