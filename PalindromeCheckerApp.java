import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Step 1: Normalize string (remove spaces & convert to lowercase)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply palindrome logic (two-pointer approach)
        int start = 0;
        int end = normalized.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        sc.close();
    }
}