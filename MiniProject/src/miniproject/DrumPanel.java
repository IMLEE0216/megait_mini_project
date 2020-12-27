package miniproject;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 * JFrame에 추가할 {@link JPanel} 과 {@link JButton}. <br>
 * @author 이현성
 */

public class DrumPanel {
	private static final String WAV = "C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\drum";
	private static final String PNG = ".png";
	private String[] btn_D = {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9"};
	public static JButton[] btnD = new JButton[9];
	private ImageIcon icon, changeIcon;
	private Image img, changeImg;
	private JPanel dPanel = new JPanel();
	public Main parent;
	
	public DrumPanel(Main main) {
		parent = main;
	}

	public void setDrumPanel() {
		dPanel.setBounds(0, 300, 500, 300);
		dPanel.setFocusable(false);
		dPanel.setOpaque(false);
		dPanel.setBorder(new LineBorder(new Color(255, 187, 0), 10));
		parent.getContentPane().add(dPanel);

		for (int i = 0; i < btn_D.length; ++i) {
			icon = new ImageIcon(WAV + i + PNG);
			img = icon.getImage();
			changeImg = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
			changeIcon = new ImageIcon(changeImg);
			if (i < 3) {
				btnD[i] = new JButton(changeIcon);
				btnD[i].setBounds(115 + (i * 90), 315, 90, 90);
				parent.getContentPane().add(btnD[i]);
				btnD[i].setBorder(new LineBorder(Color.GRAY, 7));
				btnD[i].setFocusable(false);
			} else if (i < 6) {
				btnD[i] = new JButton(changeIcon);
				btnD[i].setBounds(115 + ((i - 3) * 90), 405, 90, 90);
				parent.getContentPane().add(btnD[i]);
				btnD[i].setBorder(new LineBorder(Color.GRAY, 7));
				btnD[i].setFocusable(false);
			} else {
				btnD[i] = new JButton(changeIcon);
				btnD[i].setBounds(115 + ((i - 6) * 90), 495, 90, 90);
				parent.getContentPane().add(btnD[i]);
				btnD[i].setBorder(new LineBorder(Color.GRAY, 7));
				btnD[i].setFocusable(false);
			}

		}

	}

}
