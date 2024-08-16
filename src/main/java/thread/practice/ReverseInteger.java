package thread.practice;

public class ReverseInteger {


    public static void main(String[] args) {
        int num = -123;
        int offset = num < 0 ? -1 : 1;

        int newNumber = 0;
        while (num > 0) {
            int rem = num % 10;
            num = num / 10;
            newNumber = newNumber + rem;
            newNumber = newNumber * 10;
        }

    }
}
