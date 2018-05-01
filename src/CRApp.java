import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CRApp extends JFrame {
	
	//Variables and Components
	static JFrame frame;
	static JPanel contentPane;
	static CRMainMenuPanel mainMenuPanel;
	static CRUploadPanel uploadPanel;
	static CRShowItemsPanel showItemsPanel;
	static CRCategoriesPanel categoriesPanel;
	static CRDriverLicensePanel driverLicensePanel;
	static CRLoginPanel loginPanel;
	
	static CarRental cr = (CarRental)RentalFactory.getRental("CarRental");
	
	//Main Method
	public static void main(String[] args) throws IOException{
		//Adding Frame
		frame = new CRApp();
		frame.setVisible(true);
	}
	
	//Main Frame Constructor
	public CRApp() throws IOException{
		//Frame Properties
		setTitle("Car Rental System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		
		//Content Pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 1000, 600));
		contentPane.setLayout(null);
		
		//Initialize Panels
		loginPanel = new CRLoginPanel();
		mainMenuPanel = new CRMainMenuPanel();
		uploadPanel = new CRUploadPanel();
		showItemsPanel = new CRShowItemsPanel();
		categoriesPanel = new CRCategoriesPanel();
		driverLicensePanel = new CRDriverLicensePanel();
		
		//Sets the visibility of panels
		loginPanel.setVisible(true);
		mainMenuPanel.setVisible(false);
		uploadPanel.setVisible(false);
		showItemsPanel.setVisible(false);
		categoriesPanel.setVisible(false);
		driverLicensePanel.setVisible(false);
		
		//Adding panels to the frame
		setContentPane(contentPane);
		getContentPane().add(loginPanel);
		getContentPane().add(mainMenuPanel);
		getContentPane().add(uploadPanel);
		getContentPane().add(showItemsPanel);
		getContentPane().add(categoriesPanel);
		getContentPane().add(driverLicensePanel);
	}
}
