package org.example.collectionandmap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Integer> values = new ArrayList<>();
//        values.add(1);
//        values.add(3);
//        values.add(2);
//        values.add(1);
//        values.add(5);
////        values.sort(Comparator.comparing(v -> v));
////        values.remove(3);
//
////        for (int a : values){
////            System.out.println(a + 1);
////        }
//
//        printArr(values, "Example");

//        Set<Integer> integers = new LinkedHashSet<>(values);
//        System.out.println(integers);
//        List.of("a", "b", "c", "b", "d")
//        values.add(null);
//        for (int i = 0; i < values.size(); i++) {
//            if (values.get(i).equals("b")){
//                values.remove(i);
//            }
//        }
//        values.add("e");
//        printArr(values);
//        System.out.println(values);

        Dog dog = new Dog("male", 10);
        Cat cat = new Cat("female", 8);
        Animal older = findOlder(dog, cat);
        System.out.println(older);
    }

//    public static <T, R> void printArr(T value1, R value2){
//        System.out.println(value1);
//        System.out.println(value2);
//        System.out.println("Giá trị là: " + value1 + " và " + value2);
//    }
    private static <T extends Animal> T findOlder(T animal1, T animal2){
        if (animal1.getAge() > animal2.getAge()) {
            return animal1;
        }
        return animal2;
    }
    
    private static <T> void print(T value){
        System.out.println(value);
    }
    
    private static void printOldest(List<? extends Animal> animals){
        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);
    }

    private static void print1(List<?> list){
        list.forEach(System.out::println);
    }

    private static <T> void print2(List<T> list){
        list.forEach(System.out::println);
    }
}