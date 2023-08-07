package homework.studentconcat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatMain {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("David", 13, "EHS01T"),
                new Student("Alice", 11, "EHS01T"),
                new Student("Calvin", 12, "BDC23I"),
                new Student("Elsa", 14, "CSD14L"),
                new Student("Bob", 12, "BDC23I"),
                new Student("Fara", 16, "TOE38K"),
                new Student("Glee", 14, "BDC23I")
        );
        List<School> schools = List.of(
                new School("EHS01T", "Electric Hiven School", "147 Add Street"),
                new School("BDC23I", "BookDow Cooking School", "No.6 POS Road"),
                new School("CSD14L", "Clean Site Delivery School", "No.7 Le Brandt, District 6"),
                new School("TOE38K", "TOE School", "8th Floor, Newral Tower, Super Street")
        );
        // regular method
        List<ConcatClass> mergedStudents1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++){
            for (int j = 0; j < schools.size(); j++){
                if (students.get(i).getSchoolId() == schools.get(j).getSchoolId()){
                    mergedStudents1.add(new ConcatClass(students.get(i).getName(), students.get(i).getAge(), students.get(i).getSchoolId(), schools.get(j).getSchName(), schools.get(j).getAddress()));
                }
            }
        }
        System.out.println(mergedStudents1);
        // using stream API
        List<ConcatClass> mergedStudents = new ArrayList<>();
        mergedStudents = (List<ConcatClass>) Stream.of(students, schools).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(mergedStudents);
    }
}
