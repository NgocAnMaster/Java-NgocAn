package org.example.homework.database;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database dt = new Database();
        List<Record> recs = List.of(
                new Student(112478, ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 48, 0), ZoneId.of("GMT+7")), ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 48, 0), ZoneId.of("GMT+7")), "Nguyen Van A", LocalDate.of(2005, 4, 12)),
                new Student(142217, ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 50, 0), ZoneId.of("GMT+7")), ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 50, 00), ZoneId.of("GMT+7")), "Pham Thi Le B", LocalDate.of(2007, 6, 30)),
                new School(142218, ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 52, 0), ZoneId.of("GMT+7")), ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 50, 00), ZoneId.of("GMT+7")), "Truong THPT Chu Van An", "So 8 Nguyen Dinh Hue")
        );
        dt.setRecords(recs);
        System.out.println(dt);
        dt.save(new Student(112478, ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 48, 0), ZoneId.of("GMT+7")), ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(3, 7, 0), ZoneId.of("GMT+7")), "Nguyen Le Viet C", LocalDate.of(2001, 8, 1)));
        dt.save(new School(null, ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(3, 8, 40), ZoneId.of("GMT+7")), ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(3, 8, 40), ZoneId.of("GMT+7")), "Truong Dai hoc FPT Aptech", "So 8 Ton That Thuyet"));
        dt.save(new Student(418841, ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(3, 9, 10), ZoneId.of("GMT+7")), ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(3, 9, 10), ZoneId.of("GMT+7")), "Truong Dai hoc FPT Aptech", LocalDate.of(2003, 11, 11)));
        System.out.println(dt.getRecords().toString());
        System.out.println(dt.find(112478));
        System.out.println(dt.find(418840));
        System.out.println(dt.delete(142219));
        System.out.println(dt.delete(142220));
        System.out.println(dt.findByCreatedAtAfter(ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 52, 0), ZoneId.of("GMT+7"))));
        System.out.println(dt.findByCreatedAtAfter(ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(11, 18, 0), ZoneId.of("GMT+7"))));
        System.out.println(dt.findByUpdatedAtAfter(ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(2, 50, 15), ZoneId.of("GMT+7"))));
        System.out.println(dt.findByUpdatedAtAfter(ZonedDateTime.of(LocalDate.of(2023, 8, 18), LocalTime.of(3, 9, 0), ZoneId.of("GMT+7"))));
    }
}
