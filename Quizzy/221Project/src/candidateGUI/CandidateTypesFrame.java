package candidateGUI;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CategoryObj.Category;
import PersonInheritance.Candidate;
import SystemandMain.FileReadSys;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CandidateTypesFrame extends JFrame {

	private JPanel contentPane;
	CandidateCtegoriesFrame categoryFrameReferance =  null;
	public ArrayList<Category> categoriesToSend = new ArrayList<>();
	
	public JLabel typeLabel = new JLabel("");
	public JButton typeBtn1 = new JButton("");
	public JButton typeBtn2 = new JButton("");
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public CandidateTypesFrame(CandidateCtegoriesFrame fr, Candidate candidate) {
	    candidateQuestionFrame  qFrame = new candidateQuestionFrame(this,candidate);
		categoryFrameReferance  = fr;
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category Types");
		lblNewLabel.setBounds(0, 0, 0, 0);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 227, 89, 23);
		contentPane.add(back);
		
		JLabel debug = new JLabel("");
		debug.setBounds(136, 231, 232, 14);
		contentPane.add(debug);
		
		
		typeLabel.setBounds(176, 9, 127, 23);
		contentPane.add(typeLabel);
		
		typeBtn1.setVisible(false);
		typeBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date date = new java.util.Date();    
			    candidate.setCandidateActivity(typeBtn1.getText(), date);
				qFrame.title.setText(typeBtn1.getText());
				qFrame.setVisible(true);
				dispose();
				
				
			}
		});
		typeBtn1.setBounds(136, 97, 127, 46);
		contentPane.add(typeBtn1);
		
		typeBtn2.setVisible(false);
		typeBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date date = new java.util.Date();    
			    candidate.setCandidateActivity(typeBtn2.getText(), date);
				qFrame.title.setText(typeBtn2.getText());
				qFrame.setVisible(true);
				dispose();
			}
		});
		typeBtn2.setBounds(136, 169, 127, 46);
		contentPane.add(typeBtn2);
		
		JButton btnNewButton = new JButton("Show Types");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!typeLabel.getText().isEmpty()) {
					
					for(Category obj : FileReadSys.getCategoryArray()) {
						//System.out.println(obj.toString());
						if(obj.getCategoryLevel().equalsIgnoreCase(typeLabel.getText())) {
							categoriesToSend.add(obj);
						}
					}
					
					int i=0;
					for( Category obj :categoriesToSend) {
					 	
						if (i==0) {
							typeBtn1.setText(obj.getCategoryName());
							typeBtn1.setVisible(true);
							//System.out.println(obj.getCategoryName());
							i++;
						}
						else if(i==1) {
							typeBtn2.setText(obj.getCategoryName());
							typeBtn2.setVisible(true);
							i--;
						}
					}
					System.out.println(categoriesToSend);
					
					
				}
				
			}
		});
		btnNewButton.setBounds(136, 43, 127, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		
		//debug.setText(LocalcategoryObjects.size()+"");
		
		//JButton[] buttonArray = new JButton[LocalcategoryObjects.size()];
		
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeBtn1.setVisible(false);
				typeBtn2.setVisible(false);
				typeBtn1.setText("");
				typeBtn2.setText("");
				categoryFrameReferance.setVisible(true);
				dispose();
				
			}
		});
		
	}

	
}
