package org.example.collectionandmap.pair;

import org.example.collectionandmap.Cat;
import org.example.collectionandmap.Dog;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        Pair<Integer, Integer> pair1 = new Pair<>(4, 6);
        Pair<Integer, Integer> pair2 = new Pair<>(8, 2);
        Pair<Integer, Integer> pair3 = new Pair<>(9, 12);
        Pair<Integer, Integer> pair4 = new Pair<>(8, 1);
        Pair<Integer, Integer> pair5 = new Pair<>(1, 16);
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
        pairs.add(pair5);
        System.out.println(pairs);

        Dog dog = new Dog("male", 10);
        Cat cat = new Cat("female", 8);
        Pair<Dog, Cat> dogCatPair = new Pair<>(dog, cat);
        System.out.println(dogCatPair);
    }
}
