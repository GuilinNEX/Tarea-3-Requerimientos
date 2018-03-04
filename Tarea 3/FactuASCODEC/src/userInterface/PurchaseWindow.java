package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextField;

import domain.Bank;
import domain.Control;
import domain.Invoice;
import domain.Pay;
import domain.Product;
import domain.Purchase;
import domain.SignIn;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class PurchaseWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String username, Invoice invoice) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseWindow window = new PurchaseWindow(username, invoice);
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
	public PurchaseWindow(String username, Invoice invoice) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username) {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 446);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSeleccioneUnProducto = new JLabel("Seleccione un producto");
		lblSeleccioneUnProducto.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
		lblSeleccioneUnProducto.setBounds(22, 59, 242, 36);
		panel.add(lblSeleccioneUnProducto);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 13));
		lblProducto.setBounds(84, 108, 101, 16);
		panel.add(lblProducto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 138, 101, 22);
		panel.add(comboBox);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 13));
		lblCantidad.setBounds(256, 108, 87, 16);
		panel.add(lblCantidad);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(256, 138, 66, 22);
		panel.add(comboBox_1);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(356, 137, 97, 25);
		panel.add(btnAgregar);
				
		JLabel lblTarjeta = new JLabel("Tarjeta");
		lblTarjeta.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 13));
		lblTarjeta.setBounds(84, 313, 101, 16);
		panel.add(lblTarjeta);
		
		textField = new JTextField();
		textField.setBounds(69, 351, 138, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEfectivomonto = new JLabel("Efectivo(Monto)");
		lblEfectivomonto.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 13));
		lblEfectivomonto.setBounds(315, 309, 138, 25);
		panel.add(lblEfectivomonto);
		
		JButton btnPagarTarjeta = new JButton("Pagar tarjeta");
		btnPagarTarjeta.setBounds(68, 403, 117, 25);
		panel.add(btnPagarTarjeta);
		
		JButton btnPagarEfectivo = new JButton("Pagar efectivo");
		btnPagarEfectivo.setBounds(325, 403, 128, 25);
		panel.add(btnPagarEfectivo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(325, 351, 128, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUser = new JLabel("User: " + username);
		lblUser.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
		lblUser.setBounds(315, 29, 162, 25);
		panel.add(lblUser);
		
		textField_3 = new JTextField();
		textField_3.setBounds(182, 224, 116, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 13));
		lblMonto.setBounds(111, 226, 66, 19);
		panel.add(lblMonto);
		
		JButton btnVerVentas = new JButton("Ver ventas del dia");
		btnVerVentas.setBounds(336, 223, 141, 25);
		panel.add(btnVerVentas);
		
		Invoice invoice = new Invoice();
		ArrayList<Product> list = new ArrayList<Product>();
		list = invoice.fillProducts();
		for (int i = 0; i < list.size(); i++)
		{
			comboBox.addItem(list.get(i).getName());
		}
		for(int j = 1; j < 100; j++)
		{
			comboBox_1.addItem(j);
		}
		Control control = new Control();
		ArrayList<Purchase> purchaseList = control.getPurchaseList();
		ArrayList<Pay> payList = new ArrayList<Pay>();
		
		btnAgregar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String product = comboBox.getSelectedItem().toString();
				int quantity = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				Invoice invoice = new Invoice();
				ArrayList<Product> productList = invoice.fillProducts();
				for(int i = 0; i < productList.size(); i++)
				{
					if(productList.get(i).getName().equals(product))
					{
						Purchase purchase = new Purchase(productList.get(i), quantity);
						purchaseList.add(purchase);
						control.setPurchaseList(purchaseList);
					}
				}
				int amount = amountCalculator(purchaseList, payList.size());
				textField_3.setText(Integer.toString(amount));
			}
		});
		
		//Pago con tarjeta
		btnPagarTarjeta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String cardNumber = textField.getText().toString();
				int amount = Integer.parseInt(textField_3.getText().toString());
				Invoice invoice = new Invoice();
				boolean bool = invoice.callBank(cardNumber, amount);
				if (bool == false)
				{
					JOptionPane.showMessageDialog(frame,
						    "El banco no aprovo la transaccion",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Date today = (Date) Calendar.getInstance().getTime();
					Pay pay = new Pay(purchaseList, today);
					payList.add(pay);
					JOptionPane.showMessageDialog(frame,
						    "Transaccion realizada");
				}
			}
		});
		
		//Pago en efectivo
		btnPagarEfectivo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int amount = Integer.parseInt(textField_1.getText().toString());
				int total = Integer.parseInt(textField_3.getText().toString());
				if (amount < total)
				{
					JOptionPane.showMessageDialog(frame,
						    "Monto debe ser superior al total.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					LocalDate now = LocalDate.now(); //To get the Date type
					Date today = Date.valueOf(now); //To send the Date of today
					Pay pay = new Pay(purchaseList, today); //Contruct the pay objct
					payList.add(pay); //Add to the list
					System.out.println(purchaseList.size() + "Size");
					ArrayList<Purchase> newList = new ArrayList<Purchase>();
					control.setPurchaseList(newList);
					/*int monto = amountCalculator(purchaseList);
					textField_3.setText(Integer.toString(monto));*/
					String vuelto = Integer.toString(amount - total);
					JOptionPane.showMessageDialog(frame,
						    "Su vuelto es de: " + vuelto);
				}
			}
		});
		
		btnVerVentas.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ViewSale view = new ViewSale(payList);
				view.main(payList);
			}
		});
	}
	
	//Calcula el monto total hasta el momento
	public int amountCalculator(ArrayList<Purchase> pPurchaseList, int pSize)
	{
		int total = 0;
		System.out.println(pSize);
		for(int i = pSize; i < pPurchaseList.size(); i++)
		{
			total = total + ((pPurchaseList.get(i).getQuantity())* pPurchaseList.get(i).getProduct().getPrice());
		}
		return total;
	}
}
