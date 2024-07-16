/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 *  @author Kritish Soni/ Student ID: 991720996
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, Player> players = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the War Card Game!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Thank you for playing!");
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already taken. Please try again.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        users.put(username, password);
        players.put(username, new Player(username));
        System.out.println("Registration successful!");
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("Username not found. Please register first.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (!users.get(username).equals(password)) {
            System.out.println("Incorrect password. Please try again.");
            return;
        }

        System.out.println("Login successful!");
        startGame(scanner, username);
    }

    private static void startGame(Scanner scanner, String username) {
        System.out.println("Waiting for another player to join...");

        Player player1 = players.get(username);
        Player player2 = null;

        while (player2 == null) {
            System.out.print("Enter the username of the second player: ");
            String opponentUsername = scanner.nextLine();

            if (!players.containsKey(opponentUsername)) {
                System.out.println("Username not found. Please register the second player first.");
                continue;
            }

            if (opponentUsername.equals(username)) {
                System.out.println("You cannot play against yourself. Please enter a different username.");
                continue;
            }

            player2 = players.get(opponentUsername);
        }

        System.out.println("Starting game between " + player1.getUsername() + " and " + player2.getUsername());
        GameFactory gameFactory = new GameFactory(player1, player2);
        gameFactory.playGame();
    }
}