package BookDemo;

import java.util.Map;

public class BookDemo {
    public static void main(String[] args) {
        double heso;
        Level level = Level.INTERN;
        heso = level.getHeso();

        Map<Level, Double> levelMap = Map.of(
                Level.INTERN, 0.5,
                Level.FRESHER, 1.0,
                Level.JUNIOR, 2.0,
                Level.SENIOR, 5.0
        );

        Double hesoIntern = levelMap.get(Level.INTERN);
        System.out.println(hesoIntern);
    }
}
