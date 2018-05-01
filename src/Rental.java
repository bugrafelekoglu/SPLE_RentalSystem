import java.io.*;
import java.util.*;

import javax.swing.DefaultListModel;

public abstract class Rental {
    static private List<RentalObject> list = new ArrayList<RentalObject>();
    String databaseName = "";

    public abstract List<RentalObject> categorize( String key);
    @SuppressWarnings("rawtypes")
	public abstract DefaultListModel printAll( List<RentalObject> list);
    @SuppressWarnings("rawtypes")
	public abstract DefaultListModel printAllWithSearch(List<RentalObject> list, String query);
    public abstract void initializeList();

    protected User loggedUser;
	private BufferedReader bufferedReader;

    static public List<RentalObject> getList(){
        return list;
    }

    // Login is a commonality in this product line.
    // Thus, implemented inside Rental abstract super class.
    boolean login(String mail, String password){

        // Change the path to Users.txt accordingly.
        String usersFile = "./database/Users";
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(usersFile);

            bufferedReader = new BufferedReader(fileReader);

            String[] parts;
            while((line = bufferedReader.readLine()) != null) {
                parts = line.split(" ");
                if( parts[0].equals(mail) && parts[1].equals(password) ) {
                    loggedUser = new User(parts[0]);
                    System.out.println("Successfully logged in.\n");
                    loggedUser.setUserCreditCard(parts[2]);
                    loggedUser.setBalance(Integer.parseInt(parts[3]));
                    bufferedReader.close();
                    return true;
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + usersFile + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + usersFile + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return false;
    }
    
    public void logout() {
    	loggedUser = null;
    }

    public boolean upload( RentalObject rentalObj, int type ){
        String lessorMail = rentalObj.lessorMail;
        String objTitle = rentalObj.objTitle;
        int price = rentalObj.price;

        StringBuilder sb = new StringBuilder();
        sb.append(lessorMail);
        sb.append("-");
        sb.append(objTitle);
        sb.append("-");
        sb.append(price);

        if(type == 1){
            databaseName = "./database/CarDatabase";
            CarRentalObject crObj = (CarRentalObject)rentalObj;
            sb.append("-");
            sb.append(crObj.model);
            sb.append("-");
            sb.append(crObj.km);
            sb.append("-");
            sb.append(crObj.design);
        }
        else if(type == 2){
            databaseName = "./database/HomeDatabase";
            HouseRentalObject hrObj = (HouseRentalObject)rentalObj;
            sb.append("-");
            sb.append(hrObj.location);
            sb.append("-");
            sb.append(hrObj.roomNo);
        }
        else{
            databaseName = "./database/BookDatabase";
            BookRentalObject brObj = (BookRentalObject)rentalObj;
            sb.append("-");
            sb.append(brObj.author);
            sb.append("-");
            sb.append(brObj.genre);
            sb.append("-");
            sb.append(brObj.pageNo);
            sb.append("-");
            sb.append(brObj.path);
        }

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(databaseName, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Constructing the line for each object to be written to database

            String line = sb.toString();

            // Note that write() does not automatically append a newline character.
            bufferedWriter.write(line);
            bufferedWriter.newLine();

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println( "Error writing to file '" + databaseName + "'");
            return false;
        }

        list.add(rentalObj);
        return true;
    }

    public RentalObject rent(int index){
        if( onlinePayment(loggedUser.getBalance(),loggedUser.getUserCreditCard(),list.get(index)) != -1) {
            loggedUser.setBalance(onlinePayment(loggedUser.getBalance(),loggedUser.getUserCreditCard(),list.get(index)));
            System.out.println(loggedUser.getBalance());
            return list.remove(index);
        }

        System.out.println( "balance error" );
        return null;
    }

    public int onlinePayment(int balance, String creditCard, RentalObject objToRent) {
        if( check(creditCard)){
            return objToRent.rent(creditCard, balance);//simulate rental process
        }

        return -1;
    }

    public void sort(){
        Collections.sort(list, new Comparator<RentalObject>() {
            @Override
            public int compare(RentalObject o1, RentalObject o2) {
                if (o1.price > o2.price)
                    return 1;
                else if (o1.price < o2.price)
                    return -1;
                else{
                    return 0;
                }
            }
        });
    }

    /**
     * Luhn Class is an implementation of the Luhn algorithm that checks validity of a credit card number.
     *
     * @author <a href="http://www.chriswareham.demon.co.uk/software/Luhn.java">Chris Wareham</a>
     * @version Checks whether a string of digits is a valid credit card number according to the Luhn algorithm. 1. Starting with the second to last digit and
     *           moving left, double the value of all the alternating digits. For any digits that thus become 10 or more, add their digits together. For example,
     *           1111 becomes 2121, while 8763 becomes 7733 (from (1+6)7(1+2)3). 2. Add all these digits together. For example, 1111 becomes 2121, then 2+1+2+1 is
     *           6; while 8763 becomes 7733, then 7+7+3+3 is 20. 3. If the total ends in 0 (put another way, if the total modulus 10 is 0), then the number is valid
     *           according to the Luhn formula, else it is not valid. So, 1111 is not valid (as shown above, it comes out to 6), while 8763 is valid (as shown
     *           above, it comes out to 20).
     * @param ccNumber
     *            the credit card number to validate.
     * @return <b>true</b> if the number is valid, <b>false</b> otherwise.
     */
    public static boolean check(String ccNumber)//gnu luhn's algorithm
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

}

