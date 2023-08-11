package org.example.classList;

import java.util.HashMap;

public class BiologyClass extends TClass{
    public BiologyClass(String name, String grade) {
        super(name, grade);
    }

    @Override
    public Double averageScore() {
        return getStudents().stream().mapToDouble(student -> {
            HashMap<TSubject, Double> scores = student.getScores();
            return scores.entrySet().stream().mapToDouble(entry ->
                    (entry.getKey().equals(TSubject.BIOLOGY) ? 2 : 1) * entry.getValue()).sum() /
                    (TSubject.values().length + 1);
//            return (scores.get(TSubject.MATHS) * 2 + scores.get(TSubject.PHYSICS) +
//                    scores.get(TSubject.GEOGRAPHY) + scores.get(TSubject.HISTORY) +
//                    scores.get(TSubject.BIOLOGY)) / 6;
        }).average().orElse(0);
    }
}
