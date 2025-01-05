package emc;

import java.util.Scanner;

public class Inputs {
    private int B;
    public String[][] input(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();


        int[] distances = new int[P - 1];
        for (int i = 0; i < P - 1; i++) {
            distances[i] = sc.nextInt();
        }

        int[] travelTimes = new int[P - 1];
        for (int i = 0; i < P - 1; i++) {
            travelTimes[i] = sc.nextInt();
        }

        int K = sc.nextInt();
        int I = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        B = sc.nextInt();
        sc.nextLine();
        String[][] bookings = new String[B][4];
        for (int i = 0; i < B; i++) {
            String line = sc.nextLine();
            bookings[i] = line.split(" ");
        }
        sc.nextLine();
//        System.out.println("N: " + N + ", P: " + P);
//        System.out.println("Distances: " + Arrays.toString(distances));
//        System.out.println("Travel Times: " + Arrays.toString(travelTimes));
//        System.out.println("K: " + K + ", I: " + I + ", X: " + X + ", Y: " + Y);
//        System.out.println("Bookings: ");
//        for (String[] booking : bookings) {
//            System.out.println(Arrays.toString(booking));
//        }
        return bookings;
    }
    public int getB()
    {
        return B;
    }
}