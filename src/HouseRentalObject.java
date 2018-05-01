

public class HouseRentalObject extends RentalObject {

		String location;
		int roomNo;
	
	    public HouseRentalObject(String lessorMail, String objTitle, int price, String location, int roomNo){
	        super(lessorMail, objTitle, price);
	        this.location = location;
	        this.roomNo = roomNo;
	    }	    
	    
	    @Override
	    public String toString() {
	    	return price + " $ - " + objTitle + " in " + location + " with " + roomNo + " rooms";
	    }
}
