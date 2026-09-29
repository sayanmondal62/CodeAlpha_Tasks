package chatbot;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ChatbotGUI chatbotGUI = new ChatbotGUI();

            chatbotGUI.setVisible(true);
        });
    }
}