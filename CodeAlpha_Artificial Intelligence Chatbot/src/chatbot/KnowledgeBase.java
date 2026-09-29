package chatbot;

import java.util.HashMap;

public class KnowledgeBase {

    private HashMap<String, String> responses;

    public KnowledgeBase() {

        responses = new HashMap<>();

        // Greetings
        responses.put(
                "hello",
                "Hello! How can I help you?"
        );

        responses.put(
                "hi",
                "Hi! Nice to meet you."
        );

        responses.put(
                "hey",
                "Hey! How can I help you today?"
        );

        responses.put(
                "good morning",
                "Good morning! How can I help you?"
        );

        responses.put(
                "good afternoon",
                "Good afternoon! How can I help you?"
        );

        responses.put(
                "good evening",
                "Good evening! How can I help you?"
        );

        // General
        responses.put(
                "how are you",
                "I'm doing great! Thanks for asking."
        );

        responses.put(
                "what is your name",
                "I'm JavaBot, your AI chatbot."
        );

        responses.put(
                "who created you",
                "I was created as a Java-based AI chatbot project."
        );

        responses.put(
                "what can you do",
                "I can answer questions about Java, OOP, programming, databases, and other common topics."
        );

        responses.put(
                "are you a robot",
                "I'm a software-based chatbot designed to communicate with users."
        );

        responses.put(
                "are you an ai",
                "Yes. I'm a simple AI chatbot that uses NLP and rule-based responses."
        );

        // Java
        responses.put(
                "java",
                "Java is a popular object-oriented programming language used to build desktop, web, and enterprise applications."
        );

        responses.put(
                "class",
                "A class is a blueprint or template used to create objects in Java."
        );

        responses.put(
                "object",
                "An object is an instance of a class. It represents a real-world entity or a specific piece of data."
        );

        responses.put(
                "oop",
                "OOP stands for Object-Oriented Programming. Its main concepts are Encapsulation, Inheritance, Polymorphism, and Abstraction."
        );

        responses.put(
                "inheritance",
                "Inheritance allows one class to acquire the properties and methods of another class."
        );

        responses.put(
                "polymorphism",
                "Polymorphism means one interface or method can have different implementations."
        );

        responses.put(
                "encapsulation",
                "Encapsulation means wrapping data and methods together and controlling access using access modifiers."
        );

        responses.put(
                "abstraction",
                "Abstraction means hiding implementation details and showing only the necessary features."
        );

        responses.put(
                "constructor",
                "A constructor is a special method in Java that is automatically called when an object is created."
        );

        responses.put(
                "interface",
                "An interface in Java defines a contract that classes can implement."
        );

        responses.put(
                "exception",
                "An exception is an event that occurs during program execution and can interrupt the normal flow of a program."
        );

        responses.put(
                "arraylist",
                "ArrayList is a resizable array implementation in Java's Collection Framework."
        );

        responses.put(
                "hashmap",
                "HashMap stores data in key-value pairs and provides fast lookup using keys."
        );

        // Programming
        responses.put(
                "programming",
                "Programming is the process of writing instructions that a computer can execute."
        );

        responses.put(
                "variable",
                "A variable is a named memory location used to store data."
        );

        responses.put(
                "loop",
                "A loop is used to repeatedly execute a block of code. Common Java loops are for, while, and do-while."
        );

        responses.put(
                "array",
                "An array is a fixed-size collection of elements of the same data type."
        );

        responses.put(
                "method",
                "A method is a block of code that performs a specific task and can be called when needed."
        );

        responses.put(
                "string",
                "String is a Java class used to represent a sequence of characters."
        );

        responses.put(
                "data structure",
                "A data structure is a way of organizing and storing data efficiently. Examples include arrays, stacks, queues, and linked lists."
        );

        responses.put(
                "algorithm",
                "An algorithm is a step-by-step procedure used to solve a particular problem."
        );

        // Web
        responses.put(
                "html",
                "HTML stands for HyperText Markup Language. It is used to structure web pages."
        );

        responses.put(
                "css",
                "CSS stands for Cascading Style Sheets. It is used to style and design web pages."
        );

        responses.put(
                "javascript",
                "JavaScript is a programming language commonly used to add interactive behavior to web pages."
        );

        // Database
        responses.put(
                "mysql",
                "MySQL is a popular relational database management system that uses SQL."
        );

        responses.put(
                "database",
                "A database is an organized collection of data that can be stored, managed, and retrieved."
        );

        responses.put(
                "sql",
                "SQL stands for Structured Query Language. It is used to communicate with relational databases."
        );

        // Spring
        responses.put(
                "spring boot",
                "Spring Boot is a Java framework used to create production-ready applications quickly."
        );

        responses.put(
                "api",
                "API stands for Application Programming Interface. It allows different software applications to communicate with each other."
        );

        responses.put(
                "rest api",
                "A REST API is an API that follows REST principles and commonly uses HTTP methods such as GET, POST, PUT, and DELETE."
        );

        // Career
        responses.put(
                "internship",
                "An internship provides practical experience and helps students develop professional and technical skills."
        );

        responses.put(
                "resume",
                "A resume is a document that summarizes your education, skills, projects, experience, and achievements."
        );

        responses.put(
                "interview",
                "An interview is a conversation where an employer evaluates a candidate's skills, experience, and suitability for a role."
        );

        responses.put(
                "soft skills",
                "Soft skills include communication, teamwork, problem solving, accountability, and time management."
        );

        // Conversation
        responses.put(
                "thank you",
                "You're welcome!"
        );

        responses.put(
                "thanks",
                "You're welcome!"
        );

        responses.put(
                "bye",
                "Goodbye! Have a great day."
        );

        responses.put(
                "good night",
                "Good night! Have a great day ahead."
        );
    }

    public String getResponse(String input) {

        // First try exact matching
        if (responses.containsKey(input)) {
            return responses.get(input);
        }

        // Keyword-based matching
        for (String keyword : responses.keySet()) {

            if (input.contains(keyword)) {

                return responses.get(keyword);
            }
        }

        return null;
    }
}