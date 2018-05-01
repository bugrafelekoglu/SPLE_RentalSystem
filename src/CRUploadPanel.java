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
public class CRUploadPanel extends JPanel {

	static JTextField titleField;
	static JFormattedTextField priceField;
	static JTextField modelField;
	static JFormattedTextField kmField;
	static JTextField designField;
	static JButton btnUpload;
	static JButton btnBackToMenu;
	static JLabel lblSuccess;
	static JLabel lblError;
	static JLabel lblWarning;
	
	public CRUploadPanel() {
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		NumberFormatter numberFormatter = new NumberFormatter();
        numberFormatter.setValueClass(Integer.class);
		
		JLabel title = new JLabel("Upload a Car");
		title.setBounds(394, 28, 206, 44);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(260, 92, 474, 387);
		add(panel);
		panel.setLayout(null);
		
		titleField = new JTextField();
		titleField.setBounds(128, 16, 340, 49);
		panel.add(titleField);
		titleField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		titleField.addActionListener(new CRMethodsListener());
		titleField.setColumns(10);
		
		modelField = new JTextField();
		modelField.setBounds(128, 77, 340, 49);
		panel.add(modelField);
		modelField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		modelField.addActionListener(new CRMethodsListener());
		modelField.setColumns(10);
		
		kmField = new JFormattedTextField(numberFormatter);
		kmField.setBounds(128, 196, 206, 49);
		panel.add(kmField);
		kmField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		kmField.addActionListener(new CRMethodsListener());
		kmField.setColumns(10);
		
		designField = new JTextField();
		designField.setBounds(128, 138, 340, 49);
		panel.add(designField);
		designField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		designField.addActionListener(new CRMethodsListener());
		designField.setColumns(10);
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(128, 315, 206, 50);
		panel.add(btnUpload);
		btnUpload.addActionListener(new CRMethodsListener());
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(6, 16, 99, 50);
		panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(6, 76, 99, 50);
		panel.add(lblModel);
		lblModel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(6, 195, 99, 50);
		panel.add(lblKm);
		lblKm.setHorizontalAlignment(SwingConstants.TRAILING);
		lblKm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblDesign = new JLabel("Design");
		lblDesign.setBounds(6, 137, 99, 50);
		panel.add(lblDesign);
		lblDesign.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDesign.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		priceField = new JFormattedTextField(numberFormatter);
		priceField.setBounds(128, 255, 206, 49);
		panel.add(priceField);
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		priceField.addActionListener(new CRMethodsListener());
		priceField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(6, 255, 99, 50);
		panel.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
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
