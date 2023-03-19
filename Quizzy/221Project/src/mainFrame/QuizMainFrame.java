package mainFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminGUI.AdminMainFrame;
import candidateGUI.CandidateMainFrame;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizMainFrame extends JFrame {

	private JPanel contentPane;
	AdminMainFrame adminFrame = new AdminMainFrame(this); //Going down
	CandidateMainFrame candidateFrame =  new CandidateMainFrame(this);
	

	
	public QuizMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel QuizImage = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/quizzylogo.jpeg"));
		QuizImage.setIcon(img);
		QuizImage.setBounds(188, 26, 202, 328);
		contentPane.add(QuizImage);
		
		JLabel lblNewLabel = new JLabel("How would you Like To Register?");
		lblNewLabel.setBounds(199, 340, 202, 14);
		contentPane.add(lblNewLabel);
		
		JButton admin = new JButton("Admin");
		
		admin.setBounds(112, 389, 139, 38);
		contentPane.add(admin);
		
		JButton candidate = new JButton("Candidate");
		
		candidate.setBounds(362, 389, 125, 38);
		contentPane.add(candidate);
		
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminFrame.setVisible(true);
				dispose();
			}
		});
		candidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				candidateFrame.setVisible(true);
				dispose();
			}
		});
	}
}