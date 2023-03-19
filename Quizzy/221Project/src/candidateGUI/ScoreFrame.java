package candidateGUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ScoreFrame extends JFrame {

	private JPanel contentPane;
	public JLabel score = new JLabel("");
	
	public ScoreFrame(candidateQuestionFrame fr) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SCORE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 52));
		lblNewLabel.setBounds(131, 11, 216, 80);
		contentPane.add(lblNewLabel);
		score.setForeground(Color.RED);
		score.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		
		score.setBounds(189, 104, 186, 38);
		contentPane.add(score);
		
		JLabel lblNewLabel_1 = new JLabel("Congrulations!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(148, 153, 155, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel firework = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/firework.gif"));
		firework.setIcon(img);
		firework.setBounds(73, 212, 317, 234);
		contentPane.add(firework);
		
		JLabel nerd = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/nerd.gif"));
		nerd.setIcon(img2);
		nerd.setBounds(343, 11, 231, 190);
		contentPane.add(nerd);
		
		JLabel lblNewLabel_2 = new JLabel("Made by:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(417, 227, 144, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("D. Hazar Alpay");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(417, 261, 157, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("İrem G. Dönmez");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(417, 295, 157, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Zehra Demirhan");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(417, 363, 157, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Poyraz Arı");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(417, 329, 157, 23);
		contentPane.add(lblNewLabel_6);
		
		
		
	}

}
