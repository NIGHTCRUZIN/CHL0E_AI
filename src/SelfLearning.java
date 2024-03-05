public class SelfLearning {
    private SimpleDatabase database;
    private ResponseGenerator responseGenerator;

    public SelfLearning(SimpleDatabase database) {
        this.database = database;
        this.responseGenerator = new ResponseGenerator(database);
    }

    public String processInput(String userInput) {
        String response = responseGenerator.generateResponse(userInput);

        if (response.equals("I'm not sure I understand. Can you say that another way?")) {
            learnFromInteraction(userInput, response);
        }

        return response;
    }

    private void learnFromInteraction(String userInput, String response) {
        database.insert(userInput, response);
    }
}

