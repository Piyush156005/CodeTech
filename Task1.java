
import java.io.*;

 class Task1 {

   /**
    * This method demonstrates writing data to a file.
    * It writes some text data to a specified file. If the file already exists, it overwrites the file.
    *
    * @param filename The name of the file to write to.
    * @param data The data to be written to the file.
    */
   public static void writeToFile(String filename, String data) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
           // Writing data to the file
           writer.write(data);
           System.out.println("Data written successfully to " + filename);
       } catch (IOException e) {
           System.out.println("An error occurred while writing to the file: " + e.getMessage());
       }
   }

   /**
    * This method demonstrates reading data from a file.
    * It reads the entire content of the file and displays it to the console.
    *
    * @param filename The name of the file to read from.
    */
   public static void readFromFile(String filename) {
       try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
           String line;
           // Reading and displaying the file content line by line
           while ((line = reader.readLine()) != null) {
               System.out.println(line);
           }
       } catch (IOException e) {
           System.out.println("An error occurred while reading the file: " + e.getMessage());
       }
   }
   


   /**
    * This method demonstrates appending data to an existing file.
    * If the file does not exist, it creates a new file.
    *
    * @param filename The name of the file to append data to.
    * @param data The data to be appended to the file.
    */
   public static void appendToFile(String filename, String data) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
           // Appending data to the file
           writer.write(data);
           writer.newLine(); // To add a new line after the appended text
           System.out.println("Data appended successfully to " + filename);
       } catch (IOException e) {
           System.out.println("An error occurred while appending to the file: " + e.getMessage());
       }
   }
   


   /**
    * This method demonstrates deleting a file.
    * If the file exists, it will be deleted.
    *
    * @param filename The name of the file to delete.
    */
   public static void deleteFile(String filename) {
       File file = new File(filename);
       if (file.delete()) {
           System.out.println("File " + filename + " deleted successfully.");
       } else {
           System.out.println("Failed to delete the file. It may not exist.");
       }
   }

   /**
    * Main method that demonstrates various file operations.
    */
   public static void main(String[] args) {
       String filename = "sample.txt";
       
       // Writing data to the file
       writeToFile(filename, "Hello, this is the first line of the file.");

       // Reading data from the file
       System.out.println("\nReading the file contents:");
       readFromFile(filename);

       // Appending data to the file
       appendToFile(filename, "This is the second line appended to the file.");

       // Reading data again after appending
       System.out.println("\nReading the updated file contents:");
       readFromFile(filename);

       // Deleting the file this will delete the file
       deleteFile(filename);
   }
}

