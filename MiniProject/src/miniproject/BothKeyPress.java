package miniproject;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * 피아노 및 드럼 소리 
 * @author 이현성
 *
 */
public class BothKeyPress implements KeyListener {
	public static final String WAV = "C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\sound_files\\";
	public File file;
	public static TreeMap<Long, File> map = new TreeMap<>();

	public void clip(File file) {
		this.file = file;
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * RECORD 상태일시 {@link TreeMap}에 입력키 값 저장
	 */
	public void record() {
		if (Main.now == PlayStatus.RECORD) {
			map.put(System.currentTimeMillis() - MusicPanel.startTime, file);
			System.out.println(map);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			PianoPanel.btnW[0].setBackground(Color.GRAY);
			clip(new File(WAV + "25.wav"));
			record();
			break;

		case KeyEvent.VK_W:
			PianoPanel.btnB[0].setBackground(Color.GRAY);
			clip(new File(WAV + "26.wav"));
			record();
			break;

		case KeyEvent.VK_S:
			PianoPanel.btnW[1].setBackground(Color.GRAY);
			clip(new File(WAV + "27.wav"));
			record();
			break;

		case KeyEvent.VK_E:
			PianoPanel.btnB[1].setBackground(Color.GRAY);
			clip(new File(WAV + "28.wav"));
			record();
			break;

		case KeyEvent.VK_D:
			PianoPanel.btnW[2].setBackground(Color.GRAY);
			clip(new File(WAV + "29.wav"));
			record();
			break;

		case KeyEvent.VK_F:
			PianoPanel.btnW[3].setBackground(Color.GRAY);
			clip(new File(WAV + "30.wav"));
			record();
			break;

		case KeyEvent.VK_T:
			PianoPanel.btnB[3].setBackground(Color.GRAY);
			clip(new File(WAV + "31.wav"));
			record();
			break;

		case KeyEvent.VK_G:
			PianoPanel.btnW[4].setBackground(Color.GRAY);
			clip(new File(WAV + "32.wav"));
			record();
			break;

		case KeyEvent.VK_Y:
			PianoPanel.btnB[4].setBackground(Color.GRAY);
			clip(new File(WAV + "33.wav"));
			record();
			break;

		case KeyEvent.VK_H:
			PianoPanel.btnW[5].setBackground(Color.GRAY);
			clip(new File(WAV + "34.wav"));
			record();
			break;

		case KeyEvent.VK_U:
			PianoPanel.btnB[5].setBackground(Color.GRAY);
			clip(new File(WAV + "35.wav"));
			record();
			break;

		case KeyEvent.VK_J:
			PianoPanel.btnW[6].setBackground(Color.GRAY);
			clip(new File(WAV + "36.wav"));
			record();
			break;

		case KeyEvent.VK_K:
			PianoPanel.btnW[7].setBackground(Color.GRAY);
			clip(new File(WAV + "37.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD1:
			DrumPanel.btnD[6].setBorderPainted(false);
			clip(new File(WAV + "hihat0.wav"));
			record();

			break;

		case KeyEvent.VK_NUMPAD2:
			DrumPanel.btnD[7].setBorderPainted(false);
			clip(new File(WAV + "hihat1.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD3:
			DrumPanel.btnD[8].setBorderPainted(false);
			clip(new File(WAV + "kick0.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD4:
			DrumPanel.btnD[3].setBorderPainted(false);
			clip(new File(WAV + "kick1.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD5:
			DrumPanel.btnD[4].setBorderPainted(false);
			clip(new File(WAV + "percu0.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD9:
			DrumPanel.btnD[2].setBorderPainted(false);
			clip(new File(WAV + "percu1.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD7:
			DrumPanel.btnD[0].setBorderPainted(false);
			clip(new File(WAV + "snare0.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD8:
			DrumPanel.btnD[1].setBorderPainted(false);
			clip(new File(WAV + "snare1.wav"));
			record();
			break;

		case KeyEvent.VK_NUMPAD6:
			DrumPanel.btnD[5].setBorderPainted(false);
			clip(new File(WAV + "kick2.wav"));
			record();
			break;
			
		case KeyEvent.VK_P:
			map.clear();
			MusicPanel.tpMR[1].setText("녹음 초기화");
			Pic.icon1 = new ImageIcon("C:\\Users\\PC!\\Desktop\\JAVA\\MiniProject\\Icon\\trashcan.png");
			Pic.setting();
			break;
			
		case KeyEvent.VK_Z:
			PianoPanel.btnW[0].setBackground(Color.GRAY);
			PianoPanel.btnW[2].setBackground(Color.GRAY);
			PianoPanel.btnW[4].setBackground(Color.GRAY);
			clip(new File(WAV + "25.wav"));
			record();
			clip(new File(WAV + "29.wav"));
			record();
			clip(new File(WAV + "32.wav"));
			record();
			break;
			
		case KeyEvent.VK_X:
			PianoPanel.btnW[1].setBackground(Color.GRAY);
			PianoPanel.btnW[3].setBackground(Color.GRAY);
			PianoPanel.btnW[5].setBackground(Color.GRAY);
			clip(new File(WAV + "27.wav"));
			record();
			clip(new File(WAV + "30.wav"));
			record();
			clip(new File(WAV + "34.wav"));
			record();
			break;
			
		case KeyEvent.VK_C:
			PianoPanel.btnW[2].setBackground(Color.GRAY);
			PianoPanel.btnW[4].setBackground(Color.GRAY);
			PianoPanel.btnW[6].setBackground(Color.GRAY);
			clip(new File(WAV + "29.wav"));
			record();
			clip(new File(WAV + "32.wav"));
			record();
			clip(new File(WAV + "36.wav"));
			record();
			break;
			
		case KeyEvent.VK_V:
			PianoPanel.btnW[3].setBackground(Color.GRAY);
			PianoPanel.btnW[5].setBackground(Color.GRAY);
			PianoPanel.btnW[7].setBackground(Color.GRAY);
			clip(new File(WAV + "30.wav"));
			record();
			clip(new File(WAV + "34.wav"));
			record();
			clip(new File(WAV + "37.wav"));
			record();
			break;
			
		default:
			break;
		}

	}
/**
 * {@link JButton}의 본 background로 수정
 */
	@Override
	public void keyReleased(KeyEvent e) {
		for (JButton btnD : DrumPanel.btnD) {
			btnD.setBorderPainted(true);
		}

		for (JButton btnW : PianoPanel.btnW) {
			btnW.setBackground(Color.WHITE);
		}

		for (JButton btnB : PianoPanel.btnB) {
			btnB.setBackground(Color.BLACK);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
