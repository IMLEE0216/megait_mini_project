package miniproject;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.LineBorder;

/**
 * JFrame에 추가할 {@link JPanel} 과 {@link JButton}. <br>
 * 
 * @author 이현성
 *
 */
public class PianoPanel {
	private String[] btn_W = { "a", "s", "d", "f", "g", "h", "j", "k" };
	private String[] btn_B = { "w", "e", "r", "t", "y", "u" };
	public static JButton[] btnW = new JButton[8];
	public static JButton[] btnB = new JButton[6];
	
	public Main parent;

	public PianoPanel(Main main) {
		parent = main;
	}

	public void setPianoPanel() {
		
		JPanel pianoPanel = new JPanel();
		
		pianoPanel.setBounds(0, 0, 500, 300);
		pianoPanel.setBackground(Color.GRAY);
		parent.getContentPane().add(pianoPanel);
		pianoPanel.setFocusable(false);
		pianoPanel.setOpaque(false);
		pianoPanel.setBorder(new LineBorder(new Color(255, 187, 0), 10));
		
		for (int i = 0; i < btn_B.length; ++i) {
			if (btn_B[i].equals("r")) {
				btnB[i] = new JButton();
				btnB[i].setOpaque(false);
				parent.getContentPane().add(btnB[i]);
			} else {
				btnB[i] = new JButton(btn_B[i]);
				btnB[i].setForeground(Color.WHITE);
				btnB[i].setBounds(75 + (i * 50), 40, 45, 95);
				btnB[i].setBackground(Color.BLACK);
				btnB[i].setFocusable(false);
				parent.getContentPane().add(btnB[i]);
			}
			
		}
		
		for (int i = 0; i < btn_W.length; ++i) {
			btnW[i] = new JButton(btn_W[i]);
			btnW[i].setBounds(50 * (i + 1), 140, 45, 110);
			btnW[i].setBackground(Color.WHITE);
			btnW[i].setFocusable(false);
			parent.getContentPane().add(btnW[i]);
		}
		
	
	}

}
