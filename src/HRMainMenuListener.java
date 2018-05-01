import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HRMainMenuListener implements ActionListener {
	HouseRental hr = HRApp.hr;
	
    private String email = "";
    private String password = "";
    private String searchKey = "";
    
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Login button action performed method
		if(e.getSource()==HRLoginPanel.btnLogin){
			
			// Gets text from input fields when clicked on login
			email = HRLoginPanel.emailField.getText();
			password = new String(HRLoginPanel.passwordField.getPassword());
			
			if(hr.login(email, password)) {
				hr.initializeList();
				HRMainMenuPanel.lblBalance.setText("" + hr.loggedUser.getBalance() + " $");
				HRApp.loginPanel.setVisible(false);
				HRApp.mainMenuPanel.setVisible(true);
			}
			else {
				HRLoginPanel.warningLabel.setVisible(true);
			}
		}		
		else if(e.getSource()==HRMainMenuPanel.btnLogout){
			hr.logout();
			HRApp.loginPanel.setVisible(true);
			HRApp.mainMenuPanel.setVisible(false);
		}
		// TODO add other back buttons
		else if(e.getSource()==HRUploadPanel.btnBackToMenu || e.getSource()==HRShowItemsPanel.btnBackToMenu || e.getSource()==HRCategoriesPanel.btnBackToMenu) {
			HRApp.loginPanel.setVisible(false);
			HRApp.mainMenuPanel.setVisible(true);
			HRApp.uploadPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(false);
			HRApp.categoriesPanel.setVisible(false);
		}
		else if(e.getSource()==HRMainMenuPanel.btnUploadAnItem) {
			HRApp.mainMenuPanel.setVisible(false);
			HRApp.uploadPanel.setVisible(true);
		}
		else if(e.getSource()==HRMainMenuPanel.btnShowAll) {
			HRShowItemsPanel.title.setText("All Houses");
			HRShowItemsPanel.items.setModel(hr.printAll(HouseRental.getList()));
			HRApp.mainMenuPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==HRMainMenuPanel.btnSortItems) {
			hr.sort();
			HRShowItemsPanel.title.setText("Sorted by Price");
			HRShowItemsPanel.items.setModel(hr.printAll(HouseRental.getList()));
			HRApp.mainMenuPanel.setVisible(false);
			HRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==HRMainMenuPanel.btnCategories) {
			HRApp.mainMenuPanel.setVisible(false);
			HRApp.categoriesPanel.setVisible(true);
		}
		// TODO search 
		else if(e.getSource()==HRMainMenuPanel.btnSearch) {
			searchKey = HRMainMenuPanel.searchField.getText();
			
			if (!(searchKey == null || searchKey.trim().isEmpty())) {
				HRMainMenuPanel.searchField.setText("");
				HRShowItemsPanel.title.setText("Results for \"" + searchKey + "\"");
				HRShowItemsPanel.items.setModel(hr.printAllWithSearch(HouseRental.getList(), searchKey));
				HRApp.mainMenuPanel.setVisible(false);
				HRApp.showItemsPanel.setVisible(true);
			}
		}
	}
}