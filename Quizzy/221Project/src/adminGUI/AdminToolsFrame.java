package adminGUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AdminFunctions.AddCandidateFrame;
import AdminFunctions.RemoveCandidateFrame;
import AdminFunctions.SearchCandidateFrame;
import AdminFunctions.UpdateCandidateFrame;
import PersonInheritance.Admin;
import PersonInheritance.Person;
import SystemandMain.CandidateSys;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AdminToolsFrame extends JFrame {

	private JPanel contentPane;
	AdminMainFrame mainFrameReference = null; //Going Up 
	AdminInfoFrame adminInfo = new AdminInfoFrame(this); //Going down
	
	Admin myAdmin = new Admin();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AdminToolsFrame(AdminMainFrame fr ,Admin admin) {
		myAdmin = admin;
		AddCandidateFrame addCandidateFrame = new AddCandidateFrame(myAdmin);
		RemoveCandidateFrame removeCandidateFrame =  new RemoveCandidateFrame(myAdmin);
		SearchCandidateFrame searchFrame = new SearchCandidateFrame(myAdmin);
		UpdateCandidateFrame updateFrame = new UpdateCandidateFrame(myAdmin);
		mainFrameReference = fr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back = new JButton("Back");
		
		back.setBounds(21, 381, 89, 23);
		contentPane.add(back);
		
		JButton addCandidate = new JButton("Add Candidate");
	
		addCandidate.setBounds(72, 73, 255, 23);
		contentPane.add(addCandidate);
		
		JButton removeCandidate = new JButton("Remove Candidate");
	
		removeCandidate.setBounds(72, 123, 252, 23);
		contentPane.add(removeCandidate);
		
		JButton searchCandidate = new JButton("Search Candidate");
	
		searchCandidate.setBounds(72, 183, 255, 23);
		contentPane.add(searchCandidate);
		
		JButton update = new JButton("Update Candidate");
	
		update.setBounds(73, 246, 254, 23);
		contentPane.add(update);
		
		JButton display = new JButton("Display Candidates");
	
		display.setBounds(72, 307, 255, 23);
		contentPane.add(display);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 56, 279, 348);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton info = new JButton("Info");
		
		info.setBounds(243, 381, 89, 23);
		contentPane.add(info);
		
		JButton SaveChanges = new JButton("Save Changes / Write to Log File");
		
		SaveChanges.setBounds(97, 445, 217, 23);
		contentPane.add(SaveChanges);
		
		JButton readCurrentCandidates = new JButton("Read Candidates");
		
		readCurrentCandidates.setBounds(10, 11, 185, 23);
		contentPane.add(readCurrentCandidates);
		
		JButton clear = new JButton("Clear");
		
		clear.setBounds(494, 445, 89, 23);
		contentPane.add(clear);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrameReference.setVisible(true);
				dispose();
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person adminObj = new Admin();
				adminInfo.getInfo().setText(adminObj.getInfo());
				adminInfo.setVisible(true);
				
				
				
			}
		});
		
		readCurrentCandidates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CandidateSys.readCurrentCandidates("candidate.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(CandidateSys.displayCandidates());
				
			}
		});
		
		addCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCandidateFrame.setVisible(true);
			}
		});
		
		removeCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCandidateFrame.setVisible(true);
			}
		});
		
		searchCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFrame.setVisible(true);
				
			}
		});
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFrame.setVisible(true);
				
			}
		});
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
	
		SaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fw;
				try {
					fw = new FileWriter("AdminLog.txt");
					fw.write(admin.displayActivity());
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
