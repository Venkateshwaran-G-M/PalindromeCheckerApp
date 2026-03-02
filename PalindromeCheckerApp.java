import java.util.*;
// Strategy interface
interface PalindromeStrategy {
    boolean check(String input);
}
// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
// Context class
class PalindromeService {
    private PalindromeStrategy strategy;
    // Inject strategy at runtime
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }
}
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.print("Choose strategy (1 = Stack, 2 = Deque): ");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        // Inject chosen strategy
        PalindromeService service = new PalindromeService(strategy);

        if (service.checkPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}