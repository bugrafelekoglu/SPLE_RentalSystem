import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BRMethodsListener implements ActionListener {
    
	BookRental br = BRApp.br;
    // Common attributes
    String objTitle;
    int price;
    
    // TYPE 3 represents Book Rental
    final int TYPE = 3;
    
    // BookRentalApp specific variables
    String author, genre;
    int pageNo = 0;
    
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Login button action performed method
		if(e.getSource()==BRUploadPanel.btnUpload) {
			// Get field values when clicked on upload button
			objTitle = BRUploadPanel.titleField.getText();
			author = BRUploadPanel.authorField.getText();
			genre = BRUploadPanel.genreField.getText();
			
			if (objTitle == null || objTitle.trim().isEmpty() || author == null || author.trim().isEmpty() || genre == null || genre.trim().isEmpty()) {
				BRUploadPanel.lblWarning.setVisible(true);
				BRUploadPanel.lblSuccess.setVisible(false);
				BRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			if (BRUploadPanel.priceField.getValue() != null) {
				price = (int) BRUploadPanel.priceField.getValue();
			}
			else {
				BRUploadPanel.lblWarning.setVisible(true);
				BRUploadPanel.lblSuccess.setVisible(false);
				BRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			if (BRUploadPanel.pageNoField.getValue() != null) {
				pageNo = (int) BRUploadPanel.pageNoField.getValue();
			}
			else {
				BRUploadPanel.lblWarning.setVisible(true);
				BRUploadPanel.lblSuccess.setVisible(false);
				BRUploadPanel.lblError.setVisible(false);
				return;
			}
			
			// Uploads the item
			if(br.upload(new BookRentalObject(br.loggedUser.getMail(), objTitle, price, author, genre, pageNo), TYPE )) {
				BRUploadPanel.lblSuccess.setVisible(true);
				BRUploadPanel.lblError.setVisible(false);
				BRUploadPanel.lblWarning.setVisible(false);
			}
			else {
				BRUploadPanel.lblError.setVisible(true);
				BRUploadPanel.lblSuccess.setVisible(false);
				BRUploadPanel.lblWarning.setVisible(false);
			}
			
			// Cleans text fields
			BRUploadPanel.titleField.setText("");
			BRUploadPanel.priceField.setText("");
			BRUploadPanel.authorField.setText("");
			BRUploadPanel.pageNoField.setText("");
			BRUploadPanel.genreField.setText("");
		}
		else if(e.getSource()==BRShowItemsPanel.btnRent) {
            int selection = BRShowItemsPanel.items.getSelectedIndex();
            if(selection != -1){
            	BookRentalObject rentedBook = (BookRentalObject) br.rent(selection);
            	
            	if(rentedBook != null) {
            		JOptionPane.showMessageDialog(null, "Rent completed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            		
            		int downloadSelection = JOptionPane.showConfirmDialog(null, "Do you want to download the book?", "Download", JOptionPane.YES_NO_OPTION);
                    if (downloadSelection == JOptionPane.YES_OPTION) {
                    	if(br.downloadBook(rentedBook)) 
                    		JOptionPane.showMessageDialog(null, "Your book is downloaded", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
            		
                    BRMainMenuPanel.lblBalance.setText("" + br.loggedUser.getBalance() + " $");
                    BRApp.showItemsPanel.setVisible(false);
        			BRApp.mainMenuPanel.setVisible(true);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "You do not have enough balance.", "Insufficient Balance", JOptionPane.WARNING_MESSAGE);
            	}
            }         
		}
		else if(e.getSource()==BRCategoriesPanel.btnBiography) {
			BRShowItemsPanel.title.setText("Biography");
			BRShowItemsPanel.items.setModel(br.printAll(br.categorize("biography")));
			BRApp.categoriesPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==BRCategoriesPanel.btnAutobiography) {
			BRShowItemsPanel.title.setText("Autobiography");
			BRShowItemsPanel.items.setModel(br.printAll(br.categorize("autobiography")));
			BRApp.categoriesPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(true);		
		}
		else if(e.getSource()==BRCategoriesPanel.btnHistory) {
			BRShowItemsPanel.title.setText("History");
			BRShowItemsPanel.items.setModel(br.printAll(br.categorize("history")));
			BRApp.categoriesPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==BRCategoriesPanel.btnSports) {
			BRShowItemsPanel.title.setText("Sports");
			BRShowItemsPanel.items.setModel(br.printAll(br.categorize("sports")));
			BRApp.categoriesPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==BRCategoriesPanel.btnNovel) {
			BRShowItemsPanel.title.setText("Novel");
			BRShowItemsPanel.items.setModel(br.printAll(br.categorize("novel")));
			BRApp.categoriesPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(true);
		}
	}
}