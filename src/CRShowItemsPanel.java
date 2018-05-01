import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class CRShowItemsPanel extends JPanel {

	static JButton btnBackToMenu, btnRent;
	@SuppressWarnings("rawtypes")
	static JList items;
	static JLabel title;
	
	@SuppressWarnings("rawtypes")
	public CRShowItemsPanel() {
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		title = new JLabel("Items");
		title.setBounds(188, 17, 617, 44);
		title.setVerticalAlignment(SwingConstants.TOP);
		title.setFont(new Font("Tahoma", Font.PLAIN, 36));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFocusable(false);
		add(title);
		
		btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBackToMenu.setBounds(10, 11, 120, 50);
		btnBackToMenu.addActionListener(new CRMainMenuListener());
		add(btnBackToMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 86, 750, 400);
		add(scrollPane);
		
		items = new JList();
		scrollPane.setViewportView(items);
		items.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		items.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnRent = new JButton("Rent");
		btnRent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRent.setBounds(437, 503, 120, 50);
		btnRent.addActionListener(new CRMethodsListener());
		add(btnRent);
	}
}
