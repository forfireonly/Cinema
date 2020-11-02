package cinema;

public class MovieTheater {
    int rows = 7;
    int columns = 8;
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
