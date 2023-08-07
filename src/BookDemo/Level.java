package BookDemo;

public enum Level {
    FRESHER(0.5), INTERN(1), JUNIOR(2), SENIOR(5);

    private final double heso;

    Level(double heso){
        this.heso = heso;
    }

    public double getHeso(){
        return heso;
    }
}
