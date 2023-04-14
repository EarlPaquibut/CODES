import java.util.*;
import java.io.*;

public class CreateCustomerFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String customerFile = "customers.txt";
        int idNumber = 0, zipCode = 0;
        String customerName;
        int stop = 1;

        HashSet<Integer> usedIds = new HashSet<>();

        while (stop != 0) {
            System.out.println("Enter ID Number (three digits) >> ");
            while (idNumber < 100 || idNumber > 999) {
                idNumber = sc.nextInt();
                if (idNumber < 100 || idNumber > 999) {
                    System.out.println("Error: ID number must be a three-digit integer. Please try again.");
                }
            }

            if (usedIds.contains(idNumber)) {
                System.out.println("Error: ID number already in use. Please enter a different ID number.");
                continue; 
            }

            System.out.println("Enter Name >> ");
            customerName = sc.next();
            if (customerName.length() <= 6 || customerName.length() >= 8) {
                System.out.println("Error: Customer name is too long or too short. Please enter a name with 7 characters.");
                continue; 
            }
            System.out.println("Enter Zip Code (five digits) >> ");
            while (zipCode < 10000 || zipCode > 99999) {
                zipCode = sc.nextInt();
                if (zipCode < 10000 || zipCode > 99999) {
                    System.out.println("Error: Zip code must be a five-digit integer. Please try again.");
                }
            }

            try {
                FileWriter writer = new FileWriter(customerFile, true);
                writer.write("ID : " + idNumber + "\n" + "Customer Name : " + customerName + "\n" + "Zip Code : " + zipCode + "\n");
                writer.close();
                System.out.println("Customer information has been saved to file.");
                usedIds.add(idNumber);
            } catch (IOException e) {
                System.out.println("Error writing to file.");
                e.printStackTrace();
            }
            System.out.println("Enter another number, or 0 to stop");
            stop = sc.nextInt();
        }
    }
}