package AdminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonInheritance.Admin;
import SystemandMain.CandidateSys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UpdateCandidateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField scoreField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UpdateCandidateFrame(Admin admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 315, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter User's ID to change its properties");
		lblNewLabel.setBounds(10, 11, 209, 14);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(206, 8, 86, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setBounds(10, 47, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		nameField = new JTextField();
		nameField.setBounds(66, 44, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Score :");
		lblNewLabel_3.setBounds(162, 47, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		scoreField = new JTextField();
		scoreField.setBounds(206, 44, 86, 20);
		contentPane.add(scoreField);
		scoreField.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE CANDIDATE");
		
		btnNewButton.setBounds(10, 84, 282, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 118, 282, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idField.getText().isEmpty() || nameField.getText().isEmpty() || scoreField.getText().isEmpty()) {
					textField.setText("Please fill the nesessary fields.");
				}else {
					int id = Integer.parseInt(idField.getText());
					String name = nameField.getText();
					int score = Integer.parseInt(scoreField.getText());
					
					
					CandidateSys.updateCandidate(name, id, score);
				
					textField.setText("Updated!");
					admin.setAdminActivity("Updated", id);
					try {
						CandidateSys.saveChanges("candidate.txt");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
	}

}
