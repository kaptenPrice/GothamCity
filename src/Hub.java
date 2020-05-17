import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class handles the menu and user input. The program will return here until the user chooses to exit.
 */
class Hub {
    private Utility utility = new Utility();
    private Graph graph;
    private Dijkstra dijkstra = new Dijkstra();
    private RandomGraphMaker randomGraphMaker = new RandomGraphMaker();
    private Scanner sc;

    Hub() {
        System.out.println("System online");
    }

    /**
     * The menu allows the user to create new graphs and plan trips, or to exit the program.
     */
    void menu() {

        while (true) {
            System.out.println("\nWelcome to Gotham City! \n Enter '1' to see the city network\n Enter '2' to exit.");
            sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.contains(" ")) {
                System.out.println("Invalid input, please try again.");
                continue;
            }
            switch (input) {
                case "1":
                    graph = randomGraphMaker.createNewGraph();
                    planTrip(graph);
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option, please try again.");
            }

        }
    }

    /**
     * This method takes user input to define source and destination. It makes sure all input values are legitimate choices.
     *
     * @param graph random graph to be passed on to showDistance.
     */
    private void planTrip(Graph graph) {
        if (graph == null) {
            System.out.println("Please create a graph first. ");
            return;
        }
        int start;
        while (true) {
            System.out.println("\nWhere do you want to start? \nPress 0 to return\n");
            for (int i = 1; i <= Constants.NAMES.length; i++) {
                System.out.println(i + " - " + Constants.NAMES[i - 1]);
            }
            try {
                start = sc.nextInt();
                if (start < 0 || start > Constants.NUMBER_OF_VERTICES) {
                    System.out.println(start + " is not a valid stop");

                } else if (start == 0) {
                    return;
                } else break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                sc.next();
            }
        }
        while (true) {
            System.out.println("\nWhere do you want to go? \nPress 0 to return\n");

            for (int i = 1; i <= Constants.NAMES.length; i++) {
                System.out.println(i + " - " + Constants.NAMES[i - 1]);
            }
            try {
                int destination = sc.nextInt();
                if (destination < 0 || destination > Constants.NUMBER_OF_VERTICES) {
                    System.out.println(destination + " is not a valid stop, try again");
                } else if (destination == 0) {
                    return;
                } else {
                    showDistance(graph, start, destination);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                sc.next();
            }
        }
    }

    /**
     * Calls Dijkstra to obtain the result set and calls printDijkstra to print the result.
     *
     * @param graph       random graph to be passed on to Dijkstra.
     * @param start       source vertex defined by user input.
     * @param destination destination vertex defined by user input.
     * @return resultSet with source, destination and the shortest path between them.
     */
    HeapNode[] showDistance(Graph graph, int start, int destination) {
        this.graph = graph;
        HeapNode[] resultSet = dijkstra.dijkstraGetMinDistance(graph, start - 1);
        utility.printDijkstra(resultSet, start - 1, destination - 1);

        return resultSet;
    }
}
