import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInspector {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser("src");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = chooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int characterCount = 0;

            try {
                Scanner fileScanner = new Scanner(selectedFile);

                System.out.println("\nFile Contents:");

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();

                    System.out.println(line);

                    lineCount++;
                    characterCount += line.length();

                    String trimmedLine = line.trim();

                    if (!trimmedLine.isEmpty()) {
                        wordCount += trimmedLine.split("\\s+").length;
                    }
                }

                fileScanner.close();

                System.out.println("\n--- File Summary ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + characterCount);

            } catch (FileNotFoundException e) {
                System.out.println("File could not be found.");
            }

        } else {
            System.out.println("No file selected.");
        }
    }
}
