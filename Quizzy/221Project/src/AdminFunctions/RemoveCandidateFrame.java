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

public class RemoveCandidateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public RemoveCandidateFrame(Admin admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 190, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(10, 11, 27, 14);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(38, 8, 95, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove Candidate");
		
		btnNewButton.setBounds(23, 60, 123, 23);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 36, 154, 20);
		contentPane.add(textArea);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idField.getText().isEmpty()) {
					textArea.setText("Enter an ID to remove");
				}else {
					int id = Integer.parseInt(idField.getText());
					
					CandidateSys.removeCandidate(id);
					textArea.setText("Removed");
					admin.setAdminActivity("Removed the candidate ", id);
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
