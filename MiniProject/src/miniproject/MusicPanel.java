package miniproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MusicPanel implements ActionListener, Runnable {
	private String[] btn_M = {"open", "play", "pause", "stop", "reset", "Record", "StopRecrod", "PlayRecord"};
	private JButton[] btnM = new JButton[8];
	private String[] tp = {"musicState", "recordState"};
	private JFileChooser filechooser;
	private File selectedFile;
	private JPanel eastPanel = new JPanel();
	private long cliptime = 0;
	private Clip clip;
	private long endTime;
	
	public static JTextPane[] tpMR = new JTextPane[2];
	public static long startTime;
	public static long playTime;
	public static long time;
	
	public Main parent;

	public MusicPanel(Main main) {
		parent = main;
	}

	public void setMusicPanel() {
		eastPanel.setBounds(500, 0, 380, 600);
		parent.getContentPane().add(eastPanel);
		eastPanel.setBorder(new LineBorder(new Color(255, 187, 0), 10));
		eastPanel.setFocusable(false);
		eastPanel.setOpaque(false);
		
		
		for (int i = 0; i < tp.length; ++i) {
			tpMR[i] = new JTextPane();
			if (i == 0) {
				tpMR[i].setBounds(593, 480, 205, 30);
			} else {
				tpMR[i].setBounds(547, 105, 300, 30);
			} 
				parent.getContentPane().add(tpMR[i]);
				tpMR[i].setAlignmentX(parent.CENTER_ALIGNMENT);
				tpMR[i].setEditable(false);
				tpMR[i].setFocusable(false);
		}
		TextPane();

	
		for (int i = 0; i < btn_M.length; ++i) {
			if (i < 3) {
				btnM[i] = new JButton(btn_M[i]);
				btnM[i].setBounds(542 + (i * 105), 425, 100, 50);
			} else if (i < 5) {
				btnM[i] = new JButton(btn_M[i]);
				btnM[i].setBounds(593 + (i - 3) * 105, 515, 100, 50);
			} else {
				btnM[i] = new JButton(btn_M[i]);
				btnM[i].setBounds(541 + (i - 5) * 105, 50, 101, 50);
				if (btn_M[i].equals("Record")) {
					btnM[i].setEnabled(true);
				} else {
					btnM[i].setEnabled(false);
				}
			}
			parent.getContentPane().add(btnM[i]);
			btnM[i].addKeyListener(new BothKeyPress());
			btnM[i].addActionListener(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnM[0]) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\folder.png");
			Pic.setting();
			filechooser = new JFileChooser();
			if (null == selectedFile) {
				int result = filechooser.showOpenDialog(parent);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedFile = filechooser.getSelectedFile();
					getmusic();
				}
			} else {
				tpMR[0].setText("등록된 음악 있음");
			}

		}

		if (e.getSource() == btnM[1]) {
			try {
				setPic();
				clip.setMicrosecondPosition(cliptime);
				tpMR[0].setText("음악 실행");
				clip.start();
			} catch (Exception e1) {
				tpMR[0].setText("등록된 음악이 없음");
			}

		}

		if (e.getSource() == btnM[2]) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\pause.png");
			Pic.setting();
			try {
				tpMR[0].setText("음악 일시 정지");
				cliptime = clip.getMicrosecondPosition();
				clip.stop();
			} catch (Exception e1) {
				tpMR[0].setText("등록된 음악이 없음");
			}

		}

		if (e.getSource() == btnM[3]) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\stop.png");
			Pic.setting();
			try {
				cliptime = 0;
				clip.stop();
				tpMR[0].setText("음악 정지");
			} catch (Exception e1) {
				tpMR[0].setText("등록된 음악이 없음");
			}
		}

		if (e.getSource() == btnM[4]) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\trashcan.png");
			Pic.setting();
			try {
				clip.stop();
				clip = null;
				selectedFile = null;
				tpMR[0].setText("음악 없음");
			} catch (Exception e1) {
				tpMR[0].setText("등록된 음악이 없음");
			}

		}

		if (e.getSource() == btnM[5]) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\record.png");
			Pic.setting();
			tpMR[1].setText("녹음 중...");
			btnM[5].setEnabled(false);
			btnM[6].setEnabled(true);
			btnM[7].setEnabled(false);
			Main.now = PlayStatus.RECORD;
			startTime = System.currentTimeMillis();
		}

		if (e.getSource() == btnM[6]) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\pause.png");
			Pic.setting();
			tpMR[1].setText("녹음 중지");
			btnM[5].setEnabled(true);
			btnM[6].setEnabled(false);
			btnM[7].setEnabled(true);
			endTime = System.currentTimeMillis() - startTime;
			tpMR[1].setText(Long.toString(endTime) + "녹음");
			Main.now = PlayStatus.PLAY;
		}

		if (e.getSource() == btnM[7]) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\play.png");
			Pic.setting();
			tpMR[1].setText("실행 중...");
			playTime = System.currentTimeMillis();
			Thread th = new Thread(this);
			th.start();
		}

	}

	public void getmusic() {
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(selectedFile);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.setMicrosecondPosition(0);
			tpMR[0].setText("음악준비완료");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public void TextPane() {
		tpMR[0].setText("등록 된 음악 없음");
		for (JTextPane jtp : tpMR) {
			StyledDocument document = jtp.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			document.setParagraphAttributes(0, document.getLength(), center, false);
		}
	}
	
	public void setPic() {
		if (selectedFile.getName().equals("DNA Piano Cover.wav")) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\DNA.png");
			Pic.setting();
		} else if (selectedFile.getName().equals("Believer Piano Cover.wav") 
				|| selectedFile.getName().equals("Believer Drum Cover.wav")) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\believer.png");
			Pic.setting();
		} else if (selectedFile.getName().equals("Another Day Of Sun Piano Cover.wav")) {
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\lalaland.png");
			Pic.setting();
		}
	}

	@Override
	public void run() {
		for (long i = 0; i < endTime; ++i) {
			try {
				Thread.sleep((long)1);
				AudioInputStream stream = AudioSystem.getAudioInputStream(BothKeyPress.map.get(i));
				Clip clip = AudioSystem.getClip();
				clip.open(stream);
				clip.start();
			} catch (Exception e) {
				
			}
		}
		tpMR[1].setText("끝   ('P' = map.clear)");
	}
}
