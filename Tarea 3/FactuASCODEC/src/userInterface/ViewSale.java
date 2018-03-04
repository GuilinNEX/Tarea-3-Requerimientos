package userInterface;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;

import domain.Pay;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ViewSale {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<Pay> payList) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSale window = new ViewSale(payList);
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
	public ViewSale(ArrayList<Pay> pPayList) {
		initialize(pPayList);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Pay> pPayList) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 432, 253);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		System.out.println(pPayList.size());
		int total = 0;
		LocalDate now = LocalDate.now();
		Date today = Date.valueOf(now);
		String date = today.toString();
		System.out.print(today + " hola " + pPayList.get(0).getDate());
		for(int j = 0; j < pPayList.get(0).getPruchaseList().size(); j++)
		{
			if((pPayList.get(0).getDate()).toString().contains(date))
			{
				total = total + ((pPayList.get(0).getPruchaseList().get(j).getProduct().getPrice())*pPayList.get(0).getPruchaseList().get(j).getQuantity());
				textArea.append(pPayList.get(0).getPruchaseList().get(j).getProduct().getName() + "   " + pPayList.get(0).getPruchaseList().get(j).getQuantity());
				textArea.append("\n");
			}
		}
		textArea.append("~~~~~~~~~~~~~~~~" + "\n");
		textArea.append("TOTAL: " + Integer.toString(total));
	}
}
