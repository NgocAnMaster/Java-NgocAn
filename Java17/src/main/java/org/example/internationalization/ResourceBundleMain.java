package org.example.internationalization;

import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleMain {
    public static void main(String[] args) {
//        Locale.setDefault(Locale.US);
        Locale.setDefault(new Locale("vi", "VN"));

        ResourceBundle messages = ResourceBundle.getBundle("messages");
        String hello = messages.getString("hello");
        System.out.println(hello);
        double money = 1000.0;

        Currency currency = Currency.getInstance(Locale.getDefault());

        System.out.println(messages.getString("money") + " " + money + " " + currency.getCurrencyCode());
    }
}
