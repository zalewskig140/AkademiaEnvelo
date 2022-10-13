package com.Envelo.Zad2;

public class Main {

    private boolean search(int[] numbers, int x) {
        int finish = numbers.length - 1;
        int begin = 0;
        if (x <= numbers[0] && x >= numbers[numbers.length - 1]) {
            while (begin <= finish) {
                int mid = (begin + finish) / 2;
                if (numbers[mid] == x) {
                    return true;
                } else if (x < numbers[mid]) {
                    begin = mid + 1;
                } else if (x > numbers[mid]) {
                    finish = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main ob = new Main();
        int[] h = {155, 123, 111, 95, 92, 75, 64, 53, 50, 44, 32, 21, 19, 17, 18, 10, 5, 2, 0};
        System.out.println(ob.search(h, 111));
    }
}
