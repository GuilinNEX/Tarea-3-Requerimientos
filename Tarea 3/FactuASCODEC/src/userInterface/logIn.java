package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import domain.Invoice;
import domain.SignIn;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class logIn {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn window = new logIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("  Username");
		lblUsername.setBounds(140, 39, 144, 23);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 20));
		
		textField = new JTextField();
		textField.setBounds(158, 75, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("  Password");
		lblPassword.setBounds(140, 110, 144, 23);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 20));
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(158, 146, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(180, 203, 73, 25);
		panel.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String username = textField.getText().toString();
				String password = textField_1.getText().toString();
				Invoice invoice = new Invoice();
				ArrayList<SignIn> list = new ArrayList<SignIn>();
				list = invoice.fillSignIn();
				for(int i = 0; i < list.size(); i++)
				{
					if(list.get(i).getUsername().toString().equals(username) && list.get(i).getPassword().toString().equals(password))
					{
						PurchaseWindow window = new PurchaseWindow(username, invoice);
						window.main(username, invoice);
					}
				}
			}
		});
		
	}
}
