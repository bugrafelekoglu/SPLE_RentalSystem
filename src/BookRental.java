import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.DefaultListModel;
import java.util.List;

public class BookRental extends Rental {

    @Override
    public List<RentalObject> categorize(String key){    	
        BookRentalObject bookObj;
        List<RentalObject> bookList = new ArrayList<RentalObject>();

        for( RentalObject rentalObj: getList() ){
            bookObj = (BookRentalObject) rentalObj;
            if( bookObj.genre.equalsIgnoreCase(key) ){
                bookList.add(bookObj);
            }
        }
        return bookList;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public DefaultListModel printAll( List<RentalObject> list){
        BookRentalObject bookObj;
        RentalObject rentalObj;
        DefaultListModel listModel = new DefaultListModel();
        
        for( int i = 0; i < list.size(); i++) {
            rentalObj = list.get(i);
            bookObj = (BookRentalObject) rentalObj;            
            listModel.addElement(bookObj.toString());
        }
        return listModel;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public DefaultListModel printAllWithSearch( List<RentalObject> list, String query){
    	BookRentalObject bookObj;
        RentalObject rentalObj;
        DefaultListModel listModel = new DefaultListModel();
             
        for( int i = 0; i < list.size(); i++) {
            rentalObj = list.get(i);
            bookObj = (BookRentalObject) rentalObj;   
            if(bookObj.genre.toLowerCase().contains(query.toLowerCase()) || bookObj.author.toLowerCase().contains(query.toLowerCase()) || bookObj.objTitle.toLowerCase().contains(query.toLowerCase())){
            	listModel.addElement(bookObj.toString());
            }
        }
        return listModel;
    }
    
    @SuppressWarnings("resource")
	@Override
    public void initializeList(){
        String databaseName = "./database/BookDatabase";
        String line;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(databaseName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] parts;
            while ((line = bufferedReader.readLine()) != null) {
                parts = line.split("-");
                getList().add( new BookRentalObject(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3] ,parts[4], Integer.parseInt(parts[5])) );
            }            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + databaseName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + databaseName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    
    public boolean downloadBook(BookRentalObject rentedBook){
    	try {
            PrintWriter out = new PrintWriter(rentedBook.getObjTitle()+".txt");
            out.println(rentedBook.getContent());
            out.close();
            return true;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }
}