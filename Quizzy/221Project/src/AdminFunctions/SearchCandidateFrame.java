package AdminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonInheritance.Admin;
import PersonInheritance.Candidate;
import SystemandMain.CandidateSys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchCandidateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SearchCandidateFrame(Admin admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(35, 8, 86, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search Candidate");
		
		btnNewButton.setBounds(131, 7, 124, 23);
		contentPane.add(btnNewButton);
		
		JTextArea candidateArea = new JTextArea();
		candidateArea.setBounds(10, 36, 414, 214);
		contentPane.add(candidateArea);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idField.getText().isEmpty()) {
					candidateArea.setText("Enter an ID to search.");
				}else {
					int id = Integer.parseInt(idField.getText());
					Candidate c1 = CandidateSys.searchCandidate(id);
					candidateArea.setText(c1.toString());
					admin.setAdminActivity("Done search on the candidate", id);
				}
			}
		});
	}
}
