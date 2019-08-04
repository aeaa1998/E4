import java.util.ArrayList;

public class FlightsManager{
    ArrayList <Flight>  flights = new ArrayList<Flight>();
    Plane [] planes = {new Plane("200", "Taca"), new Plane("300", "Tacas"), new Plane("400", "Tacacac")};
    Airport [] airports = {new Airport("La aurora"), new Airport("Madrid"), new Airport("Mexico DF")};
    public void FlightsManager(ArrayList<Pilot> pilots, ArrayList<Pilot> copilots){
        for (int i = 0; i < 3; i ++) {
            this.flights.add(new Flight(this.planes[i], this.airports[i], pilots.get(i), copilots.get(i)));
        }
    }

    public Flight getFlight(){
        Scanner myScan = new Scanner(System.in);

        for (int i = 0; i < this.flights.size(); i ++) {
            System.out.println(i + ")" + this.flights.get(i).getName() + "\n");
        }
        int index = Helpers.intPositiveInput(myScan, "Ingrese el numero de vuelo que desea", "Ingrese un valor valido", this.flights.size());
        return this.flights[index - 1];
    }
    public void myMenu(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese que desea hacer");
        String [] options = {"Escoja un vuelo", "Comparar vuelos"};
        String c = Helpers.selectOptions( myScan, options);
        if (c.equalsIgnoreCase(options[0])){
            Flight f = getFlight();
            FlightIA(f);
        }else{
            Flight f= getFlight();
            Flight f2= getFlight();
            System.out.println("Primer vuelo\n");
            f.showPercentages();
            System.out.println("Segundo vuelo\n");
            f2.showPercentages();
        }

    }
    public void FlightIA(Flight flight){
        Scanner myScan = new Scanner(System.in);
        System.out.println("Ingrese que desea hacer");
        String [] options = {"Tener porcentajes", "Llenar info", "grupo con mayor cantidad de pasajeros"};
        String c = Helpers.selectOptions( myScan, options);
        if (c.equalsIgnoreCase(options[0])){
            flight.showPercentages();
        }else if(c.equalsIgnoreCase(options[0])){
            flight.setPassengers();
        }else{
            flight.showHigher();
        }

    }
}