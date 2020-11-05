package cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cinema {
    static int numberOfBoughtTickets = 0;
    static int totalNumberSeats = 0;
    static int currentProfit = 0;
    static int rows = 0;
    static int columns = 0;

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // Write your code here
        MovieTheater movieTheater = new MovieTheater();


        calculateTheaterSize(movieTheater);
        System.out.println();
        boolean isGoing = true;
        movieTheater.fillTheaterS();

        while (isGoing) {
            displayMenu();
            System.out.println();

            int choice = Integer.parseInt(reader.readLine());
            System.out.println();
            switch (choice) {
                case 1:
                    displaySold(movieTheater);
                    System.out.println();
                    break;
                case 2:
                    buyTicket(movieTheater);
                    System.out.println();
                    numberOfBoughtTickets += 1;
                    break;
                case 3:
                    displayStatistics(movieTheater);
                    break;
                case 0:
                    isGoing = false;
                    break;
                default:
            }
        }
    }

    public static void displayStatistics(MovieTheater movieTheater) {
        float percentageSeats = (float) numberOfBoughtTickets / totalNumberSeats * 100;
        System.out.printf("Number of purchased tickets: %d\n", numberOfBoughtTickets);
        System.out.printf("Percentage: %.2f%%\n", percentageSeats);
        System.out.printf("Current income: $%d\n", currentProfit);
        movieTheater.calculateProfit();
        System.out.println();
        System.out.println();
    }

    public static void calculateTheaterSize(MovieTheater movieTheater) throws IOException {
        System.out.println("Enter the number of rows:");
        rows = Integer.parseInt(reader.readLine());
        movieTheater.setRows(rows);

        System.out.println("Enter the number of seats in each row:");
        columns = Integer.parseInt(reader.readLine());
        movieTheater.setColumns(columns);
        totalNumberSeats = rows * columns;
    }

    public static void buyTicket(MovieTheater movieTheater) throws IOException {
        boolean isAvailable = false;
        int youRowChoice = 0;
        int yourSeatChoice = 0;
        while (!isAvailable) {
            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.println("Enter a row number:");
                youRowChoice = Integer.parseInt(reader.readLine());
                System.out.println("Enter a seat number in that row:");
                yourSeatChoice = Integer.parseInt(reader.readLine());
                if (youRowChoice > rows || yourSeatChoice > columns) {
                    System.out.println("\nWrong input!\n");
                } else {
                    isCorrect = true;
                }
            }
            movieTheater.setRowBought(youRowChoice);
            movieTheater.setColumnBought(yourSeatChoice);
            isAvailable = movieTheater.buySeat();
        }
    }

    public static void displaySold(MovieTheater movieTheater) {
        movieTheater.displayFilledTheater();
    }

    public static void displayMenu() {
        for (CinemaMenu choice : CinemaMenu.values()) {
            System.out.println(choice.choice);
        }
    }
}

enum CinemaMenu {
    ONE("1. Show the seats"),
    TWO("2. Buy a ticket"),
    THREE("3. Statistics"),
    FOUR("0. Exit");

    String choice;

    CinemaMenu(String choice) {
        this.choice = choice;
    }
}

