import java.util.Scanner;

public class Chl0eAI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm your personal AI CHL0E. What's on your mind?");

        // Specify the file path for the database
        String filePath = "src/database.txt";

        // Create a SimpleDatabase object with the specified file path
        SimpleDatabase database = new SimpleDatabase(filePath);

        // Create a SelfLearningAI object using the SimpleDatabase
        SelfLearning selfLearningAI = new SelfLearning(database);

        while (true) {
            String userInput = scanner.nextLine().toLowerCase(); // Convert user input to lowercase
            String response = selfLearningAI.processInput(userInput);
            System.out.println(response);

            // Exit loop if user says "bye"
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Goodbye! Have a great day!");
                break;
            }
        }
    }
}
