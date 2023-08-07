import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder

public class Student {
    private String name;
    private String school;
    private LocalDate dob;
    private String password;

    private String getPassword(){
        return getPassword();
    }

    public Student(String name, String school) {
        this.name = name;
        this.school = school;
    }

}
