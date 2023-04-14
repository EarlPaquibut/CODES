import java.util.*;
import java.io.*;

public class CustomerItemOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String customerFile = "customers.txt";
        String itemFile = "items.txt";

        // Load customer IDs into a HashSet for quick lookup
        HashSet<Integer> customerIds = new HashSet<>();
        try {
            Scanner customerScanner = new Scanner(new File(customerFile));
            while (customerScanner.hasNextLine()) {
                String line = customerScanner.nextLine();
                int id = Integer.parseInt(line.substring(line.indexOf(":") + 2));
                customerIds.add(id);
            }
            customerScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Customer file not found.");
            e.printStackTrace();
            System.exit(1);
        }

        // Load item numbers into a HashSet for quick lookup
        HashSet<Integer> itemNumbers = new HashSet<>();
        HashMap<Integer, String> itemDescriptions = new HashMap<>();
        try {
            Scanner itemScanner = new Scanner(new File(itemFile));
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                int number = Integer.parseInt(line.substring(line.indexOf(":") + 2));
                itemNumbers.add(number);
                String description = itemScanner.nextLine().substring(line.indexOf(":") + 2);
                itemDescriptions.put(number, description);
            }
            itemScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Item file not found.");
            e.printStackTrace();
            System.exit(1);
        }

        // Prompt the user for a customer ID and item number
        System.out.print("Enter customer ID: ");
        int customerId = sc.nextInt();
        if (!customerIds.contains(customerId)) {
            System.out.println("Error: Customer ID not found.");
            System.exit(1);
        }

        System.out.print("Enter item number: ");
        int itemNumber = sc.nextInt();
        if (!itemNumbers.contains(itemNumber)) {
            System.out.println("Error: Item number not found.");
            System.exit(1);
        }

        // Print the customer information
        try {
            Scanner customerScanner = new Scanner(new File(customerFile));
            while (customerScanner.hasNextLine()) {
                String line = customerScanner.nextLine();
                int id = Integer.parseInt(line.substring(line.indexOf(":") + 2));
                if (id == customerId) {
                    String name = customerScanner.nextLine().substring(line.indexOf(":") + 2);
                    int zipCode = Integer.parseInt(customerScanner.nextLine().substring(line.indexOf(":") + 2));
                    System.out.println("Customer ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Zip code: " + zipCode);
                    break;
                }
            }
            customerScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Customer file not found.");
            e.printStackTrace();
            System.exit(1);
        }

        // Print the item information
        System.out.println();
        System.out.println("Item number: " + itemNumber);
        System.out.println("Description: " + itemDescriptions.get(itemNumber));
    }
}
