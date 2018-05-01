import java.util.Scanner;

public class CarRentalObject extends RentalObject {

    Scanner scan = new Scanner(System.in);
    String model, design;
    int km;
    Insurance insurance;
    boolean isInsured = false;

    public CarRentalObject(String lessorMail, String objTitle, int price,
                           String model, int km, String design){
        super(lessorMail, objTitle, price);
        this.model = model;
        this.km = km;
        this.design = design;
        this.insurance = null;
    }

    public boolean insureCar(int price, String policy) {
        this.insurance = new Insurance( policy, price);
        this.isInsured = true;
        return true;
    }
    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
    
    @Override
    public String toString() {
    	return price + " $ - " + model + " " + design + " - at " + km + " KM - " + "from "  + objTitle;
    }
}
