import java.util.ArrayList;
import java.util.Scanner;

public class PilotsManager{
    ArrayList <Pilot>  pilots = new ArrayList<Pilot>();
    public void PilotsManager(){
        String name, String type, float hours
        this.pilots.add(new Pilot("Augusto", "piloto", 1200f));
        this.pilots.add(new Pilot("Pedro", "piloto", 2f));
        this.pilots.add(new Pilot("Javier", "piloto", 200f));
        this.pilots.add(new Pilot("Mejicanos", "copiloto", 300f));
        this.pilots.add(new Pilot("Manuel", "copiloto", 500f));
        this.pilots.add(new Pilot("Mario", "copiloto", 500f));
    }

    public Pilot getPilot(){
        Scanner myScan = new Scanner(System.in);

        ArrayList <Pilot>  pilotsCopy = this.pilots.clone();
        pilotsCopy.removeIf(s -> s.getType() == "copiloto");
        for (int i = 0; i < pilotsCopy.size(); i ++) {
            System.out.println(i + ")" + pilotsCopy.get(i).getName() + "\n");
        }
        int index = Helpers.intPositiveInput(myScan, "Ingrese el numero de piloto que desea", "Ingrese un valor valido", pilotsCopy.size());
        return pilotsCopy[index - 1];
    }

    public boolean hasPilot(){
        ArrayList <Pilot>  pilotsCopy = this.pilots.clone();
        pilotsCopy.removeIf(s -> s.getType() == "copiloto");
        return !pilotsCopy.isEmpty();
    }
    public Pilot getCopilot(){
        Scanner myScan = new Scanner(System.in);

        ArrayList <Pilot>  pilotsCopy = this.pilots.clone();
        pilotsCopy.removeIf(s -> s.getType() != "copiloto");
        for (int i = 0; i < pilotsCopy.size(); i ++) {
            System.out.println(i + ")" + pilotsCopy.get(i).getName() + "\n");
        }
        int index = Helpers.intPositiveInput(myScan, "Ingrese el numero de copiloto que desea", "Ingrese un valor valido", pilotsCopy.size());
        return pilotsCopy[index - 1];
    }

    public boolean hasCopilot(){
        ArrayList <Pilot>  pilotsCopy = this.pilots.clone();
        pilotsCopy.removeIf(s -> s.getType() != "copiloto");
        return !pilotsCopy.isEmpty();
    }

    public void trainPilot(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del piloto");
        String name = scanner.nextLine();
        float hours= Helpers.floatInput(myScan, "Ingrese las horas de vuelo del piloto", "Ingrese un valor valido", 0f);
        this.pilots.add(new Pilot(name, "piloto", hours));
    }
    public void trainCopilot(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del copiloto");
        String name = scanner.nextLine();
        float hours= Helpers.floatInput(myScan, "Ingrese las horas de vuelo del copiloto", "Ingrese un valor valido", 0f);
        this.pilots.add(new Pilot(name, "copiloto", hours));
    }
}