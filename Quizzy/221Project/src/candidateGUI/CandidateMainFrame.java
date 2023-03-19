package candidateGUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonInheritance.Candidate;
import SystemandMain.CandidateSys;
import mainFrame.QuizMainFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CandidateMainFrame extends JFrame {
	
	QuizMainFrame quizMainFrameReferance = null;//going up
	Candidate candidate = new Candidate();
	CandidateCtegoriesFrame categoryFrame = new CandidateCtegoriesFrame(this,candidate); //going down
	
	private JPanel contentPane;
	private JTextField nickname;
	private JButton back;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public CandidateMainFrame(QuizMainFrame fr)  {
		
		quizMainFrameReferance =  fr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO QUIZZY");
		lblNewLabel.setBounds(158, 11, 217, 62);
		contentPane.add(lblNewLabel);
		
		nickname = new JTextField();
	
		nickname.setBounds(175, 127, 86, 20);
		contentPane.add(nickname);
		nickname.setColumns(10);
		
		back = new JButton("Back");
	
		back.setBounds(172, 213, 89, 23);
		contentPane.add(back);
		
		JTextField id = new JTextField();
		id.setBounds(175, 70, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pick a Nickname:");
		lblNewLabel_1.setBounds(63, 130, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pick a ID:");
		lblNewLabel_2.setBounds(63, 73, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel error = new JLabel("");
		error.setBounds(121, 173, 174, 14);
		contentPane.add(error);
		
		nickname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					if(nickname.getText().isEmpty() || id.getText().isEmpty()) {
						error.setText("Fill the necessary fields!");
					}else {
						CandidateSys.addCandidate(nickname.getText(),Integer.parseInt(id.getText()),"candidate");
						try {
							CandidateSys.saveChanges("candidate.txt");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						categoryFrame.setVisible(true);
						dispose();
					}
						
					
				
			}
		}});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizMainFrameReferance.setVisible(true);
				dispose();
				
			}
		});
	}
}
