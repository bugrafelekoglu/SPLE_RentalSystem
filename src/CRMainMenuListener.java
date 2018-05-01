import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRMainMenuListener implements ActionListener {
	CarRental cr = CRApp.cr;
	
    private String email = "";
    private String password = "";
    private String searchKey = "";
    
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Login button action performed method
		if(e.getSource()==CRLoginPanel.btnLogin){
			
			// Gets text from input fields when clicked on login
			email = CRLoginPanel.emailField.getText();
			password = new String(CRLoginPanel.passwordField.getPassword());
			
			if(cr.login(email, password)) {
				cr.initializeList();
				CRMainMenuPanel.lblBalance.setText("" + cr.loggedUser.getBalance() + " $");
				CRApp.loginPanel.setVisible(false);
				CRApp.mainMenuPanel.setVisible(true);
			}
			else {
				CRLoginPanel.warningLabel.setVisible(true);
			}
		}		
		else if(e.getSource()==CRMainMenuPanel.btnLogout){
			cr.logout();
			CRApp.loginPanel.setVisible(true);
			CRApp.mainMenuPanel.setVisible(false);
		}
		// TODO add other back buttons
		else if(e.getSource()==CRUploadPanel.btnBackToMenu || e.getSource()==CRShowItemsPanel.btnBackToMenu || e.getSource()==CRCategoriesPanel.btnBackToMenu || e.getSource()==CRDriverLicensePanel.btnBackToMenu) {
			CRApp.loginPanel.setVisible(false);
			CRApp.mainMenuPanel.setVisible(true);
			CRApp.uploadPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(false);
			CRApp.categoriesPanel.setVisible(false);
			CRApp.driverLicensePanel.setVisible(false);
		}
		else if(e.getSource()==CRMainMenuPanel.btnUploadAnItem) {
			CRApp.mainMenuPanel.setVisible(false);
			CRApp.uploadPanel.setVisible(true);
		}
		else if(e.getSource()==CRMainMenuPanel.btnShowAll) {
			CRShowItemsPanel.title.setText("All Cars");
			CRShowItemsPanel.items.setModel(cr.printAll(CarRental.getList()));
			CRApp.mainMenuPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==CRMainMenuPanel.btnSortItems) {
			cr.sort();
			CRShowItemsPanel.title.setText("Sorted by Price");
			CRShowItemsPanel.items.setModel(cr.printAll(CarRental.getList()));
			CRApp.mainMenuPanel.setVisible(false);
			CRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==CRMainMenuPanel.btnCategories) {
			CRApp.mainMenuPanel.setVisible(false);
			CRApp.categoriesPanel.setVisible(true);
		}
		else if(e.getSource()==CRMainMenuPanel.btnEditDriverLicense) {
			CRApp.mainMenuPanel.setVisible(false);
			CRApp.driverLicensePanel.setVisible(true);
		}
		// TODO search 
		else if(e.getSource()==CRMainMenuPanel.btnSearch) {
			searchKey = CRMainMenuPanel.searchField.getText();
			
			if (!(searchKey == null || searchKey.trim().isEmpty())) {
				CRMainMenuPanel.searchField.setText("");
				CRShowItemsPanel.title.setText("Results for \"" + searchKey + "\"");
				CRShowItemsPanel.items.setModel(cr.printAllWithSearch(CarRental.getList(), searchKey));
				CRApp.mainMenuPanel.setVisible(false);
				CRApp.showItemsPanel.setVisible(true);
			}
		}
	}
}