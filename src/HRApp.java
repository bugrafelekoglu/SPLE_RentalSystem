import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class HRApp extends JFrame {
	
	//Variables and Components
	static JFrame frame;
	static JPanel contentPane;
	static HRMainMenuPanel mainMenuPanel;
	static HRUploadPanel uploadPanel;
	static HRShowItemsPanel showItemsPanel;
	static HRCategoriesPanel categoriesPanel;
	static HRLoginPanel loginPanel;
	
	static HouseRental hr = (HouseRental)RentalFactory.getRental("HouseRental");
	
	//Main Method
	public static void main(String[] args) throws IOException{
		//Adding Frame
		frame = new HRApp();
		frame.setVisible(true);
	}
	
	//Main Frame Constructor
	public HRApp() throws IOException{
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
		loginPanel = new HRLoginPanel();
		mainMenuPanel = new HRMainMenuPanel();
		uploadPanel = new HRUploadPanel();
		showItemsPanel = new HRShowItemsPanel();
		categoriesPanel = new HRCategoriesPanel();
		
		//Sets the visibility of panels
		loginPanel.setVisible(true);
		mainMenuPanel.setVisible(false);
		uploadPanel.setVisible(false);
		showItemsPanel.setVisible(false);
		categoriesPanel.setVisible(false);
		
		//Adding panels to the frame
		setContentPane(contentPane);
		getContentPane().add(loginPanel);
		getContentPane().add(mainMenuPanel);
		getContentPane().add(uploadPanel);
		getContentPane().add(showItemsPanel);
		getContentPane().add(categoriesPanel);
	}
}
