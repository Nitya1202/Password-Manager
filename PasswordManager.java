import java.util.HashMap;
import java.util.Scanner;

public class PasswordManager {

    static HashMap<String, String> store = new HashMap<>();

    // Simple encryption (reverse string)
    public static String encrypt(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    // Simple decryption (reverse back)
    public static String decrypt(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Password");
            System.out.println("2. Retrieve Password");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter site name: ");
                String site = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                String encrypted = encrypt(password);
                store.put(site, encrypted);

                System.out.println("Password stored successfully (Encrypted)");

            } else if (choice == 2) {
                System.out.print("Enter site name: ");
                String site = sc.nextLine();

                if (store.containsKey(site)) {
                    String encrypted = store.get(site);
                    String decrypted = decrypt(encrypted);

                    System.out.println("Your password: " + decrypted);
                } else {
                    System.out.println("No password found for this site.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}