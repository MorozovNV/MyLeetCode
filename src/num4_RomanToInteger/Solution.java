package num4_RomanToInteger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private int index;

    public int romanToInt(String s) {
        int num1 = 0;
        int num10 = 0;
        int num100 = 0;
        int num1000 = 0;
        index = 1;

        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(s.length() - i - 1);
        }

        num1 = method(s, chars, 'I', 'V', 'X');

        if (index - 1 < s.length()) num10 = method(s, chars, 'X', 'L', 'C') * 10;

        if (index - 1 < s.length()) num100 = method(s, chars, 'C', 'D', 'M') * 100;
        if (index - 1 < s.length()) num1000 = method(s, chars, 'M', 'O', 'O') * 1000;

        return num1 + num10 + num100 + num1000;
    }

    public int method(String s, char[] chars, char I, char V, char X) {
        index--;
        int num1 = 0;
        if (chars[index] == V) {
            if (s.length() > index + 1) {
                if (chars[index + 1] == I) {
                    num1 = 4;
                    index += 3;
                } else {
                    num1 = 5;
                    index += 2;
                }
            } else {
                num1 = 5;
                index++;
            }
        } else if (chars[index] == X) {
            if (s.length() > index + 1) {
                if (chars[index + 1] == I) {
                    num1 = 9;
                    index += 3;
                } else {
                    num1 = 0;
                    index++;
                }
            } else {
                num1 = 0;
                index++;
            }
        } else {
            for (int i = index; i < s.length(); i++) {
                if (chars[i] == I) {
                    num1++;
                    index++;
                } else if (chars[i] == V) {
                    num1 += 5;
                    index += 2;
                    break;
                } else {
                    index++;
                    break;
                }
            }
        }
        return num1;
    }

    public int method2(String s) {
        int pre = 0, cur = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    cur = 1000;
                    break;
                case 'D':
                    cur = 500;
                    break;
                case 'C':
                    cur = 100;
                    break;
                case 'L':
                    cur = 50;
                    break;
                case 'X':
                    cur = 10;
                    break;
                case 'V':
                    cur = 5;
                    break;
                case 'I':
                    cur = 1;
                    break;
            }

            if (cur > pre) {
                result = result - pre - pre + cur;
            } else result += cur;
            pre = cur;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        File reader = new File("input.txt");
        reader.createNewFile();
        Scanner scanner2 = new Scanner(reader);

        Solution solution = new Solution();
        ArrayList<String> command2 = new ArrayList<String>();

        while (scanner2.hasNextLine()) {
            command2.add(scanner2.nextLine());
        }
        System.out.println(command2);

        int i = 0;
        while (i < command2.size()) {
            System.out.print(command2.get(i) + " -> ");
            System.out.println(" number=" + solution.romanToInt(command2.get(i))
                    + " | " + solution.method2(command2.get(i++)));

        }


/*
        String command;
        Scanner scanner = new Scanner(System.in);
// до 10 //93
        while (true) {
            command = scanner.nextLine();
            if (command.equals("d")) break;
            System.out.println(solution.romanToInt(command));
        }
*/
    }
}
/*
I
II
III
IV
V
VI
VII
VIII
IX
X
XI
XII
XIII
XIV
XV
XVI
XVII
XVIII
XIX
XX
XXI
XXII

XXX
XL
L
LX
LXX
LXXX
XC
C
CX
CXX
CXXX
CXL
CL
CLX
CLXX
CLXXX
CXC
CC
CCX
 */