import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CRMethodsListener implements ActionListener {
    
	CarRental cr = CRApp.cr;
    // Common attributes
    String objTitle;
    int price;
    
    // TYPE 1 represents Car Rental
    final int TYPE = 1;
    
    // CarRentalApp specific variables
    String model, design;
    int km = 0;
    
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Login button action performed method
		if(e.getSource()==CRUploadPanel.btnUpload) {
			// Get field values when clicked on upload button
			objTitle = CRUploadPanel.titleField.getText();
			model = CRUploadPanel.modelField.getText();
			design = CRUploadPanel.designField.getText();
			
			if (objTitle == null || objTitle.trim().isEmpty() || model == null || model.trim().isEmpty() || design == null || design.trim().isEmpty()) {
				CRUploadPanel.lblWarning.setVisible(true);
				CRUploadPanel.lblSuccess.setVisible(false);
				CRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			if (CRUploadPanel.priceField.getValue() != null) {
				price = (int) CRUploadPanel.priceField.getValue();
			}
			else {
				CRUploadPanel.lblWarning.setVisible(true);
				CRUploadPanel.lblSuccess.setVisible(false);
				CRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			if (CRUploadPanel.kmField.getValue() != null) {
				km = (int) CRUploadPanel.kmField.getValue();
			}
			else {
				CRUploadPanel.lblWarning.setVisible(true);
				CRUploadPanel.lblSuccess.setVisible(false);
				CRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			// Uploads the item
			if(cr.upload( new CarRentalObject( cr.loggedUser.getMail(), objTitle, price, model, km, design), TYPE )) {
				CRUploadPanel.lblSuccess.setVisible(true);
				CRUploadPanel.lblError.setVisible(false);
				CRUploadPanel.lblWarning.setVisible(false);
			}
			else {
				CRUploadPanel.lblError.setVisible(true);
				CRUploadPanel.lblSuccess.setVisible(false);
				CRUploadPanel.lblWarning.setVisible(false);
			}
			
			// Cleans text fields
			CRUploadPanel.titleField.setText("");
			CRUploadPanel.priceField.setText("");
			CRUploadPanel.modelField.setText("");
			CRUploadPanel.kmField.setText("");
			CRUploadPanel.designField.setText("");
		}
		else if(e.getSource()==CRShowItemsPanel.btnRent) {
            int selection = CRShowItemsPanel.items.getSelectedIndex();
            if(selection != -1){
            	CarRentalObject rentedCar = (CarRentalObject) cr.rent(selection);
            	
            	if(rentedCar != null) {
            		JOptionPane.showMessageDialog(null, "Rent completed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            		
            		int insuranceSelection = JOptionPane.showConfirmDialog(null, "Do you want insurance?", "Insurance", JOptionPane.YES_NO_OPTION);
                    if (insuranceSelection == JOptionPane.YES_OPTION) {
                    	if(cr.insureCar(rentedCar)) 
                    		JOptionPane.showMessageDialog(null, "Insurance is active now", "Success", JOptionPane.INFORMATION_MESSAGE);
                    	else 
                    		JOptionPane.showMessageDialog(null, "You do not have enough balance for insurance service.", "Insufficient Balance", JOptionPane.WARNING_MESSAGE);
                    }
                    
                    CRMainMenuPanel.lblBalance.setText("" + cr.loggedUser.getBalance() + " $");
                    CRApp.showItemsPanel.setVisible(false);
        			CRApp.mainMenuPanel.setVisible(true);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "You do not have enough balance.", "Insufficient Balance", JOptionPane.WARNING_MESSAGE);
            	}
            }         
		}
		else if(e.getSource()==CRDriverLicensePanel.btnEditLicense) {
			String license = CRDriverLicensePanel.textArea.getText();
			cr.editDriveLicense(license);
			JOptionPane.showMessageDialog(null, "License edited", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource()==CRCategoriesPanel.btnSUV) {
			CRShowItemsPanel.title.setText("SUVs");
			CRShowItemsPanel.items.setModel(cr.printAll(cr.categorize("suv")));
			CRApp.categoriesPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==CRCategoriesPanel.btnHatchback) {
			CRShowItemsPanel.title.setText("Hatchbacks");
			CRShowItemsPanel.items.setModel(cr.printAll(cr.categorize("hatchback")));
			CRApp.categoriesPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(true);		
		}
		else if(e.getSource()==CRCategoriesPanel.btnSedan) {
			CRShowItemsPanel.title.setText("Sedans");
			CRShowItemsPanel.items.setModel(cr.printAll(cr.categorize("sedan")));
			CRApp.categoriesPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==CRCategoriesPanel.btnStationWagon) {
			CRShowItemsPanel.title.setText("Station Wagons");
			CRShowItemsPanel.items.setModel(cr.printAll(cr.categorize("station wagon")));
			CRApp.categoriesPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==CRCategoriesPanel.btnLuxury) {
			CRShowItemsPanel.title.setText("Luxury Cars");
			CRShowItemsPanel.items.setModel(cr.printAll(cr.categorize("luxury car")));
			CRApp.categoriesPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(true);
		}
	}
}