import java.util.*;
import java.io.*;

public class CreateItemFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String itemFile = "items.txt";
        int itemNo;
        String itemDescription;
        int stop = 1;

        HashSet<Integer> usedItemNos = new HashSet<>();

        while (stop != 0) {
            System.out.println("Enter Item Number (three digits) >> ");
            itemNo = sc.nextInt();
           
            if (usedItemNos.contains(itemNo)) {
                System.out.println("Error: Item number already in use. Please enter a different item number.");
                continue; 
            }

            System.out.println("Enter Item Description (up to 20 characters) >> ");
            itemDescription = sc.nextLine();
            if (itemDescription.length() > 20) {
                System.out.println("Error: Item description is too long. Please enter a description with 20 characters or less.");
                continue;
            }

            try {
                FileWriter writer = new FileWriter(itemFile, true);
                writer.write("Item Number : " + itemNo + "\n" + "Item Description : " + itemDescription + "\n");
                writer.close();
                System.out.println("Item information has been saved to file.");
                usedItemNos.add(itemNo);
            } catch (IOException e) {
                System.out.println("Error writing to file.");
                e.printStackTrace();
            }

            System.out.println("Enter another number, or 0 to stop");
            stop = sc.nextInt();
        }
    }
}
