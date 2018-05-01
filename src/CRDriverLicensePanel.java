import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CRDriverLicensePanel extends JPanel {

	static JButton btnBackToMenu, btnEditLicense;
	static JTextArea textArea;
	static JLabel title;
	
	public CRDriverLicensePanel() {
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		title = new JLabel("Driver License");
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
		
		btnEditLicense = new JButton("Edit License");
		btnEditLicense.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditLicense.setBounds(422, 503, 150, 50);
		btnEditLicense.addActionListener(new CRMethodsListener());
		add(btnEditLicense);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setBounds(197, 110, 600, 350);
		add(textArea);
	}
}
