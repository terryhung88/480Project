package guiView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

public class ListView {

	protected JFrame frame;
	
	private JList <String> list;
	protected DefaultListModel<String> listModel;
	
	protected JSplitPane northPane;
	protected JSplitPane southPane;
	protected JLabel lblProperties;
	protected JButton btnSearch;
	protected JButton btnCriteria;
	protected JButton btnLogin;
	protected JButton btnSendEmail;
	protected JButton btnLandLordCreateProperty;
	protected JButton btnLandLordChangePropertyState;
	protected JButton btnLandLordMakePayment;
	protected JButton btnRegUserNotification;
	protected JLabel emptylbl;
	protected JSplitPane rightPane;
	protected JButton btnGetRprt;
	ListView() {
		initializeList();
	}

	public void initializeList() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emptylbl = new JLabel("");
		
		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		
		frame.getContentPane().add(list, BorderLayout.CENTER);
		
		northPane = new JSplitPane();
		frame.getContentPane().add(northPane, BorderLayout.NORTH);
		
		lblProperties = new JLabel("Current Properties");
		lblProperties.setHorizontalAlignment(SwingConstants.CENTER);
		northPane.setRightComponent(lblProperties);
		
		btnLogin = new JButton("           Login         ");
		northPane.setLeftComponent(btnLogin);
		
		southPane = new JSplitPane();
		frame.getContentPane().add(southPane, BorderLayout.SOUTH);
		
		btnSearch = new JButton("        Search         ");
		southPane.setLeftComponent(btnSearch);
		
		btnCriteria = new JButton("Change Search Criteria");
		southPane.setRightComponent(btnCriteria);
		
		rightPane = new JSplitPane();
		rightPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(rightPane, BorderLayout.WEST);
		
		btnSendEmail = new JButton("Send Email");
		rightPane.setLeftComponent(btnSendEmail);
		
		rightPane.setRightComponent(emptylbl);
		
		frame.setVisible(true);
	}
	
	public void initializeRegisteredUser() 
	{
		btnRegUserNotification = new JButton("Subscribe");
		rightPane.setRightComponent(btnRegUserNotification);
		
	}
	
	public void initializeLandLord()
	{
		btnLandLordCreateProperty = new JButton("Create Property");
		southPane.setLeftComponent(btnLandLordCreateProperty);
		
		btnLandLordChangePropertyState = new JButton("Change Property State");
		southPane.setRightComponent(btnLandLordChangePropertyState);
		
		btnLandLordMakePayment = new JButton("Make Payment");
		rightPane.setRightComponent(btnLandLordMakePayment);
		
		
		
	}
	
	public void initializeManager()
	{
		btnGetRprt = new JButton("Get Report");
		southPane.setLeftComponent(btnGetRprt);
		
		btnLandLordChangePropertyState = new JButton("Change Property State");
		southPane.setRightComponent(btnLandLordChangePropertyState);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListView window = new ListView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
