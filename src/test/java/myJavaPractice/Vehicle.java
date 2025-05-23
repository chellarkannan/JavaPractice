package myJavaPractice;

//Define Interface
interface VehicleInterface {
    void car();
}

//Implement Interface
class Honda implements VehicleInterface{
    public void car(){
        System.out.println("I am Honda");
    }
}

class Audi implements VehicleInterface{
    public void car(){
        System.out.println("I am Audi");
    }
}

public class Vehicle{
    public static void main(String[] args){
        VehicleInterface myVehicle;
        myVehicle = new Honda();
        myVehicle.car();

        myVehicle = new Audi();
        myVehicle.car();
    }
}     