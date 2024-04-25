import java.rmi.registry.*;
import java.util.Scanner;

class Client {
    public static void main(String args[]) {
        try {
            // Connect to the RMI Registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteOperations stub = (RemoteOperations) registry.lookup("RemoteOperations");

            Scanner scanner = new Scanner(System.in);

            // Add operation
            System.out.println("Enter the first number for addition:");
            int a = scanner.nextInt();
            System.out.println("Enter the second number for addition:");
            int b = scanner.nextInt();
            int sum = stub.add(a, b);
            System.out.println("Result of " + a + " + " + b + " = " + sum);

            // -----------------------------------------------------------

            // Power of two operation
            System.out.println("Enter an exponent for power of two:");
            int exponent = scanner.nextInt();
            double power = stub.powerOfTwo(exponent);
            System.out.println("2 raised to the power of " + exponent + " is " + power);

            // -----------------------------------------------------------

            // Celsius to Fahrenheit operation
            System.out.println("Enter temperature in Celsius to convert to Fahrenheit:");
            double celsius = scanner.nextDouble();
            double fahrenheit = stub.celsiusToFahrenheit(celsius);
            System.out.println(celsius + "C is " + fahrenheit + "F");

            // -----------------------------------------------------------

            // Miles to Kilometers operation
            System.out.println("Enter distance in miles to convert to kilometers:");
            double miles = scanner.nextDouble();
            double kilometers = stub.milesToKilometers(miles);
            System.out.println(miles + " miles is " + kilometers + " kilometers");

            // -----------------------------------------------------------

            // Append "Hello" operation
            scanner.nextLine(); // consume leftover newline
            System.out.println("Enter a name to append 'Hello':");
            String name = scanner.nextLine();
            String greeting = stub.appendHello(name);
            System.out.println(greeting);

            // -----------------------------------------------------------

            // Lexicographic comparison
            System.out.println("Enter the first string:");
            String str1 = scanner.nextLine();
            System.out.println("Enter the second string:");
            String str2 = scanner.nextLine();
            String maxString = stub.maxLexicographic(str1, str2);
            System.out.println("Lexicographically larger string is: " + maxString);

            // -----------------------------------------------------------

            // Count vowels operation
            System.out.println("Enter a string to count vowels:");
            String str = scanner.nextLine();
            int vowelCount = stub.countVowels(str);
            System.out.println("Number of vowels in '" + str + "' is " + vowelCount);

            // -----------------------------------------------------------

            // Factorial calculation
            System.out.println("Enter a number to compute factorial:");
            int number = scanner.nextInt();
            long factorial = stub.findFactorial(number);
            System.out.println("Factorial of " + number + " is " + factorial);

            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
