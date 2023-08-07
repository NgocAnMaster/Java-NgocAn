import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        int a = 10;
//        long b = 100L;
//        int c = 0X1effa;
//        byte d = 10;
//        float e = 100.0F;
//        double f = 100.0;
//        String g = "Hello \t world \377";
//
//        System.out.println("Gia tri cua a: " + a);
//        System.out.println("Gia tri cua b: " + b);
//        System.out.println("Gia tri cua c: " + c);
//        System.out.println("Gia tri cua d: " + d);
//        System.out.println("Gia tri cua e: " + e);
//        int sum = 0;
//        for (int i = 1; i <= 100; i++){
//            sum += i;
//        }
//        System.out.println(sum);
//        int count = 0;
//        System.out.println("From 1 to 100, numbers that divisible with 3: ");
//        int i = 0;
//        while(i <= 100){
//            if(i%3 == 0){
//                count++;
//                System.out.println(i+" ");
//            }
//            i++;
//        }
//        System.out.println("\n("+count+" numbers)");

//        Dog myDog = new Dog("Milo", 2, false, 3);
//        myDog.setAge(2);
//        myDog.setGender(false);
//        myDog.name = "milo"; // ko nen lam
//
//        System.out.println(myDog.getLegs());
//        Dog myDog = new Dog();
//        Dog myDog1 = new Dog();
//        final int a = 10; // Local variable
//
//
//        System.out.println(Dog.legs);
//        System.out.println(myDog.legs);
//        Human human = new Human();
//        human.testAge();

//        Dog dog1 = new Dog();
//        dog1.setName("dog 1");
//        System.out.println(dog1.getName());
//        Dog dog2 = dog1;
//        dog2.setName("dog 1 updated");
//        System.out.println(dog2.getName());
//        Dog a = new Dog();
//        System.out.println(a.getName());
//        System.out.println(a.isGender());
//        System.out.print("hello");
//        System.out.print("world");

//        Scanner input = new Scanner(System.in);
//        System.out.print("Nhap so tu nhien: ");
//        int so = input.nextInt();
//        System.out.println("So da nhap: " + so);
//        System.out.print("Nhap hai so tu nhien: ");
//        int so1 = input.nextInt();
//        int so2 = input.nextInt();
//        System.out.println("Hai so da nhap: "+so1+", "+so2);

//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Nhap vao so a = ");
//        int a = sc.nextInt();
//        System.out.print("Nhap vao so b = ");
//        int b = sc.nextInt();
//
//        int c = a*b;
//
//        System.out.println("c = a*b = "+c);

        Dog dog = new Dog();
        String[] arr;
        arr = new String[]{"banhmi", "kem", "xoi", "abc", "asd"};
        String[] arr1;
        arr1 = new String[]{"banhmi", "kem", "xoi", "abc", "asd"};
                dog.eat(new String[]{"banhmi", "kem", "xoi", "abc", "asd"});

//        double a = 10.9;
//        int b = (int) a;
//        System.out.println(b);

//        for (int i = 0; i<10; i++){
//            if(i==7){
//                continue;
//            }
//            System.out.println(i);
//        }

//        int i = 0;
//        while(i<10) {
//            System.out.println(i);
//            i++;
//        }

//        int a = 10;
//        switch (a){
//            case 1:
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            case 3:
//                System.out.println("3");
//                break;
//            case 4:
//                System.out.println("4");
//                break;
//            case 5:
//                System.out.println("5");
//                break;
//            default:
//                System.out.println("Hello");
//        }
//
//        Human human1 = new Human(10, "Alice");
//        Human human2 = new Human(20, "Bob");
//        Human human3 = new Human(30, "Chris");
//        Human human4 = new Human(40, "Dan");
//        Human human5 = new Human(40, "Elsa");
//
////        human.testAge(5);
//
//        Human[] humans = {human2, human4, human3, human1, human5};
//
//        for(int i=0;i < humans.length;i++){
//            System.out.println(humans[i].getName()+" "+humans[i].getAge());
//        }
//
//        // 1. Find name of the person who is oldest
//
//        Human oldest = humans[0];
//        for(int i = 0; i<humans.length; i++){
//            if(oldest.getAge()<=humans[i].getAge()){
//                oldest = humans[i];
//            }
//        }
//
//        System.out.println("Oldest human: "+oldest.getName()+", age: "+oldest.getAge());
//
//        // 1. Find name of all people who are oldest
//
//        Human[] oldestHumans = new Human[5];
//        int count = 0;
//        for(Human human : humans){
//            if(human.getAge() > count){
//                count = human.getAge();
//                oldestHumans[0] = human;
//            }
//            if(human.getAge() == count){
//                oldestHumans[0] = human;
//            }
//        }
//        for(int i = 0; i<oldestHumans.length; i++){
//            System.out.println("Oldest human: "+oldestHumans[i].getName()+", age: "+oldestHumans[i].getAge());
//        }


        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.set(0,4);
        System.out.println(list);
        System.out.println(list.get(0));
        list.add(5);
        System.out.println(list);
        list.addAll(1,list);
        System.out.println(list);
        if (list.contains(0)){
            System.out.println("list co so 0");
        }else {
            System.out.println("list co so 0");
        }
        list.remove(1);
        System.out.println(list);
        if (list.isEmpty()){
            System.out.println("list trong");
        }else {
            System.out.println("list khong trong");
        }
        System.out.println(list.indexOf(5));
        System.out.println(list.subList(2,5));

        System.out.println("------------------------------------------------");
        String testString = "hello world";
        String replacedString = testString.replace("hello", "xin chao");
        System.out.println(replacedString);

        String substring = testString.substring(3, 5);
        System.out.println(substring);
//        substring.in

        String trimString = testString.trim();
        System.out.println(trimString);
        System.out.println("test");

        System.out.println("------------------------------------------------");
        Student student = new Student();
        student.setAge(10);
        student.setName("Nguyen Van A");
        student.setClassName("Java");

        Student student1 = new Student();
        student1.setAge(10);
        student1.setName("Nguyen Van A");
        student1.setClassName("php");

        List<Student> students = new ArrayList<>();
        students.add(student);

        boolean contains = students.contains(student1);
        System.out.println(contains);
    }

    public static void test(int a) {
        a = 10;
    }

    public static void testReference(Dog a){
        a.setName("dog 1 updated");
    }
}

