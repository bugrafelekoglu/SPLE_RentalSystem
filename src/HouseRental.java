import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class HouseRental extends Rental {

    @Override
    public List<RentalObject> categorize(String key){
        
        HouseRentalObject houseObj;
        List<RentalObject> houseList = new ArrayList<RentalObject>();

        for( RentalObject rentalObj: getList() ){
            houseObj = (HouseRentalObject) rentalObj;
            if( houseObj.location.equalsIgnoreCase(key) ){
                houseList.add(houseObj);
            }
        }
        return houseList;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public DefaultListModel printAll( List<RentalObject> list){
    	HouseRentalObject houseObj;
        RentalObject rentalObj;
        DefaultListModel listModel = new DefaultListModel();
        
        for( int i = 0; i < list.size(); i++) {
            rentalObj = list.get(i);
            houseObj = (HouseRentalObject) rentalObj;            
            listModel.addElement(houseObj.toString());
        }
        return listModel;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public DefaultListModel printAllWithSearch( List<RentalObject> list, String query){
    	HouseRentalObject houseObj;
        RentalObject rentalObj;
        DefaultListModel listModel = new DefaultListModel();
             
        for( int i = 0; i < list.size(); i++) {
            rentalObj = list.get(i);
            houseObj = (HouseRentalObject) rentalObj;   
            if(houseObj.location.toLowerCase().contains(query.toLowerCase()) || houseObj.objTitle.toLowerCase().contains(query.toLowerCase())){
            	listModel.addElement(houseObj.toString());
            }
        }
        return listModel;
    }

    @Override
    public void initializeList(){
        String databaseName = "./database/HomeDatabase";
        String line;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(databaseName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] parts;
            while ((line = bufferedReader.readLine()) != null) {
                parts = line.split("-");
                getList().add( new HouseRentalObject(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4])) );
            }            
            bufferedReader.close();            
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
}
