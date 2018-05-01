public class RentalFactory {

    public static Rental getRental(String type){
        if("HouseRental".equalsIgnoreCase(type)){
            return new HouseRental();
        }
        else if("CarRental".equalsIgnoreCase(type)){
            return new CarRental();
        }
        else if("BookRental".equalsIgnoreCase(type)){
            return new BookRental();
        }
        else{
            return null;
        }
    }

}
