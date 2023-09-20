package org.example.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainDom {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("class.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        NodeList students = doc.getElementsByTagName("student");
        System.out.println(students.getLength());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < students.getLength(); i++) {
            Node student = students.item(i);
            Element studentElement = (Element) student;
            String idString = studentElement.getElementsByTagName("id").item(0).getTextContent();
            int id = Integer.parseInt(idString);
            String firstName = studentElement.getElementsByTagName("firstname").item(0).getTextContent();
            String lastName = studentElement.getElementsByTagName("lastname").item(0).getTextContent();
            String subject = studentElement.getElementsByTagName("subject").item(0).getTextContent();
            String marksString = studentElement.getElementsByTagName("marks").item(0).getTextContent();
            int marks = Integer.parseInt(marksString);
//            studentList.add(new Student(id, firstName, lastName, subject, marks));
        }

//        List<School> schools = new ArrayList<>();
//        schools.add(new School(studentList));
//        System.out.println(schools);

        School school = new School();
        school.setStudents(studentList);
        System.out.println(school);
    }
}
