import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class HRCategoriesPanel extends JPanel{
	
	static JButton 
		btnBackToMenu,
		btnAnkara,
		btnIstanbul, 
		btnIzmir, 
		btnBursa, 
		btnAntalya;
	
	public HRCategoriesPanel(){
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
		btnBackToMenu.addActionListener(new HRMainMenuListener());
		add(btnBackToMenu);
		
		btnAnkara = new JButton("Ankara");
		btnAnkara.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnkara.setBounds(800, 210, 150, 150);
		btnAnkara.addActionListener(new HRMethodsListener());
		add(btnAnkara);
		
		btnIstanbul = new JButton("Ýstanbul");
		btnIstanbul.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIstanbul.setBounds(610, 210, 150, 150);
		btnIstanbul.addActionListener(new HRMethodsListener());
		add(btnIstanbul);
		
		btnIzmir = new JButton("Ýzmir");
		btnIzmir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIzmir.setBounds(420, 210, 150, 150);
		btnIzmir.addActionListener(new HRMethodsListener());
		add(btnIzmir);
		
		btnBursa = new JButton("Bursa");
		btnBursa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBursa.setBounds(230, 210, 150, 150);
		btnBursa.addActionListener(new HRMethodsListener());
		add(btnBursa);
		
		btnAntalya = new JButton("Antalya");
		btnAntalya.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAntalya.setBounds(40, 210, 150, 150);
		btnAntalya.addActionListener(new HRMethodsListener());
		add(btnAntalya);
	}
}
