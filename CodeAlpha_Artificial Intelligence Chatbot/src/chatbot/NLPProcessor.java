package chatbot;

public class NLPProcessor {

    // Clean and normalize user input
    public String processInput(String input) {

        // Convert to lowercase
        input = input.toLowerCase();

        // Remove punctuation
        input = input.replaceAll("[^a-zA-Z0-9 ]", "");

        // Remove extra spaces
        input = input.trim().replaceAll("\\s+", " ");

        return input;
    }

    // Check whether input contains a keyword
    public boolean containsKeyword(String input, String keyword) {

        return input.contains(keyword);
    }
}