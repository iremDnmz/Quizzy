package candidateGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CategoryObj.Category;
import PersonInheritance.Candidate;
import QuestionObj.Question;
import SystemandMain.CandidateSys;
import SystemandMain.FileReadSys;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class candidateQuestionFrame extends JFrame {

	private JPanel contentPane;
	CandidateTypesFrame  referenceFrame = null;
	ArrayList<Question> questions = new ArrayList<>();
	HashMap<Integer, String> control = new HashMap<>();
	int score = 0;
	ScoreFrame scoreF = new ScoreFrame(this);
	
	JLabel title = new JLabel("");
	ButtonGroup grp1 = new ButtonGroup();
	ButtonGroup grp2 = new ButtonGroup();
	ButtonGroup grp3 = new ButtonGroup();
	ButtonGroup grp4 = new ButtonGroup();
	ButtonGroup grp5 = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public candidateQuestionFrame(CandidateTypesFrame fr, Candidate candidate) {
		referenceFrame = fr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 686);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton showQuestionsBtn = new JButton("Show Questions");
		showQuestionsBtn.setBounds(235, 11, 269, 23);
		contentPane.add(showQuestionsBtn);
		
		JLabel firstQuestion = new JLabel("");
		firstQuestion.setBounds(64, 57, 694, 14);
		contentPane.add(firstQuestion);
		
		JRadioButton oneA = new JRadioButton("");
		oneA.setBackground(Color.WHITE);
		oneA.setBounds(74, 78, 161, 23);
		contentPane.add(oneA);
		
		JRadioButton oneB = new JRadioButton("");
		oneB.setBackground(Color.WHITE);
		oneB.setBounds(300, 78, 170, 23);
		contentPane.add(oneB);
		
		JRadioButton oneC = new JRadioButton("");
		oneC.setBackground(Color.WHITE);
		oneC.setBounds(575, 78, 161, 23);
		contentPane.add(oneC);
		
		grp1.add(oneA);
		grp1.add(oneB);
		grp1.add(oneC);
		
		JLabel secondQuestion = new JLabel("");
		secondQuestion.setBounds(64, 142, 620, 14);
		contentPane.add(secondQuestion);
		
		JRadioButton twoA = new JRadioButton("");
		twoA.setBackground(Color.WHITE);
		twoA.setBounds(74, 175, 161, 23);
		contentPane.add(twoA);
		
		JRadioButton twoB = new JRadioButton("");
		twoB.setBackground(Color.WHITE);
		twoB.setBounds(300, 175, 170, 23);
		contentPane.add(twoB);
		
		JRadioButton twoC = new JRadioButton("");
		twoC.setBackground(Color.WHITE);
		twoC.setBounds(575, 175, 161, 23);
		contentPane.add(twoC);
		
		grp2.add(twoA);
		grp2.add(twoB);
		grp2.add(twoC);
		
		JLabel thirdQuestion = new JLabel("");
		thirdQuestion.setBounds(64, 242, 620, 14);
		contentPane.add(thirdQuestion);
		
		JRadioButton threeA = new JRadioButton("");
		threeA.setBackground(Color.WHITE);
		threeA.setBounds(74, 280, 161, 23);
		contentPane.add(threeA);
		
		JRadioButton threeB = new JRadioButton("");
		threeB.setBackground(Color.WHITE);
		threeB.setBounds(300, 280, 170, 23);
		contentPane.add(threeB);
		
		JRadioButton threeC = new JRadioButton("");
		threeC.setBackground(Color.WHITE);
		threeC.setBounds(575, 280, 161, 23);
		contentPane.add(threeC);
		
		grp3.add(threeA);
		grp3.add(threeB);
		grp3.add(threeC);
		
		JLabel forthQuestion = new JLabel("");
		forthQuestion.setBounds(64, 342, 620, 14);
		contentPane.add(forthQuestion);
		
		JRadioButton fourA = new JRadioButton("");
		fourA.setBackground(Color.WHITE);
		fourA.setBounds(74, 377, 161, 23);
		contentPane.add(fourA);
		
		JRadioButton fourB = new JRadioButton("");
		fourB.setBackground(Color.WHITE);
		fourB.setBounds(300, 377, 170, 23);
		contentPane.add(fourB);
		
		JRadioButton fourC = new JRadioButton("");
		fourC.setBackground(Color.WHITE);
		fourC.setBounds(575, 377, 161, 23);
		contentPane.add(fourC);
		
		grp4.add(fourA);
		grp4.add(fourB);
		grp4.add(fourC);
		
		JLabel fifthQuestion = new JLabel("");
		fifthQuestion.setBounds(64, 451, 620, 14);
		contentPane.add(fifthQuestion);
		
		JRadioButton fiveA = new JRadioButton("");
		fiveA.setBackground(Color.WHITE);
		fiveA.setBounds(74, 485, 161, 23);
		contentPane.add(fiveA);
		
		JRadioButton fiveB = new JRadioButton("");
		fiveB.setBackground(Color.WHITE);
		fiveB.setBounds(300, 485, 170, 23);
		contentPane.add(fiveB);
		
		JRadioButton fiveC = new JRadioButton("");
		fiveC.setBackground(Color.WHITE);
		fiveC.setBounds(575, 485, 161, 23);
		contentPane.add(fiveC);
		
		grp5.add(fiveA);
		grp5.add(fiveB);
		grp5.add(fiveC);
		
		JButton submitBtn = new JButton("Submit");
	
		submitBtn.setBounds(336, 600, 89, 23);
		contentPane.add(submitBtn);
		
		title.setBounds(34, 15, 89, 14);
		contentPane.add(title);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstQuestion.setText("");
				oneA.setText("");
				oneB.setText("");
				oneC.setText("");
				secondQuestion.setText("");
				twoA.setText("");
				twoB.setText("");
				twoC.setText("");
				thirdQuestion.setText("");
				threeA.setText("");
				threeB.setText("");
				threeC.setText("");
				forthQuestion.setText("");
				fourA.setText("");
				fourB.setText("");
				fourC.setText("");
				fifthQuestion.setText("");
				fiveA.setText("");
				fiveB.setText("");
				fiveC.setText("");
				
				//oneA.setFocusable(rootPaneCheckingEnabled);
				
				score = 0;
				referenceFrame.setVisible(true);
				dispose();
			}
		});
		back.setBounds(34, 600, 89, 23);
		contentPane.add(back);
		
		
		showQuestionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!title.getText().isEmpty()) {
					
					for(Category obj : FileReadSys.getCategoryArray()) {
						//System.out.println(obj.toString());
						if(obj.getCategoryName().equalsIgnoreCase(title.getText())) {
							questions.addAll(obj.getQuestions());
						}
					}
					
				
					int i=0;
					for( Question obj :questions) {
					 	
						if (i==0) {
							firstQuestion.setText(obj.getQuestionText());
							int k = 0;
							for (String opt : obj.getQuestionOptions()) {
								if (k==0) {
									oneA.setText(opt);
								} else if (k==1) {
									oneB.setText(opt);
								} else {
									oneC.setText(opt);
								}
								k++;
							}
						}
						else if(i==1) {
							int k = 0;
							secondQuestion.setText(obj.getQuestionText());
							for (String opt : obj.getQuestionOptions()) {
								if (k==0) {
									twoA.setText(opt);
								} else if (k==1) {
									twoB.setText(opt);
								} else {
									twoC.setText(opt);
								}
								k++;
							}
						} else if (i==2) {
							int k = 0;
							thirdQuestion.setText(obj.getQuestionText());
							for (String opt : obj.getQuestionOptions()) {
								if (k==0) {
									threeA.setText(opt);
								} else if (k==1) {
									threeB.setText(opt);
								} else {
									threeC.setText(opt);
								}
								k++;
							}
						} else if (i == 3) {
							int k = 0;
							forthQuestion.setText(obj.getQuestionText());
							for (String opt : obj.getQuestionOptions()) {
								if (k==0) {
									fourA.setText(opt);
								} else if (k==1) {
									fourB.setText(opt);
								} else {
									fourC.setText(opt);
								}
								k++;
							}
						} else if (i == 4) {
							int k = 0;
							fifthQuestion.setText(obj.getQuestionText());
							for (String opt : obj.getQuestionOptions()) {
								if (k==0) {
									fiveA.setText(opt);
								} else if (k==1) {
									fiveB.setText(opt);
								} else {
									fiveC.setText(opt);
								}
								k++;
							}
						}
						i++;
					}
					questions.clear();
				}
			}
		});
		
		submitBtn.addActionListener(new ActionListener() { //calculates the score and also writes the history of the candidate to a file CandidateLog 
			public void actionPerformed(ActionEvent e) {
				score = 0;
				FileWriter fw;
				try {
					fw = new FileWriter("CandidateLog.txt");
					fw.write(candidate.displayActivity());
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				control.put(0, "a");
				control.put(1, "b");
				control.put(2, "c");
				
				for(Category obj : FileReadSys.getCategoryArray()) {
					//System.out.println(obj.toString());
					if(obj.getCategoryName().equalsIgnoreCase(title.getText())) {
						questions.addAll(obj.getQuestions());
					}
				}
				
				int optionCounter = 0;
				for (Enumeration<AbstractButton> buttons = grp1.getElements(); buttons.hasMoreElements();) {
					
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		                if (questions.get(0).getQuestionAnswer().equalsIgnoreCase(control.get(optionCounter))) {
		                	score+= 10;
		                	
		                }
		                
		            }
		            optionCounter++;
		        }
				
				optionCounter = 0;
				for (Enumeration<AbstractButton> buttons = grp2.getElements(); buttons.hasMoreElements();) {
					
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		                if (questions.get(1).getQuestionAnswer().equalsIgnoreCase(control.get(optionCounter))) {
		                	score+= 10;
		                	
		                }
		                
		            }
		            optionCounter++;
		        }
				
				optionCounter = 0;
				for (Enumeration<AbstractButton> buttons = grp3.getElements(); buttons.hasMoreElements();) {
					
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		                if (questions.get(2).getQuestionAnswer().equalsIgnoreCase(control.get(optionCounter))) {
		                	score+= 10;
		                	
		                }
		                
		            }
		            optionCounter++;
		        }
				
				optionCounter = 0;
				for (Enumeration<AbstractButton> buttons = grp4.getElements(); buttons.hasMoreElements();) {
					
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		                if (questions.get(3).getQuestionAnswer().equalsIgnoreCase(control.get(optionCounter))) {
		                	score+= 10;
		                	
		                }
		                
		            }
		            optionCounter++;
		        }
				
				optionCounter = 0;
				for (Enumeration<AbstractButton> buttons = grp5.getElements(); buttons.hasMoreElements();) {
					
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		                if (questions.get(4).getQuestionAnswer().equalsIgnoreCase(control.get(optionCounter))) {
		                	score+= 10;
		                	
		                }
		                
		            }
		            optionCounter++;
		        }
				
				scoreF.score.setText(score + "");
				for( Candidate obj : CandidateSys.getCandidateArray()) { //setting the updated score
					if(obj.checkId(candidate.getId()))
						obj.setScore(score);
				}
				System.out.println(CandidateSys.getCandidateArray());
				//candidate.setScore(score); //setting the score of the related candidate
				try {
					CandidateSys.saveChanges("candidate.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				scoreF.setVisible(true);
				
			}
		});
	}
}
