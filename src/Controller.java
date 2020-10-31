
import java.util.Scanner;
import java.util.TreeMap;

public class Controller {

    public static void main(String[] args) {


        int lowestTime = 6000;
        int numberOfRuns = 5000;



         int marines = 0;
         int hellions = 0;
         int medivacs = 0;
         int vikings = 0;
         int siegeTanks = 0;
         int banshees = 0;


         int thors = 0;
         int marauders = 0;

        TreeMap<Integer, Construction> bestOrder = new TreeMap<>();
        TreeMap<Integer, Integer> bestSupply = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many marines to produce?");
        marines = Integer.parseInt(scanner.nextLine());
        System.out.println("How many hellions to produce?");
        hellions = Integer.parseInt(scanner.nextLine());
        System.out.println("How many medivacs to produce?");
        medivacs = Integer.parseInt(scanner.nextLine());
        System.out.println("How many vikings to produce?");
        vikings = Integer.parseInt(scanner.nextLine());
        System.out.println("How many siege tanks to produce?");
        siegeTanks = Integer.parseInt(scanner.nextLine());
        System.out.println("How many banshees to produce?");
        banshees = Integer.parseInt(scanner.nextLine());
        System.out.println("How many thors to produce?");
        thors = Integer.parseInt(scanner.nextLine());
        System.out.println("How many marauders to produce?");
        marauders = Integer.parseInt(scanner.nextLine());

        System.out.println("Working...");

        while(numberOfRuns > 0) {
            StarCraft currentGame = new StarCraft();

            numberOfRuns--;
            Optimiser optimiser = new Optimiser(marines,  hellions, medivacs, vikings, siegeTanks, banshees, thors, marauders, currentGame);

            State currentState = new State(currentGame.STARTINGVESPENE, currentGame.STARTINGMINERALS, 6, 0);

            int Time = 0;

            currentGame.Setup();

            while (!optimiser.checkGoals()) {
                currentGame.Turn(Time, currentState, optimiser);
                Time++;
            }
/*
            System.out.println();
            System.out.println(optimiser.buildOrder);
            System.out.println(currentGame.units);
            System.out.println(currentGame.buildings);*/
            if (lowestTime > Time) {
                lowestTime = Time;
                bestOrder = currentGame.orderBuilding;
                bestSupply = currentGame.orderSupply;
            }

        }
        for (Integer key: bestOrder.keySet()) {
            System.out.println(bestSupply.get(key) +" " +  String.format("%01d:%02d", key / 60, key % 60) + " " + bestOrder.get(key).name);

        }


        System.out.println("Best time: " + lowestTime);

    }

}
