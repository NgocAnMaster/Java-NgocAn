package org.example.math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String a = "Hello";
        System.out.println(a.charAt(0));
        String b = "Hello Vietnam @#9";
        Pattern lettersOnly = Pattern.compile("[^a-zA-Z\\s]+");
        Matcher bMatch = lettersOnly.matcher(b);
        System.out.println(bMatch);
        System.out.println(b.replaceAll("[^a-zA-Z\\s]+", ""));
        String c = "Toi noi la \"moi nguoi phai di hoc day du\" xong moi nguoi tra loi \"ko thich\"";
        Pattern regex1 = Pattern.compile("[^\"[^\"]*\"]+");
        System.out.println(c.replaceAll(regex1.pattern(), ""));
    }
}
