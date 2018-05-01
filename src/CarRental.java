import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.DefaultListModel;

public class CarRental extends Rental{
	
	private BufferedReader bufferedReader;
	
    @Override
    public List<RentalObject> categorize(String key){
        CarRentalObject crObj;
        List<RentalObject> carList = new ArrayList<RentalObject>();

        for( RentalObject rentalObj: getList() ){
            crObj = (CarRentalObject) rentalObj;
            if( crObj.design.equalsIgnoreCase(key) ){
                carList.add(crObj);
            }
        }
        return carList;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public DefaultListModel printAll( List<RentalObject> list){
        CarRentalObject crObj;
        RentalObject rentalObj;
        DefaultListModel listModel = new DefaultListModel();
        
        for( int i = 0; i < list.size(); i++) {
            rentalObj = list.get(i);
            crObj = (CarRentalObject) rentalObj;            
            listModel.addElement(crObj.toString());
        }
        return listModel;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public DefaultListModel printAllWithSearch( List<RentalObject> list, String query){
        CarRentalObject crObj;
        RentalObject rentalObj;
        DefaultListModel listModel = new DefaultListModel();
             
        for( int i = 0; i < list.size(); i++) {
            rentalObj = list.get(i);
            crObj = (CarRentalObject) rentalObj;   
            if(crObj.model.toLowerCase().contains(query.toLowerCase()) || crObj.design.toLowerCase().contains(query.toLowerCase()) || crObj.objTitle.toLowerCase().contains(query.toLowerCase())){
            	listModel.addElement(crObj.toString());
            }
        }
        return listModel;
    }

    @Override
    public void initializeList(){
        String databaseName = "./database/CarDatabase";
        String line;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(databaseName);

            // Always wrap FileReader in BufferedReader.
            bufferedReader = new BufferedReader(fileReader);

            String[] parts;
            while ((line = bufferedReader.readLine()) != null) {
                parts = line.split("-");
                getList().add( new CarRentalObject(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4]), parts[5]) );
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
    public void editDriveLicense(String license){
        super.loggedUser.setDriverLicense(license);
    }

    public boolean insureCar(CarRentalObject rentedCar) {
        int newBalance = super.loggedUser.getBalance() - (int)(rentedCar.getPrice() * 0.10);
    	if(newBalance >= 0) {
        	super.loggedUser.setBalance(newBalance);
        	return true;
        }
    	else
    		return false;
    }
}
