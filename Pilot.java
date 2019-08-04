public class Pilot implements Cloneable{
    String name;
    String type;
    float hours;
    public Pilot(String name, String type, float hours){
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
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}