package com.codegym.task.task30.task3012;

/* 
Derive a specific number

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(5000);
    }

    public void createExpression(int number) {
        //if (number > 0 && number <= 3000) {           // boundary required in task
            String ternary = balancedTernary(number);
            System.out.println(generateEquation(ternary, number));
        //}
    }

    // Change decimal number to balanced ternary number system
    public static String balancedTernary(int n) {
        String output = "";
        while (n > 0) {
            int rem = n % 3;
            n = n / 3;
            if (rem == 2) {
                rem = -1;
                n++;
            }
            output = (rem == 0 ? '0' :
                    (rem == 1) ? '1' : 'Z') + output;
        }
        return output;
    }

    // Generate equation in increasing order
    public String generateEquation(String ternary, int number) {
        String result = number + " = ";
        List<Character> charactersTernary = new ArrayList<>();

        for (char ch : ternary.toCharArray()) {
            charactersTernary.add(ch);
        }

        for (int i = ternary.length() - 1, j = 0; i >= 0; i--, j++) {
            int temp = (int) Math.pow(3, j);
            if (charactersTernary.get(i) == '1') {
                result = result + " + " + temp;
            } else if (charactersTernary.get(i) == 'Z') {
                result = result + " - " + temp;
            }
        }
        return result;
    }
}
