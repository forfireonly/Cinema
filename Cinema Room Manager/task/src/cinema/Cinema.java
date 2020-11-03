package cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cinema {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // Write your code here
        MovieTheater movieTheater = new MovieTheater();
        //movieTheater.displayTheater();

        System.out.println("Enter the number of rows:");
        int  rows = Integer.parseInt(reader.readLine());
        movieTheater.setRows(rows);

        System.out.println("Enter the number of seats in each row:");
        int columns = Integer.parseInt(reader.readLine());
        movieTheater.setColumns(columns);
        //movieTheater.calculateProfit();

        System.out.println();
        movieTheater.displayTheater();
        System.out.println();

        System.out.println("Enter a row number:");
        int youRowChoice = Integer.parseInt(reader.readLine());
        System.out.println("Enter a seat number in that row:");
        int yourSeatChoice = Integer.parseInt(reader.readLine());

        movieTheater.setRowBought(youRowChoice);
        movieTheater.setColumnBought(yourSeatChoice);

        movieTheater.displayTicketPrice();
        movieTheater.fillTheaterS();
        movieTheater.displayFilledTheater();
    }
}