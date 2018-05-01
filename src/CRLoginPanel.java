import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;

@SuppressWarnings("serial")
public class CRLoginPanel extends JPanel{

	//Variables and components
	static JButton btnLogin;
	static JTextField emailField;
	static JPasswordField passwordField;
	static JLabel warningLabel;
	private JPanel panel;
	
	public CRLoginPanel(){
		setBounds(0, 0, 994, 571);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(325, 249, 357, 185);
		panel.setLayout(null);
		add(panel);
		
		JLabel title = new JLabel("Welcome to Car Rental System");
		title.setFont(new Font("Tahoma", Font.PLAIN, 50));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFocusable(false);
		title.setBounds(91, 52, 811, 123);
		add(title);
		
		emailField = new JTextField();
		emailField.setText("kucukbays@gmail.com");
		emailField.setBounds(90, 26, 238, 40);
		panel.add(emailField);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 77, 238, 40);
		passwordField.setText("furkanfur");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(passwordField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(12, 40, 68, 14);
		panel.add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(12, 91, 68, 14);
		panel.add(passwordLabel);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(124, 134, 109, 40);
		btnLogin.setFocusPainted(false);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setContentAreaFilled(true);
		btnLogin.addActionListener(new CRMainMenuListener());
		panel.add(btnLogin);
		
		warningLabel = new JLabel("INVALID email address & password");
		warningLabel.setVisible(false);
		warningLabel.setForeground(Color.RED);
		warningLabel.setBackground(Color.WHITE);
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setBounds(325, 445, 357, 28);
		add(warningLabel);
	}
}
