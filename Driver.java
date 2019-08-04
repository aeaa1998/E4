import java.util.ArrayList;
import java.util.Scanner;
class Driver{
    public static void main(String[] args) throws CloneNotSupportedException{
        Scanner myScan = new Scanner(System.in);
        PilotsManager pilotManager = new PilotsManager();
        boolean on = true;
        String [] menu = {"Pilotos", "Vuelos de hoy"};
        String [] m = {"Si", "No"};

        while (on){
            System.out.println("Que desea hacer hoy.\n");

            String c = Helpers.selectOptions(myScan, menu);
            if (c.equalsIgnoreCase(menu[1])){
               FlightsManager flightsManager = new FlightsManager(pilotManager.getPilots(), pilotManager.getCopilots());
               flightsManager.myMenu();
            }else{
                pilotManager.myMenu();
            }
            System.out.println("Desea seguir con un dia mas.\n");
            String c2 = Helpers.selectOptions(myScan, m);
            if (c2.equalsIgnoreCase(m[1])){
                on = false;
            }

        }

    }
}