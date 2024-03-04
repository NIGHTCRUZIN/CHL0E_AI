import java.io.IOException;
import java.util.Scanner;

public class SimpleAI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm your personal AI CHL0E. What's on your mind?");

        // Specify the file path for the database
        String filePath = "src/database.txt";

        // Create a SimpleDatabase object with the specified file path
        SimpleDatabase database = new SimpleDatabase(filePath);

        // Create a ResponseGenerator object using the SimpleDatabase
        ResponseGenerator responseGenerator = new ResponseGenerator(database);

        // Provide a file name for the database
        String fileName = "database.txt";

        while (true) {
            String userInput = scanner.nextLine().toLowerCase(); // Convert user input to lowercase
            String response = responseGenerator.generateResponse(userInput);
            System.out.println(response);

            // Check if the response was not found in the database
            if (response.equals("I'm not sure I understand. Can you say that another way?")) {
                // Prompt for feedback and learning
                System.out.println("Was this response helpful? (yes/no)");
                String feedback = scanner.nextLine().toLowerCase();
                if (feedback.equals("no")) {
                    System.out.println("Please provide a better response:");
                    String betterResponse = scanner.nextLine();
                    responseGenerator.learnFromConversation(userInput, betterResponse);
                }
            }

            // Exit loop if user says "bye"
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Goodbye! Have a great day!");
                break;
            }
        }
    }
}
