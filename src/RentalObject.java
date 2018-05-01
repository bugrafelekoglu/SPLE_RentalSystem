public class RentalObject {
    String lessorMail;
    String objTitle;
    int price;

    public RentalObject( String lessorMail, String objTitle, int price){
        this.lessorMail = lessorMail;
        this.objTitle = objTitle;
        this.price = price;
    }

    public int rent( String creditCard, int balance){//simulate rental payment
        if( balance - this.price >= 0 ) {
            balance -= this.price;
            return balance;
        }
        return -1;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getObjTitle() {
        return objTitle;
    }

    public void setObjTitle(String objTitle) {
        this.objTitle = objTitle;
    }
    
    public String toString() {
    	return "Title: " + objTitle + " Price: " + price;
    }
}
