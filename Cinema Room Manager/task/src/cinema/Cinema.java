package cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cinema {

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

            int choice  = Integer.parseInt(reader.readLine());
            System.out.println();
            switch (choice) {
                case 1:
                    displaySold(movieTheater);
                    System.out.println();
                    break;
                case 2:
                    buyTicket(movieTheater);
                    System.out.println();
                    break;
                case 0:
                    isGoing = false;
                    break;
                default:
            }
        }
    }

    public static void calculateTheaterSize(MovieTheater movieTheater) throws IOException {
        System.out.println("Enter the number of rows:");
        int  rows = Integer.parseInt(reader.readLine());
        movieTheater.setRows(rows);

        System.out.println("Enter the number of seats in each row:");
        int columns = Integer.parseInt(reader.readLine());
        movieTheater.setColumns(columns);
    }

    public static void buyTicket(MovieTheater movieTheater) throws IOException {
        System.out.println("Enter a row number:");
        int youRowChoice = Integer.parseInt(reader.readLine());
        System.out.println("Enter a seat number in that row:");
        int yourSeatChoice = Integer.parseInt(reader.readLine());

        movieTheater.setRowBought(youRowChoice);
        movieTheater.setColumnBought(yourSeatChoice);

        movieTheater.displayTicketPrice();
    }

    public static void displaySold(MovieTheater movieTheater) {
        movieTheater.buySeat();
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
    THREE("0. Exit");

    String choice;

    CinemaMenu(String choice) {
        this.choice = choice;
    }
}

