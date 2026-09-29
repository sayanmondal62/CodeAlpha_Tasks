package chatbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private Chatbot chatbot;

    public ChatbotGUI() {

        // Create chatbot object
        chatbot = new Chatbot();

        // Window title
        setTitle("Java AI Chatbot");

        // Window size
        setSize(600, 500);

        // Close application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center window
        setLocationRelativeTo(null);

        // Create GUI
        createGUI();

        // Welcome message
        chatArea.append(
                "Bot: Hello! Welcome to Java AI Chatbot.\n"
        );

        chatArea.append(
                "Bot: How can I help you today?\n\n"
        );
    }

    private void createGUI() {

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Chat area
        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setLineWrap(true);

        chatArea.setWrapStyleWord(true);

        chatArea.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        // Scroll pane
        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // Bottom panel
        JPanel bottomPanel = new JPanel(
                new BorderLayout()
        );

        // Input field
        inputField = new JTextField();

        inputField.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        // Send button
        sendButton = new JButton("Send");

        sendButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        // Add components
        bottomPanel.add(
                inputField,
                BorderLayout.CENTER
        );

        bottomPanel.add(
                sendButton,
                BorderLayout.EAST
        );

        mainPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // Add main panel to window
        add(mainPanel);

        // Send button event
        sendButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        sendMessage();
                    }
                }
        );

        // Press Enter to send
        inputField.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        sendMessage();
                    }
                }
        );
    }

    private void sendMessage() {

        String userInput =
                inputField.getText().trim();

        // Don't send empty message
        if (userInput.isEmpty()) {
            return;
        }

        // Display user message
        chatArea.append(
                "You: " + userInput + "\n"
        );

        // Get chatbot response
        String response =
                chatbot.getResponse(userInput);

        // Display bot response
        chatArea.append(
                "Bot: " + response + "\n\n"
        );

        // Clear input field
        inputField.setText("");

        // Scroll to bottom
        chatArea.setCaretPosition(
                chatArea.getDocument().getLength()
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {

                        ChatbotGUI gui =
                                new ChatbotGUI();

                        gui.setVisible(true);
                    }
                }
        );
    }
}