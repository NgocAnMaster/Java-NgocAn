package org.example.internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {
    public static void main(String[] args) {
        Locale vn = new Locale("vi", "VN");
//        Locale us = Locale.FRANCE;
        Locale.setDefault(vn);

        double number = 1234000.567;

//        NumberFormat vnFormat = NumberFormat.getInstance(vn);
//        NumberFormat usFormat = NumberFormat.getInstance(us);
        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println(number);
    }
}
