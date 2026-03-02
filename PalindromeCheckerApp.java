import java.util.Scanner;

public class PalindromeCheckerApp {
    // Node definition
    static class Node {
        char data;
        Node next;
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    // Reverse linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    // Check palindrome
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        // Find middle using slow & fast pointers
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        Node secondHalf = reverse(slow.next);
        // Compare both halves
        Node firstHalf = head;
        Node temp = secondHalf;
        boolean result = true;

        while (temp != null) {
            if (firstHalf.data != temp.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Convert string to linked list
        Node head = null;
        Node tail = null;
        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Check palindrome
        if (isPalindrome(head)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}