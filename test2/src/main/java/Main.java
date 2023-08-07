import org.example.Group;
import org.example.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("David", 13),
                new Student("Alice", 11),
                new Student("Calvin", 12),
                new Student("Elsa", 14),
                new Student("Bob", 12)
        );
//        Map<Integer, List<Student>> Sinhvientheotuoi = students.stream()
//                .collect(Collectors.groupingBy(s -> s.getAge()));
//        Map<Integer, List<String>> Sinhvientheotuoi = students.stream()
//                .collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toList())));
//
//        Sinhvientheotuoi.forEach((tuoi, danhsachten) -> {
//            System.out.println("Tuoi" + tuoi);
//            System.out.println("Danh sach ten " + danhsachten);
//        });
//        List<Group> groups = new ArrayList<>();
//
//        for (Student student : students){
//            boolean check = true;
//            for (Group group : groups){
//                if (group.getAge().equals(student.getAge())){
//                    group.getStudents().add(student);
//                    check = false;
//                    break;
//                }
//                if (check){
//                    List<Student> groupStudents = new ArrayList<>();
//                    groupStudents.add(student);
//                    groups.add(new Group(student.getAge(), groupStudents));
//                }
//            }
//        }
//        System.out.println(groups);

        //Tim danh sach student >= 12 tuoi



//        List<String> names = students.stream()
//                .map(s->s.getName())
//                .collect(Collectors.toList());
//
//        System.out.println(names);
//
//        List<String> studentOlderthan12 = students.stream()
//                .filter(s->s.getAge() >= 12)
//                .map(s->s.getName())
//                .collect(Collectors.toList());
//
//        System.out.println(studentOlderthan12);
//
//        OptionalInt maxOptional = students.stream()
//                .mapToInt(s -> s.getAge())
//                .max();
//
//        int maxAge = maxOptional.orElse(-1);
//        System.out.println(maxAge);

//    int sum = students.stream()
//            .mapToInt(s -> s.getAge())
//            .sum();
//        System.out.println(sum);

        Optional<Student> studentsAge12 = students.stream()
                .filter(s -> {
                    System.out.println(s.getName());
                    return s.getAge() == 12;
                })
                .findAny();

        System.out.println(studentsAge12);

        List<Student> sorted = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println(sorted);
    }
}
