package chatbot;

public class Chatbot {

    private NLPProcessor nlpProcessor;
    private KnowledgeBase knowledgeBase;

    public Chatbot() {

        nlpProcessor = new NLPProcessor();
        knowledgeBase = new KnowledgeBase();
    }

    public String getResponse(String userInput) {

        // Process user input
        String processedInput =
                nlpProcessor.processInput(userInput);

        // Get response from knowledge base
        String response =
                knowledgeBase.getResponse(processedInput);

        // If answer is found
        if (response != null) {

            return response;
        }

        // If answer is not found
        return "Sorry, I don't understand that. "
                + "Can you ask me something else?";
    }
}