package org.example.classList;

import javax.security.auth.Subject;
import java.util.HashMap;

public class MathsClass extends TClass{
    public MathsClass(String name, String grade) {
        super(name, grade);
    }

    @Override
    public Double averageScore() {
        return getStudents().stream().mapToDouble(student -> {
            HashMap<TSubject, Double> scores = student.getScores();
            return (scores.get(TSubject.MATHS) * 2 + scores.get(TSubject.PHYSICS) +
                    scores.get(TSubject.GEOGRAPHY) + scores.get(TSubject.HISTORY) +
                    scores.get(TSubject.BIOLOGY)) / 6;
        }).average().orElse(0);
    }
}
