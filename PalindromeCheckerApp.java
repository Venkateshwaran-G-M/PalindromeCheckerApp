import java.util.*;

public class PalindromeCheckerApp {
    // Method 1: Two-pointer approach
    static boolean checkTwoPointer(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack-based approach
    static boolean checkUsingStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Method 3: Deque-based approach
    static boolean checkUsingDeque(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            deque.addLast(s.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long startTime, endTime;

        // Two-pointer timing
        startTime = System.nanoTime();
        checkTwoPointer(input);
        endTime = System.nanoTime();
        System.out.println("Two-pointer Time: " + (endTime - startTime) + " ns");

        // Stack timing
        startTime = System.nanoTime();
        checkUsingStack(input);
        endTime = System.nanoTime();
        System.out.println("Stack-based Time: " + (endTime - startTime) + " ns");

        // Deque timing
        startTime = System.nanoTime();
        checkUsingDeque(input);
        endTime = System.nanoTime();
        System.out.println("Deque-based Time: " + (endTime - startTime) + " ns");

        sc.close();
    }
}