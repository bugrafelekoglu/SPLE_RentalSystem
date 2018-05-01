import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class BRMainMenuPanel extends JPanel{
	
	static JButton 
		btnCategories, 
		btnSortItems, 
		btnShowAll, 
		btnUploadAnItem, 
		btnLogout, 
		btnSearch;
	static JTextField searchField;
	static JLabel lblBalance;
	
	public BRMainMenuPanel(){
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		JLabel title = new JLabel("Main Menu");
		title.setBounds(410, 28, 173, 44);
		title.setVerticalAlignment(SwingConstants.TOP);
		title.setFont(new Font("Tahoma", Font.PLAIN, 36));
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setFocusable(false);
		add(title);
		
		btnCategories = new JButton("Categories");
		btnCategories.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCategories.setBounds(752, 170, 200, 200);
		btnCategories.addActionListener(new BRMainMenuListener());
		add(btnCategories);
		
		btnSortItems = new JButton("Sort by Price");
		btnSortItems.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSortItems.setBounds(514, 170, 200, 200);
		btnSortItems.addActionListener(new BRMainMenuListener());
		add(btnSortItems);
		
		btnShowAll = new JButton("Show All Items");
		btnShowAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShowAll.setBounds(276, 170, 200, 200);
		btnShowAll.addActionListener(new BRMainMenuListener());
		add(btnShowAll);
		
		btnUploadAnItem = new JButton("Upload an item");
		btnUploadAnItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUploadAnItem.setBounds(38, 170, 200, 200);
		btnUploadAnItem.addActionListener(new BRMainMenuListener());
		add(btnUploadAnItem);
		
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBounds(832, 484, 120, 50);
		btnLogout.addActionListener(new BRMainMenuListener());
		add(btnLogout);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(38, 484, 120, 50);
		btnSearch.addActionListener(new BRMainMenuListener());
		add(btnSearch);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchField.setBounds(168, 484, 450, 50);
		searchField.addActionListener(new BRMainMenuListener());
		add(searchField);
		searchField.setColumns(10);
		
		JLabel label = new JLabel("Balance:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(678, 484, 120, 22);
		add(label);
		
		lblBalance = new JLabel("0");
		lblBalance.setForeground(new Color(50, 205, 50));
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBalance.setFocusable(false);
		lblBalance.setBounds(678, 512, 120, 22);
		add(lblBalance);
	}
}
