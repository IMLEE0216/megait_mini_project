package miniproject;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Pic {
	public static JLabel center = new JLabel();
	public static ImageIcon icon1, icon11;
	public static Image img, changeImg;
	public Main parent;
	private JPanel picPanel = new JPanel();

	public Pic(Main main) {
		parent = main;
	}

	public void setPic() {
		picPanel.setBounds(547, 150, 300, 260);
		picPanel.setFocusable(false);
		picPanel.setOpaque(false);
		picPanel.setBorder(new LineBorder(new Color(255, 187, 0), 10));
		parent.getContentPane().add(picPanel);

		icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\star.png");
		center = new JLabel();
		center.setBounds(547, 150, 300, 260);
		parent.getContentPane().add(center);
		center.setBackground(Color.WHITE);
		center.setFocusable(false);
		setting();
	}
	
	public static void setting() {
		img = icon1.getImage();
		changeImg = img.getScaledInstance(300, 260, Image.SCALE_SMOOTH);
		icon11 = new ImageIcon(changeImg);
		center.setIcon(icon11);
	}

}
