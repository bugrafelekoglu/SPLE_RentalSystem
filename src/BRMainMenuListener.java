import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BRMainMenuListener implements ActionListener {
	BookRental br = BRApp.br;
	
    private String email = "";
    private String password = "";
    private String searchKey = "";
    
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Login button action performed method
		if(e.getSource()==BRLoginPanel.btnLogin){
			
			// Gets text from input fields when clicked on login
			email = BRLoginPanel.emailField.getText();
			password = new String(BRLoginPanel.passwordField.getPassword());
			
			if(br.login(email, password)) {
				br.initializeList();
				BRMainMenuPanel.lblBalance.setText("" + br.loggedUser.getBalance() + " $");
				BRApp.loginPanel.setVisible(false);
				BRApp.mainMenuPanel.setVisible(true);
			}
			else {
				BRLoginPanel.warningLabel.setVisible(true);
			}
		}		
		else if(e.getSource()==BRMainMenuPanel.btnLogout){
			br.logout();
			BRApp.loginPanel.setVisible(true);
			BRApp.mainMenuPanel.setVisible(false);
		}
		// TODO add other back buttons
		else if(e.getSource()==BRUploadPanel.btnBackToMenu || e.getSource()==BRShowItemsPanel.btnBackToMenu || e.getSource()==BRCategoriesPanel.btnBackToMenu) {
			BRApp.loginPanel.setVisible(false);
			BRApp.mainMenuPanel.setVisible(true);
			BRApp.uploadPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(false);
			BRApp.categoriesPanel.setVisible(false);
		}
		else if(e.getSource()==BRMainMenuPanel.btnUploadAnItem) {
			BRApp.mainMenuPanel.setVisible(false);
			BRApp.uploadPanel.setVisible(true);
		}
		else if(e.getSource()==BRMainMenuPanel.btnShowAll) {
			BRShowItemsPanel.title.setText("All Books");
			BRShowItemsPanel.items.setModel(br.printAll(BookRental.getList()));
			BRApp.mainMenuPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==BRMainMenuPanel.btnSortItems) {
			br.sort();
			BRShowItemsPanel.title.setText("Sorted by Price");
			BRShowItemsPanel.items.setModel(br.printAll(BookRental.getList()));
			BRApp.mainMenuPanel.setVisible(false);
			BRApp.showItemsPanel.setVisible(true);
		}
		else if(e.getSource()==BRMainMenuPanel.btnCategories) {
			BRApp.mainMenuPanel.setVisible(false);
			BRApp.categoriesPanel.setVisible(true);
		}
		// TODO search 
		else if(e.getSource()==BRMainMenuPanel.btnSearch) {
			searchKey = BRMainMenuPanel.searchField.getText();
			
			if (!(searchKey == null || searchKey.trim().isEmpty())) {
				BRMainMenuPanel.searchField.setText("");
				BRShowItemsPanel.title.setText("Results for \"" + searchKey + "\"");
				BRShowItemsPanel.items.setModel(br.printAllWithSearch(BookRental.getList(), searchKey));
				BRApp.mainMenuPanel.setVisible(false);
				BRApp.showItemsPanel.setVisible(true);
			}
		}
	}
}