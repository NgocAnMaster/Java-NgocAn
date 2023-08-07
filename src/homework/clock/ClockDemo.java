package homework.clock;

public class ClockDemo {
    public static void main(String[] args) {
        // get clock
        Clock clockSample = new Clock();
        System.out.println(clockSample);
        Clock clock1 = new Clock(2,4,7);
        Clock clock2 = new Clock(8,26,57);
        System.out.println(clock1);
        System.out.println(clock2);
        clock1.tick();
        int newSeconds = clock1.getSeconds();
        //validate it should be 8 now
        System.out.println(newSeconds);

        clock2.tickDown();
        newSeconds = clock1.getSeconds();
        //validate it should be 56 now
        System.out.println(newSeconds);

        clock1.addClock(clock2);
        //get Hour, minute and second from clock1 and validate
        int newHour = clock1.getHours();
        int newMinute = clock1.getMinutes();
        newSeconds = clock1.getSeconds();
        //validate if they are with the right expected value or not
        System.out.println(clock1);

        // set the h m s
        clock1.setHr(2);
        clock1.setMin(43);
        clock1.setSec(15);
        System.out.println(clock1);
    }
}
