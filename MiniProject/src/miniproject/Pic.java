package miniproject;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 * JFrame에 추가할 {@link JLabel}
 * @author 이현성
 *
 */
public class Pic {
	/**
	 * ActionEvent시 이미지 변화를 위한 {@link JLabel}
	 */
	public static JLabel center = new JLabel();
	/**
	 * 공통 {@link ImageIcon} 객체
	 */
	public static ImageIcon icon1, icon11;
	public static Image img, changeImg;
	/**
	 * {@link JLabel} 틀 맞추기 {@link JPanel}
	 */
	private JPanel picPanel = new JPanel();
	public Main parent;
	public Pic(Main main) {
		parent = main;
	}
	/**
	 * getContentPane()이 된 {@link JLabel}을 위하여 {@link JPanel} 투명화 <br>
	 * {@link JPanel} Border 및 Color 추가
	 * {@link JButton} 위치 고정 및  Focus는 false
	 * {@link JLabel} 초기 이미지 고정
	 */
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
	/**
	 * ActionEvent시 이미지 변화
	 */
	public static void setting() {
		img = icon1.getImage();
		changeImg = img.getScaledInstance(300, 260, Image.SCALE_SMOOTH);
		icon11 = new ImageIcon(changeImg);
		center.setIcon(icon11);
	}

}
