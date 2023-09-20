package org.example.jsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        JSONObject jsonObject = new JSONObject("JSONSample.json");

        String json = """
                {
                  "users": [
                    {
                      "id": null,
                      "name": "Tho",
                      "dob": "1990-01-01"
                    },
                    {
                      "id": 2,
                      "name": "Son",
                      "dob": null
                    },
                    {
                      "id": 3,
                      "name": "An",
                      "dob": "2002-01-01"
                    },
                    {
                      "id": 4,
                      "name": "Binh",
                      "dob": "2001-01-01"
                    },
                    {
                      "id": 5,
                      "name": "Dat",
                      "dob": "2004-01-01"
                    },
                    {
                      "id": 6,
                      "name": "Huy",
                      "dob": "2006-01-01"
                    },
                    {
                      "id": 7,
                      "name": "Dao",
                      "dob": "2010-01-01"
                    }
                  ]
                }""";

        JSONObject jsonObject = new JSONObject(json);

        List<User> userList = new ArrayList<>();
        JSONArray studentsJson = jsonObject.getJSONArray("users");
        for (int i = 0; i < studentsJson.length(); i++) {
            JSONObject studentJson = studentsJson.getJSONObject(i);
            try {
                Integer id = studentJson.isNull("id") ? null : studentJson.getInt("id");
                String name = studentJson.isNull("name") ? null : studentJson.getString("name");
                LocalDate dob = studentJson.isNull("dob") ? null : LocalDate.parse(studentJson.getString("dob"));

                userList.add(new User(id, name, dob));
            } catch (Exception e) {
                System.err.println("An exception occurred while processing, record skipped - See below.");
                e.printStackTrace();
            }
        }

        System.out.println(userList);
    }
}
