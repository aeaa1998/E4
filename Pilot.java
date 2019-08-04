public class Pilot{
    String name, type;
    float hours;
    public void Pilot(String name, String type, float hours){
        this.name = name;
        this.type = type;
        this.hours = hours;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}