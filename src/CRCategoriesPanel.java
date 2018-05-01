import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class CRCategoriesPanel extends JPanel{
	
	static JButton 
		btnBackToMenu,
		btnLuxury,
		btnStationWagon, 
		btnSedan, 
		btnHatchback, 
		btnSUV;
	
	public CRCategoriesPanel(){
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
		btnBackToMenu.addActionListener(new CRMainMenuListener());
		add(btnBackToMenu);
		
		btnLuxury = new JButton("Luxury Car");
		btnLuxury.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuxury.setBounds(800, 210, 150, 150);
		btnLuxury.addActionListener(new CRMethodsListener());
		add(btnLuxury);
		
		btnStationWagon = new JButton("Station Wagon");
		btnStationWagon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStationWagon.setBounds(610, 210, 150, 150);
		btnStationWagon.addActionListener(new CRMethodsListener());
		add(btnStationWagon);
		
		btnSedan = new JButton("Sedan");
		btnSedan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSedan.setBounds(420, 210, 150, 150);
		btnSedan.addActionListener(new CRMethodsListener());
		add(btnSedan);
		
		btnHatchback = new JButton("Hatchback");
		btnHatchback.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHatchback.setBounds(230, 210, 150, 150);
		btnHatchback.addActionListener(new CRMethodsListener());
		add(btnHatchback);
		
		btnSUV = new JButton("SUV");
		btnSUV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSUV.setBounds(40, 210, 150, 150);
		btnSUV.addActionListener(new CRMethodsListener());
		add(btnSUV);
	}
}
