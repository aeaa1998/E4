import java.util.ArrayList;
import java.util.Scanner;

public class Flight{
    int womenPassengers;
    int menPassengers;
    int childPassengers;
    Plane plane;
    Airport airport;
    Pilot pilot;
    Pilot copilot;

    public Flight(Plane plane, Airport airport, Pilot pilot, Pilot copilot){
        this.plane = plane;
        this.airport = airport;
        this.pilot = pilot;
        this.copilot = copilot;
    }

    public String getName(){
        return this.plane.getModel() + " " + this.airport.getName();
    }
    public void setPassengers(){
        this.askNumber("hombres");
        this.askNumber("mujeres");
        this.askNumber("ninos");
    }

    public void showHigher(){
        if (this.childPassengers == 0 && this.womenPassengers == 0 && this.menPassengers == 0){
            System.out.println("No se han setedo los pasajeros.\n");
        }else{
            if (this.childPassengers > this.womenPassengers){
                if (this.childPassengers > this.menPassengers){
                    System.out.println("La mayoria de pasajeros son ninos.\n");
                }else{
                    System.out.println("La mayoria de pasajeros son hombres.\n");
                }
            }else{
                if (this.childPassengers > this.menPassengers){
                    System.out.println("La mayoria de pasajeros son mujeres.\n");
                }else{
                    if (this.womenPassengers > this.menPassengers){
                        System.out.println("La mayoria de pasajeros son mujeres.\n");
                    }else{
                        System.out.println("La mayoria de pasajeros son hombres.\n");
                    }
                }
            }
        }
    }

    private void askNumber(String type){
        Scanner myScan = new Scanner(System.in);
        int n = Helpers.intPositiveInput(myScan, "Ingrese el numero de pasajeros " + type + " \n", "Ingrese un numero valido");
        if (type == "hombres"){
            this.menPassengers = n;
        }else if (type == "mujeres"){
            this.womenPassengers = n;
        }else{
            this.childPassengers = n;
        }
    }

    public void showPercentages(){
        int total = this.childPassengers + this.womenPassengers + this.menPassengers;
        double childPercentage = Double.valueOf(this.childPassengers);
        double womenPercentage = Double.valueOf(this.womenPassengers);
        double menPercentage = Double.valueOf(this.menPassengers);
        System.out.println("El valor total de pasajeros fue " + total + "\n");
        System.out.println("Procentaje mujeres: " + womenPercentage + "\n");
        System.out.println("Procentaje hombres: " + menPercentage + "\n");
        System.out.println("Procentaje ninos: " + childPercentage + "\n");
        if (this.childPassengers > 7 && this.childPassengers < 16){
            System.out.println("Advertencia la cantidad de ninos fue  " + this.childPassengers + "\n");
        }
    }

    public void fly(){
        System.out.println("Este es el mensaje de saludo del piloto " + pilot.getName() + " vamos a partir vuelo : " + this.getName() + "\n");
    }
}