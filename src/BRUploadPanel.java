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
public class BRUploadPanel extends JPanel {

	static JTextField titleField, genreField, authorField;
	static JFormattedTextField priceField, pageNoField;
	static JButton btnUpload, btnBackToMenu;
	static JLabel lblSuccess, lblError, lblWarning;
	
	public BRUploadPanel() {
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		NumberFormatter numberFormatter = new NumberFormatter();
        numberFormatter.setValueClass(Integer.class);
		
		JLabel title = new JLabel("Upload a Book");
		title.setBounds(381, 28, 231, 44);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(245, 92, 504, 387);
		add(panel);
		panel.setLayout(null);
		
		titleField = new JTextField();
		titleField.setBounds(154, 16, 340, 49);
		panel.add(titleField);
		titleField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		titleField.addActionListener(new BRMethodsListener());
		titleField.setColumns(10);
		
		priceField = new JFormattedTextField(numberFormatter);
		priceField.setBounds(154, 255, 206, 49);
		panel.add(priceField);
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		priceField.addActionListener(new BRMethodsListener());
		priceField.setColumns(10);
		
		authorField = new JTextField();
		authorField.setBounds(154, 76, 340, 49);
		panel.add(authorField);
		authorField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		authorField.addActionListener(new BRMethodsListener());
		authorField.setColumns(10);
		
		pageNoField = new JFormattedTextField(numberFormatter);
		pageNoField.setBounds(154, 196, 206, 49);
		panel.add(pageNoField);
		pageNoField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pageNoField.addActionListener(new BRMethodsListener());
		pageNoField.setColumns(10);
		
		genreField = new JTextField();
		genreField.setBounds(154, 136, 340, 49);
		panel.add(genreField);
		genreField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		genreField.addActionListener(new CRMethodsListener());
		genreField.setColumns(10);
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(154, 326, 206, 50);
		panel.add(btnUpload);
		btnUpload.addActionListener(new BRMethodsListener());
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(6, 16, 138, 50);
		panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(6, 254, 138, 50);
		panel.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(6, 75, 138, 50);
		panel.add(lblAuthor);
		lblAuthor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblPageNo = new JLabel("Page Number");
		lblPageNo.setBounds(6, 195, 138, 50);
		panel.add(lblPageNo);
		lblPageNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPageNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(6, 135, 138, 50);
		panel.add(lblGenre);
		lblGenre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
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
