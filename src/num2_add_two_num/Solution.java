package num2_add_two_num;

import java.util.Scanner;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int y = 0;
        int buffer = x;
        int radix = 0;
        double digitRadix = 0;
        while (true) {
            buffer /= 10;
            radix++;
            digitRadix = (x % Math.pow(10, (radix))) / Math.pow(10, radix - 1);
            y = y * 10 + (int) digitRadix;
            if (buffer == 0) break;
        }
        if (x==y) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        String command;

        while (true) {
            command = scanner.nextLine();
            if (command.equals("d")) break;
            try {
                System.out.println(solution.isPalindrome(Integer.valueOf(command)));
            } catch (NumberFormatException e) {
                System.out.println("no");
            }

        }
    }
}