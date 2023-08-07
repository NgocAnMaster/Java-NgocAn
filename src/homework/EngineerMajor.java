package homework;

public enum EngineerMajor {
    IT("IT"), MECHANICS("mechanics"), ELECTRONIC("electronic"), CIVIL("civil");

    private String majorInLowercase;

    EngineerMajor(String majorInLowercase){
        this.majorInLowercase = majorInLowercase;
    }

    public String getMajorInLowercase() {
        return majorInLowercase;
    }

    @Override
    public String toString() {
        return majorInLowercase;
    }
}

//enum Major{
//        IT, MECHANICS, ELECTRONIC, CIVIL
//    }
//
//    enum EngLevel{
//        FRESHER, INTERN, JUNIOR, SENIOR
//    }