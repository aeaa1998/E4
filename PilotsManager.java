import java.util.ArrayList;
import java.util.Scanner;

public class PilotsManager{
    ArrayList <Pilot>  pilots = new ArrayList<Pilot>();
    ArrayList <Pilot>  copilots = new ArrayList<Pilot>();
    public PilotsManager(){
        String name;
        String type;
        float hours;
        this.pilots.add(new Pilot("Augusto", "piloto", 1200f));
        this.pilots.add(new Pilot("Pedro", "piloto", 2f));
        this.pilots.add(new Pilot("Javier", "piloto", 200f));
        this.copilots.add(new Pilot("Mejicanos", "copiloto", 300f));
        this.copilots.add(new Pilot("Manuel", "copiloto", 500f));
        this.copilots.add(new Pilot("Mario", "copiloto", 500f));
    }


    public ArrayList<Pilot> getPilots() {
        return this.pilots;
    }

    public ArrayList<Pilot> getCopilots() {

        return this.copilots;
    }

    public void trainPilot(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del piloto");
        String name = myScan.nextLine();
        float hours= Helpers.floatInput(myScan, "Ingrese las horas de vuelo del piloto", "Ingrese un valor valido", 0f);
        this.pilots.add(new Pilot(name, "piloto", hours));
    }
    public void trainCopilot(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del copiloto");
        String name = myScan.nextLine();
        float hours= Helpers.floatInput(myScan, "Ingrese las horas de vuelo del copiloto", "Ingrese un valor valido", 0f);
        this.copilots.add(new Pilot(name, "copiloto", hours));
    }

    public void myMenu(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese que desea hacer");
        String [] options = {"Entrenar un piloto", "Entrenar un copiloto", "Salir del menu de pilotos"};
        boolean on = true;
        while(on){
            String c = Helpers.selectOptions( myScan, options);
            if (c.equalsIgnoreCase(options[0])){
                trainPilot();
            }else if (c.equalsIgnoreCase(options[1])){
                trainCopilot();
            }else{
                on = false;
            }
        }

    }
}