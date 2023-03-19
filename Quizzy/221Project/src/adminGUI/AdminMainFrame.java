package adminGUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonInheritance.Admin;
import mainFrame.QuizMainFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField pass;
	private JLabel error;
	Admin admin = new Admin();
	QuizMainFrame QuizMainFrameReference = null; //Going Up 
	
	AdminToolsFrame toolFrame =  new AdminToolsFrame(this, admin); //Going down

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminMainFrame(QuizMainFrame fr) {
		QuizMainFrameReference = fr;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin ID:");
		lblNewLabel.setBounds(68, 70, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin PASS:");
		lblNewLabel_1.setBounds(68, 133, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(228, 67, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(228, 130, 86, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton login = new JButton("Login");
	
		login.setBounds(249, 206, 89, 23);
		contentPane.add(login);
		
		error = new JLabel("");
		error.setBounds(82, 181, 199, 14);
		contentPane.add(error);
		
		JButton back = new JButton("Back");
		
		back.setBounds(68, 206, 89, 23);
		contentPane.add(back);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(admin.getAdminId() == Integer.parseInt(id.getText()) && admin.getAdminPass().equalsIgnoreCase( pass.getText())){
					toolFrame.setVisible(true);
					dispose();
				}
				else {
					error.setText("Wrong id or password!!!");
				}
					
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizMainFrameReference.setVisible(true);
				dispose();
				
			}
		});
	}
}
