import java.rmi.registry.*;
import java.util.Scanner;


class Client {
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1000);
            AdditionInterface stub = (AdditionInterface) registry.lookup("Calculation");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first number:");
            int a = scanner.nextInt();
            System.out.println("Enter the second number:");
            int b = scanner.nextInt();

            // For string input
            // String str = scanner.nextLine();

            int result = stub.calculate(a, b);

            System.out.println("Result of " + a + " + " + b + " = " + result);

            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}