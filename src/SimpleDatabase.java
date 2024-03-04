import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SimpleDatabase {
    private Map<String, String> data;
    private File file;

    public SimpleDatabase(String fileName) {
        data = new HashMap<>();
        file = new File(fileName);
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    data.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insert(String key, String value) {
        data.put(key.toLowerCase(), value);
        saveDataToFile();
    }

    public String getResponse(String userInput) {
        return data.get(userInput.toLowerCase());
    }

    // Other methods for managing data...
}