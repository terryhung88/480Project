package guiView;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewPropertyView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel propertyForm;
	
	private JLabel lblPropertyType;
	protected JTextField txtPropertyType;
	private JLabel lblBathrooms;
	protected JTextField txtBathrooms;
	private JLabel lblBedrooms;
	protected JTextField txtBedrooms;
	private JLabel lblFurnished;
	protected JTextField txtFurnished;
	private JLabel lblQuadrant;
	protected JTextField txtQuadrant;
	private JLabel lblAddress;
	protected JTextField txtAddress;
	
	protected JButton btnAddProperty;

	
	public NewPropertyView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 490);
		propertyForm = new JPanel();
		propertyForm.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(propertyForm);
		propertyForm.setLayout(null);
		
		
		lblPropertyType = new JLabel("Property Type: ");
		lblPropertyType.setBounds(40, 69, 128, 27);
		propertyForm.add(lblPropertyType);
		
		txtPropertyType = new JTextField();
		txtPropertyType.setBounds(141, 69, 237, 27);
		propertyForm.add(txtPropertyType);
		
		lblBathrooms = new JLabel("Number of Bathrooms: ");
		lblBathrooms.setBounds(40, 119, 149, 27);
		propertyForm.add(lblBathrooms);
		
		txtBathrooms = new JTextField();
		txtBathrooms.setBounds(182, 119, 196, 27);
		propertyForm.add(txtBathrooms);
		
		lblBedrooms = new JLabel("Number of Bedrooms: ");
		lblBedrooms.setBounds(40, 157, 128, 27);
		propertyForm.add(lblBedrooms);
		
		txtBedrooms = new JTextField();
		txtBedrooms.setBounds(182, 155, 196, 27);
		propertyForm.add(txtBedrooms);
		
		lblFurnished = new JLabel("Is it furnished? (True/False) ");
		lblFurnished.setBounds(40, 236, 188, 27);
		propertyForm.add(lblFurnished);
		
		txtFurnished = new JTextField();
		txtFurnished.setBounds(238, 236, 140, 27);
		propertyForm.add(txtFurnished);
		
		lblQuadrant = new JLabel("Quadrant ");
		lblQuadrant.setBounds(40, 198, 128, 27);
		propertyForm.add(lblQuadrant);
		
		txtQuadrant = new JTextField();
		txtQuadrant.setBounds(141, 198, 237, 27);
		propertyForm.add(txtQuadrant);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(61, 274, 128, 27);
		propertyForm.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(141, 274, 237, 27);
		propertyForm.add(txtAddress);
		
		btnAddProperty = new JButton("Add Property");
		btnAddProperty.setBounds(158,337,128,27);
		propertyForm.add(btnAddProperty);
		
		
		
		this.setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPropertyView frame = new NewPropertyView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
