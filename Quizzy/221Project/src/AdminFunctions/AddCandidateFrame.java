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
import javax.swing.JTextArea;

public class AddCandidateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddCandidateFrame(Admin admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 306, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name ");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(44, 8, 118, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(172, 11, 14, 14);
		contentPane.add(lblNewLabel_1);
		
		idField = new JTextField();
		idField.setBounds(196, 8, 86, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Candidate");
		
		btnNewButton.setBounds(10, 36, 272, 23);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 66, 270, 40);
		contentPane.add(textArea);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name;
				int id;
				
				if(idField.getText().isEmpty() || nameField.getText().isEmpty()) {
					textArea.setText("Please fill the necessary fields.");
				}else {
					name = nameField.getText();
					id = Integer.parseInt(idField.getText());
					CandidateSys.addCandidate(name, id, "Candidate");
					textArea.setText("Added");
					admin.setAdminActivity("Added a new Candidate", id);
					
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
