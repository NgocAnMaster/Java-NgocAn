package homework;

public enum EngineerLevel {
    FRESHER("Fresher"), INTERN("Intern"), JUNIOR("Junior"), SENIOR("Senior");

    private String engLevel;

    EngineerLevel(String engLevel){
        this.engLevel = engLevel;
    }

    public String getEngLevel() {
        return engLevel;
    }

    @Override
    public String toString() {
        return engLevel;
    }
}
