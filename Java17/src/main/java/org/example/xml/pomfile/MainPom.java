package org.example.xml.pomfile;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.xml.School;

import java.io.File;
import java.io.IOException;

public class MainPom {
    public static void main(String[] args) throws IOException {
        File file = new File("pom.xml");
        XmlMapper mapper = new XmlMapper();
        Project project = mapper.readValue(file, Project.class);
//        System.out.println(project);

        String pom = mapper.writeValueAsString(project);
        System.out.println(pom);
    }
}
