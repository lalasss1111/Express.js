import java.util.*;

public class TokenRing {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Number Of Nodes You Want In The Ring : ");
			int n = sc.nextInt();

			System.out.println("Ring Formed Is As Below: ");
			for (int i = 0; i < n; i++) {
				System.out.print(i + " ");
			}
			System.out.println("0"); // Indicates that the ring loops back to node 0

			int choice = 0;
			int token = 0; // Token starts at node 0

			do {
				System.out.print("Enter Sender : ");
				int sender = sc.nextInt();

				System.out.print("Enter Receiver : ");
				int receiver = sc.nextInt();

				System.out.print("Enter Data To Send : ");
				int data = sc.nextInt();

				System.out.print("Token Passing : ");

				// Correct token passing from the current token position to the sender
				for (int i = token; i != sender; i = (i + 1) % n) {
					System.out.print(i + "->");
				}
				System.out.print(sender); // Print the sender node after token has reached there

				System.out.println("\nSender: " + sender + " Sending Data: " + data);

				// Data transfer from sender to receiver
				for (int i = sender; (i + 1) % n != (receiver + 1) % n; i = (i + 1) % n) {
					System.out.println("Data: " + data + " Forwarded By: " + i);
				}

				System.out.println("Receiver: " + receiver + " Received The Data: " + data);

				token = (receiver + 1) % n; // Pass the token to the next node after the receiver

				System.out.print("Do You Want To Send Data Again? If YES Enter 1, If NO Enter 0: ");
				choice = sc.nextInt();

			} while (choice == 1);
		}
	}
}