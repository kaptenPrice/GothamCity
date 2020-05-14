import java.util.InputMismatchException;
import java.util.Scanner;


class Hub {
    private Utility utility = new Utility();
    private Graph graph;
    private int start, destination;
    private Dijkstra dijkstra = new Dijkstra();
    Scanner sc;

    Hub() {
        System.out.println("System online");
        menu();
    }

    private void menu() {

        while (true) {

            System.out.println("\nWelcome to RouteCity! \n Enter '1' to create a new network\n Enter '2' to exit.");
            sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.contains(" ")) {
                System.out.println("Invalid input, please try again.");
                continue;
            }
            switch (input) {
                case "1":
                    System.out.println("\n Enter '1' to plan a new trip\n Enter '2' to return.\n");
                    String choice = sc.nextLine();
                    if (choice.contains(" ")) {
                        System.out.println("Invalid input, please try again.");
                        continue;
                    }
                    switch (choice) {
                        case "1":
                            createNewGraph();
                            planTrip();
                            break;
                        case "2":
                            System.out.println("Returning");
                            break;
                        default:
                            System.out.println("Invalid input, please try again.");
                    }
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option, please try again.");
            }

        }
    }

     void createNewGraph() {
        RandomGraphMaker randomGraphMaker = new RandomGraphMaker();
        //graph = randomGraphMaker.secureGraphNodesAreUnique(randomGraphMaker.setGraph()); //secure graph before init graph variable
         graph = randomGraphMaker.setGraph();
         while (!randomGraphMaker.secureGraphNodesAreUnique(graph) || !randomGraphMaker.checkIfGraphIsCoherent(randomGraphMaker.countWeightBetweenNodes(graph))) {
             graph = randomGraphMaker.setGraph();
         }

        utility.printGraph(graph);
    }

     void planTrip() {
        if (graph == null) {
            System.out.println("Please create a graph first. ");
            return;
        }
        System.out.println("\nWhere do you want to start? \nPress 0 to return\n");

        for (int i = 1; i <= Constants.NAMES.length; i++) {
            System.out.println(i + " - " + Constants.NAMES[i - 1]);
        }
        try {
            start = sc.nextInt();
            if (start == 0) return;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
            sc.next();
        }
        System.out.println("\nWhere do you want to go? \nPress 0 to return\n");

        for (int i = 1; i <= Constants.NAMES.length; i++) {
            System.out.println(i + " - " + Constants.NAMES[i - 1]);
        }
        try {
            destination = sc.nextInt();
            if (destination == 0) return;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
            sc.next();
        }
        if (start > 0 && start < 11 && destination > 0 && destination < 11) {
            HeapNode[] resultSet = dijkstra.dijkstraGetMinDistance(graph, start - 1);
            //  dijkstra.checkIfNodesAreConnected(resultSet);
            utility.printDijkstra(resultSet, start - 1, destination - 1);
        }
    }
}
