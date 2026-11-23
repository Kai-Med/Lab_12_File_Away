import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean addAnother = true;
        int idNumber = 1;

        while (addAnother) {

            System.out.println("\nEnter Record Information");

            String firstName = SafeInput.getString(input, "First Name");
            String lastName = SafeInput.getString(input, "Last Name");

            String id = String.format("%06d", idNumber);

            String email = SafeInput.getString(input, "Email");

            int yearofBirth = SafeInput.getRangedInt(
                    input, "Year of Birth", 1000, 9999);

            String record = firstName + ", " + lastName + ", " + id + ", " + email + ", " + yearofBirth;

            records.add(record);

            idNumber++;

            addAnother = SafeInput.getYNConfirm(input, "Would you like to enter another record?");
        }

        System.out.println("\nData Entry Complete");
        System.out.println("Number of records: " + records.size());

        String fileName = SafeInput.getString(
                input, "Enter a name for your CSV file");

        if (!fileName.toLowerCase().endsWith(".csv")) {
            fileName += ".csv";
        }

        File outputFile = new File("src", fileName);

        try {
            PrintWriter Writer = new PrintWriter(new FileWriter(outputFile));

            for (String record : records) {
                Writer.println(record);
            }

            Writer.close();

            System.out.println("\nFile saved successfully");
            System.out.println("Saved to: " + outputFile.getPath());

        } catch (IOException e) {
            System.out.println("Error saving the file.");
            e.printStackTrace();
        }

        input.close();
    }
}