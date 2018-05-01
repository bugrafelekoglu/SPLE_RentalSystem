public class BookRentalObject extends RentalObject {
	
	String genre, author;
	int pageNo;
    String path="";
    String content ="";
	
    public BookRentalObject(String lessorMail, String objTitle, int price,  String author, String genre, int pageNo){
        super(lessorMail, objTitle, price);
        this.genre = genre;
        this.pageNo = pageNo;
        this.author = author;
    }
    public BookRentalObject(String lessorMail, String objTitle, int price,  String author, String genre, int pageNo, String path){
        super(lessorMail, objTitle, price);
        this.genre = genre;
        this.pageNo = pageNo;
        this.author = author;
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
    	return price + " $ " + objTitle + " - " + author + " - " + genre + " book - " + pageNo + " pages";
    }
}
