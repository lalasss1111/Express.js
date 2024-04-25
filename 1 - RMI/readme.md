import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

// Define the remote interface
interface RemoteOperations extends Remote {
    int add(int a, int b) throws RemoteException;
    double powerOfTwo(int exponent) throws RemoteException;
    double celsiusToFahrenheit(double celsius) throws RemoteException;
    double milesToKilometers(double miles) throws RemoteException;
    String appendHello(String name) throws RemoteException;
    String maxLexicographic(String str1, String str2) throws RemoteException;
    int countVowels(String str) throws RemoteException;
    long findFactorial(int number) throws RemoteException;
}

// Implement the server class
class Server extends UnicastRemoteObject implements RemoteOperations {
    public Server() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    // -----------------------------------------------------------

    @Override
    public double powerOfTwo(int exponent) throws RemoteException {
        return Math.pow(2, exponent);
    }

    // -----------------------------------------------------------

    @Override
    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9 / 5) + 32;
    }

    // -----------------------------------------------------------

    @Override
    public double milesToKilometers(double miles) throws RemoteException {
        return miles * 1.61;
    }

    // -----------------------------------------------------------

    @Override
    public String appendHello(String name) throws RemoteException {
        return "Hello " + name;
    }

    // -----------------------------------------------------------

    @Override
    public String maxLexicographic(String str1, String str2) throws RemoteException {
        return (str1.compareTo(str2) > 0) ? str1 : str2;
    }

    // -----------------------------------------------------------

    @Override
    public int countVowels(String str) throws RemoteException {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    // -----------------------------------------------------------

    @Override
    public long findFactorial(int number) throws RemoteException {
        if (number == 0) {
            return 1;
        }
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // Main method to establish RMI server
    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteOperations", obj);
            System.out.println("Server is ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
