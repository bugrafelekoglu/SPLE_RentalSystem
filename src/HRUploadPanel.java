import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;
import java.awt.Color;

@SuppressWarnings("serial")
public class HRUploadPanel extends JPanel {

	static JTextField titleField;
	static JFormattedTextField priceField;
	static JTextField locationField;
	static JFormattedTextField roomNoField;
	static JButton btnUpload;
	static JButton btnBackToMenu;
	static JLabel lblSuccess;
	static JLabel lblError;
	static JLabel lblWarning;
	
	public HRUploadPanel() {
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		NumberFormatter numberFormatter = new NumberFormatter();
        numberFormatter.setValueClass(Integer.class);
		
		JLabel title = new JLabel("Upload a House");
		title.setBounds(371, 28, 251, 44);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(231, 124, 531, 322);
		add(panel);
		panel.setLayout(null);
		
		titleField = new JTextField();
		titleField.setBounds(176, 16, 340, 49);
		panel.add(titleField);
		titleField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		titleField.addActionListener(new HRMethodsListener());
		titleField.setColumns(10);
		
		priceField = new JFormattedTextField(numberFormatter);
		priceField.setBounds(176, 197, 206, 49);
		panel.add(priceField);
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		priceField.addActionListener(new HRMethodsListener());
		priceField.setColumns(10);
		
		locationField = new JTextField();
		locationField.setBounds(176, 77, 340, 49);
		panel.add(locationField);
		locationField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		locationField.addActionListener(new HRMethodsListener());
		locationField.setColumns(10);
		
		roomNoField = new JFormattedTextField(numberFormatter);
		roomNoField.setBounds(176, 138, 206, 49);
		panel.add(roomNoField);
		roomNoField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		roomNoField.addActionListener(new HRMethodsListener());
		roomNoField.setColumns(10);
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(176, 257, 206, 50);
		panel.add(btnUpload);
		btnUpload.addActionListener(new HRMethodsListener());
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(6, 16, 160, 50);
		panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(6, 197, 160, 50);
		panel.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(6, 76, 160, 50);
		panel.add(lblLocation);
		lblLocation.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblRoomNo = new JLabel("Room Number");
		lblRoomNo.setBounds(6, 137, 160, 50);
		panel.add(lblRoomNo);
		lblRoomNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblSuccess = new JLabel("Item successfully added");
		lblSuccess.setForeground(new Color(50, 205, 50));
		lblSuccess.setBounds(402, 493, 189, 22);
		lblSuccess.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSuccess.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSuccess.setVisible(false);	
		add(lblSuccess);
		
		lblError = new JLabel("Item cannot added");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(422, 493, 150, 22);
		lblError.setHorizontalAlignment(SwingConstants.TRAILING);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblError.setVisible(false);	
		add(lblError);
		
		lblWarning = new JLabel("One or more field is empty");
		lblWarning.setForeground(new Color(255, 165, 0));
		lblWarning.setBounds(391, 493, 212, 22);
		lblWarning.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWarning.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWarning.setVisible(false);	
		add(lblWarning);
	}
}
