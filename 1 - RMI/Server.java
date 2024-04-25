import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;


interface AdditionInterface extends Remote {
    int calculate(int a, int b) throws RemoteException;
}


class Server extends UnicastRemoteObject implements AdditionInterface {
    public Server() throws RemoteException {
        super();
    }

    // public static int countVowels(String word) {
    //     int count = 0;
    //     for (int i = 0; i < word.length(); i++) {
    //         char ch = Character.toLowerCase(word.charAt(i));
    //         if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // public static long findFactorial(int number) {
    //     if (number == 0) {
    //         return 1;
    //     }
    //     long factorial = 1;
    //     for (int i = 1; i <= number; i++) {
    //         factorial *= i;
    //     }
    //     return factorial;
    // }

    @Override
    public int calculate(int a, int b) throws RemoteException {
        return a + b;

        // For power of 2
        // double result = Math.pow(2, num);
        // return result;

        // For celsius to fahrenheit
        // double fahrenheit = (celsius * 9 / 5) + 32;
        // return fahrenheit;

        // For miles to km
        // double kilometers = miles * 1.61;
        // return kilometers;

        // For appending Hello
        // String res = "Hello " + str;
        // return res;

        // For returning lexographically largest string
        // if (str1.compareTo(str2) > 0) {
        //     return str1;
        // } else {
        //     return str2;
        // }

        // For counting vowels in a string
        // int res = countVowels(str);
        // return res;

        // For finding factorial of a number
        // long res = findFactorial(num);
        // return res;
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Registry registry = LocateRegistry.createRegistry(1000);
            registry.rebind("Calculation", obj);
            System.out.println("Server is ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
        }
    }
}