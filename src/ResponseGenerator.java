public class ResponseGenerator {
    private SimpleDatabase database;

    public ResponseGenerator(SimpleDatabase database) {
        this.database = database;
    }

    public String generateResponse(String userInput) {
        // Retrieve response from the database
        String response = database.getResponse(userInput);

        if (response == null) {
            return "I'm not sure I understand. Can you say that another way?";
        }

        return response;
    }

    public void learnFromConversation(String userInput, String response) {
        // Store new conversation in the database
        database.insert(userInput, response);
    }

    // Placeholder method for calculating or retrieving confidence level
    public double getConfidence() {
        // Implement logic to calculate or retrieve confidence level
        return 0.5; // Placeholder value, replace with actual implementation
    }
}