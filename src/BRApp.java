import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BRApp extends JFrame {
	
	//Variables and Components
	static JFrame frame;
	static JPanel contentPane;
	static BRMainMenuPanel mainMenuPanel;
	static BRUploadPanel uploadPanel;
	static BRShowItemsPanel showItemsPanel;
	static BRCategoriesPanel categoriesPanel;
	static BRLoginPanel loginPanel;
	
	static BookRental br = (BookRental)RentalFactory.getRental("BookRental");
	
	//Main Method
	public static void main(String[] args) throws IOException{
		//Adding Frame
		frame = new BRApp();
		frame.setVisible(true);
	}
	
	//Main Frame Constructor
	public BRApp() throws IOException{
		//Frame Properties
		setTitle("Book Rental System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		
		//Content Pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 1000, 600));
		contentPane.setLayout(null);
		
		//Initialize Panels
		loginPanel = new BRLoginPanel();
		mainMenuPanel = new BRMainMenuPanel();
		uploadPanel = new BRUploadPanel();
		showItemsPanel = new BRShowItemsPanel();
		categoriesPanel = new BRCategoriesPanel();
		
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
