import java.text.*;
import java.util.*;

public class BerkeleyAlgorithm {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of clients in your network: ");
        int clientCount = sc.nextInt();
        sc.nextLine();

        String[] timeString = new String[1 + clientCount];

        for (int i = 0; i < timeString.length; i++) {
            if (i == 0) {
                System.out.print("Enter time displayed in Server (HH:mm): ");
            } else {
                System.out.print("Enter time displayed in Client " + i + " (HH:mm): ");
            }
            timeString[i] = sc.nextLine();
        }
        System.out.println("\nBefore Synchronization");
        displayTime(timeString);
        berkeleyAlgorithm(timeString);
        System.out.println("\nAfter Synchronization");
        displayTime(timeString);
        sc.close();
    }

    public static void berkeleyAlgorithm(String[] timeString) throws ParseException {
        int n = timeString.length;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        // Converting time to milliseconds
        long[] timeInMilliseconds = new long[n];
        for (int i = 0; i < n; i++) {
            timeInMilliseconds[i] = simpleDateFormat.parse(timeString[i]).getTime();
        }

        // Calculating time difference w.r.t. server
        long serverTime = timeInMilliseconds[0];
        long[] differenceInTimeWithServer = new long[n];
        for (int i = 0; i < n; i++) {
            differenceInTimeWithServer[i] = timeInMilliseconds[i] - serverTime;
        }

        // Calculating average difference
        long sumDifferences = 0;
        for (int i = 1; i < n; i++) { // Start from 1 to exclude the server itself
            sumDifferences += differenceInTimeWithServer[i];
        }
        long averageDifference = sumDifferences / (n - 1);

        // Adjusting the time in Server and Clients
        for (int i = 0; i < n; i++) {
            long adjustment = averageDifference - differenceInTimeWithServer[i];
            timeInMilliseconds[i] += adjustment;
            if (i > 0) { // Display adjustment for clients only
                System.out.println("Clock " + i + " adjustment = " + adjustment / (1000 * 60));
            }
        }

        // Updating the time strings after adjustment
        for (int i = 0; i < n; i++) {
            timeString[i] = simpleDateFormat.format(new Date(timeInMilliseconds[i]));
        }
    }

    private static void displayTime(String[] time) {
        System.out.println("Server Clock:\t" + time[0]);
        for (int i = 1; i < time.length; i++) {
            System.out.println("Client " + i + " Clock:\t" + time[i]);
        }
        System.out.println();
    }
}