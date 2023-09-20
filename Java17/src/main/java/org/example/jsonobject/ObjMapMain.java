package org.example.jsonobject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjMapMain {
    public static void main(String[] args) throws JsonProcessingException {
        String json = """
                {"students":[{"id":1,"name":"Tho","dob":"1990-01-01"},{"id":2,"name":"Son","dob":"2001-01-01"},{"id":3,"name":"An","dob":"2002-01-01"},{"id":4,"name":"Binh","dob":"2001-01-01"},{"id":5,"name":"Dat","dob":"2004-01-01"},{"id":6,"name":"Huy","dob":"2006-01-01"},{"id":7,"name":"Dao","dob":"2010-01-01"}]}""";

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        Users users = mapper.readValue(json, Users.class);

        System.out.println(users);
    }
}
