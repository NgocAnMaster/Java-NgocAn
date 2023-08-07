import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String text = "xin chao moi nguoi";
//        String capitalized = StringUtils.capitalize(text);
//        System.out.println(capitalized);
//
//        String capitalized2 = WordUtils.capitalizeFully(text);
//        System.out.println(capitalized2);
//
//        List<Integer> integers = List.of(9, 6, 8, 1, 5);
//        List<Integer> integers1 = List.of(5, 6, 7, 8);
//        List<Integer> union = ListUtils.union(integers, integers1);
//        System.out.println(union);
    String name = "khoi";
    String school = "fpt";

//        Student student = new Student("khoi", "fpt", LocalDate.of(2000,1,1));
//        new Student();
//    student.getName();

        Student student = Student.builder()
                .name(name)
                .school(school)
                .dob(LocalDate.of(2000,1,1))
                .password("pass")
                .build();

    }
}
