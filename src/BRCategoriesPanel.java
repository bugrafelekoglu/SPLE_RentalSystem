import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class BRCategoriesPanel extends JPanel{
	
	static JButton 
		btnBackToMenu,
		btnBiography,
		btnAutobiography, 
		btnHistory, 
		btnSports, 
		btnNovel;
	
	public BRCategoriesPanel(){
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		JLabel title = new JLabel("Categories");
		title.setBounds(410, 28, 173, 44);
		title.setVerticalAlignment(SwingConstants.TOP);
		title.setFont(new Font("Tahoma", Font.PLAIN, 36));
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setFocusable(false);
		add(title);
		
		btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBackToMenu.setBounds(40, 22, 120, 50);
		btnBackToMenu.addActionListener(new BRMainMenuListener());
		add(btnBackToMenu);
		
		btnBiography = new JButton("Biography");
		btnBiography.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBiography.setBounds(800, 210, 150, 150);
		btnBiography.addActionListener(new BRMethodsListener());
		add(btnBiography);
		
		btnAutobiography = new JButton("Autobiography");
		btnAutobiography.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAutobiography.setBounds(610, 210, 150, 150);
		btnAutobiography.addActionListener(new BRMethodsListener());
		add(btnAutobiography);
		
		btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHistory.setBounds(420, 210, 150, 150);
		btnHistory.addActionListener(new BRMethodsListener());
		add(btnHistory);
		
		btnSports = new JButton("Sports");
		btnSports.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSports.setBounds(230, 210, 150, 150);
		btnSports.addActionListener(new BRMethodsListener());
		add(btnSports);
		
		btnNovel = new JButton("Novel");
		btnNovel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovel.setBounds(40, 210, 150, 150);
		btnNovel.addActionListener(new BRMethodsListener());
		add(btnNovel);
	}
}
