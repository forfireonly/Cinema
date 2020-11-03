package cinema;

public class MovieTheater {
    private int rows;
    private int columns;
    String[][] shapeTheater;

    private int rowBought;
    private int columnBought;

    public void setRowBought(int rowBought) {
        if (rowBought <= 0) {
            throw new IllegalArgumentException();
        }
        this.rowBought = rowBought;
    }

    public void setColumnBought(int columnBought) {
        if (columnBought <= 0) {
            throw new IllegalArgumentException();
        }
        this.columnBought = columnBought;
    }

    public void fillTheaterS(){
        shapeTheater = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                shapeTheater[i][j] = "S ";
                if (i == rowBought - 1  && j == columnBought - 1) {
                    shapeTheater[i][j] = "B ";
                }

            }
        }
    }

    public void setRows(int rows) {
        if (rows <= 0) {
            throw new IllegalArgumentException();
        }
        this.rows = rows;
    }

    public void setColumns(int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException();
        }
        this.columns = columns;
    }

    public void calculateProfit() {
        int size = rows * columns;
        int profit = 0;

        if (rows * columns <= 60) {
            profit = size * 10;
        } else {
            if (rows % 2 == 0) {
                profit = (rows / 2 * 10 + rows / 2 * 8) * columns;
            } else {
                profit = (rows / 2 * 10 + (rows / 2 + 1) * 8) * columns;
            }
        }
        System.out.printf("Total income:\n$%d", profit);
    }

    public void displayTicketPrice() {
        int size = rows * columns;
        int ticketPrice = 0;
        if (rows * columns <= 60) {
            ticketPrice = 10;
        } else {
            if (rowBought <= rows / 2) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        System.out.printf("\nTicket price: $%d\n", ticketPrice);
    }

    public void displayFilledTheater() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < columns; j++) {
                System.out.print(shapeTheater[i][j]);
            }
            System.out.println();
        }
    }

    public void displayTheater() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= columns; j++) {
                System.out.print("S" + " ");
            }
            System.out.println();
        }
    }
}
