dob: date of birth
grade: 1 -> 12

addClass(): Add a new class into school's class list
addStudents(): Add a new student into class's student list
Student.averageScore(): Calculate weighted average score of student:
- Physics: (Physics x 2 + Maths + Geography + History + Biology) / 6
- Maths: (Maths x 2 + Physics + Geography + History + Biology) / 6
  Class.averageScore(): Calculate weighted average score of all students
  in the class:


Requirement:
Initialize school "FPT Aptech" at "8 Ton That Thuyet"
Initialize maths class "6A", grade 6 and add to school's class list

Initialize students and add to class 6A:
- Nguyen Binh - Male, 1/2/2012
  Math: 9.3, Physics: 8.1, Geography: 7.4, History: 8.2, Biology: 6.5
- Vu Chien - Male, 5/6/2012
  Math: 8.3, Physics: 7.1, Geography: 9.4, History: 9.1, Biology: 9.6
- Tran Dung - Female, 4/3/2012
  Math: 9.8, Physics: 7.2, Geography: 9.1, History: 7.2, Biology: 7.5
- Hoang Dat - Male, 2/9/2012
  Math: 9.1, Physics: 9.0, Geography: 6.4, History: 6.8, Biology: 7.9
- Dang Trang - Female, 11/12/2012
  Math: 6.3, Physics: 9.5, Geography: 8.0, History: 8.2, Biology: 8.3

Print average score of class 6A