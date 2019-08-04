import java.util.ArrayList;
import java.util.Scanner;

public class FlightsManager{
    ArrayList <Flight>  flights = new ArrayList<Flight>();
    Plane [] planes = new Plane[3];
    Airport [] airports = new Airport[3];
    public FlightsManager(ArrayList<Pilot> pilots, ArrayList<Pilot> copilots){
        this.planes[0] = new Plane("200", "Taca");
        this.planes[1] = new Plane("300", "Tacas");
        this.planes[2] =  new Plane("400", "Tacacac");
        this.airports[0] =  new Airport("La aurora");
        this.airports[1] =  new Airport("Madrid");
        this.airports[2] =  new Airport("Mexico DF");
        for (int i = 0; i < 3; i ++) {
            Flight fnew =  new Flight(this.planes[i], this.airports[i], pilots.get(i), copilots.get(i));
            this.flights.add(fnew);
        }
    }


    public Flight getFlight(){
        Scanner myScan = new Scanner(System.in);

        for (int i = 0; i < this.flights.size(); i ++) {
            System.out.println((i+1) + ")" + this.flights.get(i).getName() + "\n");
        }
        int index = Helpers.intPositiveInput(myScan, "Ingrese el numero de vuelo que desea", "Ingrese un valor valido", this.flights.size());
        return this.flights.get(index - 1);
    }
    public void FlightIA(Flight flight){
        Scanner myScan = new Scanner(System.in);
        boolean on = true;
        while (on){
            System.out.println("Ingrese que desea hacer");
            String [] options = {"Tener porcentajes", "Llenar info", "grupo con mayor cantidad de pasajeros", "salir"};
            String c = Helpers.selectOptions( myScan, options);

            if (c.equalsIgnoreCase(options[0])){
                flight.showPercentages();
            }else if(c.equalsIgnoreCase(options[1])){
                flight.setPassengers();
            }else if (c.equalsIgnoreCase(options[3])){
                flight.showHigher();
            }else{
                on  = false;
            }
        }

    }
    public void myMenu(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese que desea hacer");
        String [] options = {"Escoja un vuelo", "Comparar vuelos", "Salir del menu de vuelos"};
        boolean on = true;
        while(on){
            String c = Helpers.selectOptions( myScan, options);
            if (c.equalsIgnoreCase(options[0])){
                Flight f = getFlight();
                FlightIA(f);
            }else if (c.equalsIgnoreCase(options[1])){
                Flight f= getFlight();
                Flight f2= getFlight();
                System.out.println("Primer vuelo\n");
                f.showPercentages();
                System.out.println("Segundo vuelo\n");
                f2.showPercentages();
            }else{
                for (int i = 0; i < 3; i ++) {
                    this.flights.get(i).fly();
                }
                on = false;
            }
        }

    }

}
