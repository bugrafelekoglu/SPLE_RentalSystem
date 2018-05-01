import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class HRMethodsListener implements ActionListener {
    
	HouseRental hr = HRApp.hr;
    // Common attributes
    String objTitle;
    int price;
    
    // TYPE 2 represents House Rental
    final int TYPE = 2;
    
    // HouseRentalApp specific variables
    String location;
    int roomNo = 0;
    
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Login button action performed method
		if(e.getSource()==HRUploadPanel.btnUpload) {
			// Get field values when clicked on upload button
			objTitle = HRUploadPanel.titleField.getText();
			location = HRUploadPanel.locationField.getText();
			
			if (objTitle == null || objTitle.trim().isEmpty() || location == null || location.trim().isEmpty()) {
				HRUploadPanel.lblWarning.setVisible(true);
				HRUploadPanel.lblSuccess.setVisible(false);
				HRUploadPanel.lblError.setVisible(false);
				return;
			}

			if (HRUploadPanel.priceField.getValue() != null) {
				price = (int) HRUploadPanel.priceField.getValue();
			}
			else {
				HRUploadPanel.lblWarning.setVisible(true);
				HRUploadPanel.lblSuccess.setVisible(false);
				HRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			if (HRUploadPanel.roomNoField.getValue() != null) {
				roomNo = (int) HRUploadPanel.roomNoField.getValue();
			}
			else {
				HRUploadPanel.lblWarning.setVisible(true);
				HRUploadPanel.lblSuccess.setVisible(false);
				HRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			// Uploads the item
			if(hr.upload( new HouseRentalObject( hr.loggedUser.getMail(), objTitle, price, location, roomNo), TYPE )) {
				HRUploadPanel.lblSuccess.setVisible(true);
				HRUploadPanel.lblError.setVisible(false);
				HRUploadPanel.lblWarning.setVisible(false);
			}
			else {
				HRUploadPanel.lblError.setVisible(true);
				HRUploadPanel.lblSuccess.setVisible(false);
				HRUploadPanel.lblWarning.setVisible(false);
			}
			
			// Cleans text fields
			HRUploadPanel.titleField.setText("");
			HRUploadPanel.priceField.setText("");
			HRUploadPanel.locationField.setText("");
			HRUploadPanel.roomNoField.setText("");
		}
		else if(e.getSource()==HRShowItemsPanel.btnRent) {
            int selection = HRShowItemsPanel.items.getSelectedIndex();
            if(selection != -1){
            	HouseRentalObject rentedHouse = (HouseRentalObject) hr.rent(selection);
            	
            	if(rentedHouse != null) {
            		JOptionPane.showMessageDialog(null, "Rent completed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    HRMainMenuPanel.lblBalance.setText("" + hr.loggedUser.getBalance() + " $");
                    HRApp.showItemsPanel.setVisible(false);
        			HRApp.mainMenuPanel.setVisible(true);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "You do not have enough balance.", "Insufficient Balance", JOptionPane.WARNING_MESSAGE);
            	}
            }         
		}
		else if(e.getSource()==HRCategoriesPanel.btnAnkara) {
			HRShowItemsPanel.title.setText("Ankara Houses");
			HRShowItemsPanel.items.setModel(hr.printAll(hr.categorize("ankara")));
			HRApp.categoriesPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==HRCategoriesPanel.btnIstanbul) {
			HRShowItemsPanel.title.setText("Istanbul Houses");
			HRShowItemsPanel.items.setModel(hr.printAll(hr.categorize("istanbul")));
			HRApp.categoriesPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(true);		
		}
		else if(e.getSource()==HRCategoriesPanel.btnIzmir) {
			HRShowItemsPanel.title.setText("Izmir Houses");
			HRShowItemsPanel.items.setModel(hr.printAll(hr.categorize("izmir")));
			HRApp.categoriesPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==HRCategoriesPanel.btnBursa) {
			HRShowItemsPanel.title.setText("Bursa Houses");
			HRShowItemsPanel.items.setModel(hr.printAll(hr.categorize("bursa")));
			HRApp.categoriesPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==HRCategoriesPanel.btnAntalya) {
			HRShowItemsPanel.title.setText("Antalya Houses");
			HRShowItemsPanel.items.setModel(hr.printAll(hr.categorize("antalya")));
			HRApp.categoriesPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(true);
		}
	}
}