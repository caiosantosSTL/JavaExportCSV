import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.io.*;


public class VentanaExportTXT {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaExportTXT window = new VentanaExportTXT();
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
	public VentanaExportTXT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 571, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Export TESTE");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(189, 16, 159, 45);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(104, 123, 341, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tf = textField.getText();
				String url = "/Users/Roberto/Desktop/txtxtx/JavaTXT/teste4.csv";
				File f = new File(url);
				
				try {
					FileWriter fw = new FileWriter(f);
					for (int i = 0; i <= 10; i++) {
						fw.write(tf+" \n");
					}

					fw.flush();
					fw.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Nao foi");
				}

				System.out.println("Vim printar txt");
			}
		});
		btnNewButton.setBounds(209, 270, 115, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
