import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println(solution("2-4A0r7-4K", 4));
        System.out.println(solution("2-4A0r7-4K", 3));
        System.out.println(solution("2-4A0r7-4K", 2));
        */

        /*
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "cba";
        //System.out.println(s1.length());
        System.out.println(solution1(s1, s2));
        System.out.println(solution1(s1, ""));
        System.out.println(solution1(s1, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(solution1(s1, "za"));
        System.out.println(solution1(s1, "az"));
        System.out.println(solution1(s1, "ab"));
        */

        /**
        int[] A = {-1,7,0,7,-8};
        System.out.println(solution(A));

        int[] B = {9};
        System.out.println(solution(B));

        int[] C = {5, 9, -8, 3, 9};
        System.out.println(solution(C));

        int[] D = {3, 4, -2};
        System.out.println(solution(D));
         */

        /**
        int[] arr = {5, 8, 11, 70, 13, 45};
        System.out.println(FindLargest(arr, 0, arr.length - 1));

        int[] maj = {1, 2, 1, 1, 3, 1};
        System.out.println(findMajority(maj, 0, maj.length - 1));
         */
        //System.out.println(backspaceCompare("ab#d", "ac#d"));

        /**
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        rotateMatrix(matrix);
        printMatrix(matrix);
         */


        /**
        //find pair of numbers
        int[] arr = {3, 2, 6, 9, 5};
        System.out.println(findTwo(arr, 9));

        int[] brr = {10, 1, 5};
        System.out.println(findTwo(brr, 7));

        int[] crr = {};
        System.out.println(findTwo(crr, 2));

        int[] drr = {1, 5, 2, 4};
        System.out.println(findTwo(drr, 6));
         **/

        int[] original = {2, 3, 4, 5};
        int[] copy = new int[original.length + 1];
        copy[0] = 1;
        printArray(original);
        printArray(copy);

        Queue<Integer> qu = new LinkedList<>();
        qu.add(8);
        qu.add(9);
        System.out.println(qu.peek());
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }
    public static Pair findTwo(int[] array, int x) {
        //Given an array of size n and a number x, determine
        //the first two elements in the array, if any, whose
        //sum is exactly x
        /**
         Time Complexity: O(n)
         Space Complexity: O(n) due to HashSet
         Can it be solved in a O(1) space complexity?
         */
        if (array.length < 2) {
            return null;
        }

        HashSet<Integer> numsSeen = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int complement = x - array[i];

            if (numsSeen.contains(complement)) {
                return new Pair(complement, array[i]);
            }
            else {
                numsSeen.add(array[i]);
            }
        }
        return null;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] matrix) {
        transposeMatrix(matrix);
        reverseRows(matrix);
    }

    public static void reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][matrix.length - 1 - j];
                System.out.println(temp);
                matrix[i][matrix.length - 1 - j] = matrix[i][j];
                System.out.println(matrix[i][matrix.length - 1 - j]);
                matrix[i][j] = temp;
            }
        }
    }

    public static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static boolean backspaceCompare(String S, String T) {
        System.out.println(backspace(S));
        System.out.println(backspace(T));


        return backspace(S).equals(backspace(T));
    }

    public static String backspace(String s) {
        StringBuilder str = new StringBuilder(s);
        System.out.println(str);
        //"ab#c"

        for (int i = 0; i < str.length();) {
            if (str.charAt(i) != '#') {
                i++;
            }
            else {
                //if it is a #, delete it
                str.deleteCharAt(i);
                //now you need to check if the i for the prev one is valid
                if (i - 1 >= 0) {
                    str.deleteCharAt(i - 1);
                    i--;
                }
            }
        }

        return str.toString();
    }

    public static int findMajority(int[] A, int low, int high) {
        if (low ==  high)
            return A[low];
        else {
            int mid = (low + high) / 2;
            int leftMaj = findMajority(A, low, mid);
            int rightMaj = findMajority(A, mid + 1, high);

            if (leftMaj == rightMaj)
                return leftMaj;

            int leftCount = getFrequency(A, low, mid, leftMaj);
            int rightCount = getFrequency(A, mid + 1, high, rightMaj);

            if (leftCount >= mid)
                return leftMaj;
            else if (rightCount >= mid)
                return rightMaj;
            else
                return -1;
        }
    }

    public static int getFrequency(int[] A, int low, int high, int target) {
        int counter = 0;

        for (int i = low; i <= high; i++) {
            if (A[i] == target)
                counter++;
        }

        return counter;
    }


    public static int FindLargest(int[] A, int low, int high) {
        if (low == high)
            return A[low];
        else {
            int mid = (low + high) / 2;
            int first = FindLargest(A, low, mid);
            int second = FindLargest(A, mid + 1, high);

            if (first < second)
                return second;
            else
                return first;
        }
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        //N is within range [1, 1000] so A is never empty
        //It always at least has the root

        int levelWithMaxSum = 1;
        int maxSum = A[0];
        int levelCounter = 1;

        int currentLevelIndex = 0;
        int nextLevelIndex = (2 * currentLevelIndex) + 1;

        while (nextLevelIndex < A.length) {
            levelCounter++;
            currentLevelIndex = nextLevelIndex;

            int currentLevelSum = 0;
            int endOfRange = ((2 * currentLevelIndex) < A.length) ? (2 * currentLevelIndex) : (A.length - 1);

            for (int nodeIndex = currentLevelIndex; nodeIndex <= endOfRange; nodeIndex++) {
                currentLevelSum += A[nodeIndex];
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                levelWithMaxSum = levelCounter;
            }

            nextLevelIndex = (2 * currentLevelIndex) + 1;
        }

        return levelWithMaxSum;
    }


    public static int solution2(String S1, String S2) {
        // write your code in Java SE 8
        int totalTime = 0;
        int i = 0;
        int j;// = S1.indexOf(S2.charAt(0));

        for (int n = 0; n < S2.length(); n++) {
            j = S1.indexOf(S2.charAt(n));
            totalTime += Math.abs(j-i);
            i = j;
        }
        return totalTime;
    }

    public static int timeFinder(int i, int j) {
        return Math.abs(j-i);
    }
    /*
     We are given a string S consisting of N characters and an integer K.
     The string represents a software license key which we would like to format.
     The string is composed of alphanumerical characters and/or dashes. The dashes
     split the alphanumerical characters within the string into groups (i.e. if
     there are M dashes, the string is split into M+1 groups). The dashes in the
     given string are possibly misplaced.

     We want each group of characters to be of length K (except for possibly the
     first group, which could be shorter, but still must contain at least one
     character). To satisfy this requirement, we will reinsert the dashes.
     Additionally, all the lower case letters in the string must be converted to upper case.

     For example, in the license key "2-4A0r7-4k" there are two dashes which split
     it into three groups of lengths 1, 5 and 2, respectively. If we want each group
     to be of length 4, then we would have to reinsert the dashes. Thus, for K = 4,
     the correctly formatted string is "24A0-R74K".

     Write a function:

     class Solution { public String solution(String S, int K); }

     that, given a non-empty string S consisting of N characters, representing a
     license key to format, and an integer K, returns the license key formatted according
     to the description above.

     For example, given S = "2-4A0r7-4k" and K = 4, the function should return "24A0-R74K",
     and for K = 3, the function should return "24-A0R-74K" as the first group could be shorter.
     Given S = "r" and K = 1, the function should return "R".

     Write an efficient algorithm for the following assumptions:

     N and K are integers within the range [1..300,000];
     string S consists only of alphanumerical characters (a−z and/or A−Z and/or 0−9) and/or dashes (-);
     string S contains at least one alphanumerical character.
     */

    public static String solution1(String S, int K) {
        String input = S.toUpperCase();
        StringBuilder result = new StringBuilder();
        int pointer = input.length() - 1;
        int counter = 0;

        while (pointer > -1) {
            while (input.charAt(pointer) == '-') {
                pointer--;
            }

            if (counter == K) {
                result.insert(0, '-');
                counter = 0;
            }

            result.insert(0, input.charAt(pointer));
            pointer--;
            counter++;
        }

        return result.toString();
    }
}