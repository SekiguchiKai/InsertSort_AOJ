package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        int N = 0;
        String A = null;
        try {
            BufferedReader stdReader =
                    new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(stdReader.readLine());
            A = stdReader.readLine();

            stdReader.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.exit(0);
        }


        String[] stringA = A.split(" ");

        int[] intA = Stream.of(stringA).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                System.out.print(intA[i] + " ");
            } else {
                System.out.println(intA[i]);
            }
        }


        for (int i = 1; i < N; i++) {

            int value = intA[i];
            int j = i - 1;

            while (j >= 0 && intA[j] > value) {
                intA[j + 1] = intA[j];
                j--;
                intA[j + 1] = value;

            }

            for (int k = 0; k < N; k++) {
                if (k != N - 1) {
                    System.out.print(intA[k] + " ");
                } else if (intA[k] != N - 1) {
                    System.out.println(intA[k]);
                } else {
                    System.out.print(intA[k]);
                }
            }
        }
    }
}
