package candidateGUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonInheritance.Candidate;
import PersonInheritance.Person;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CandidateInfoFrame extends JFrame {

	private JPanel contentPane;
	CandidateCtegoriesFrame ctegoriesReferanceFrame;//going up

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CandidateInfoFrame(CandidateCtegoriesFrame fr) {
		ctegoriesReferanceFrame = fr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel info = new JLabel("");
		info.setBounds(58, 36, 215, 93);
		contentPane.add(info);
		Person candidateObj = new Candidate();
		info.setText(candidateObj.getInfo());
		
		
		
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctegoriesReferanceFrame.setVisible(true);
				dispose();
			}
		});
		ok.setBounds(101, 145, 89, 23);
		contentPane.add(ok);
	}

}
