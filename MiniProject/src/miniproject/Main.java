package miniproject;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * 프로그램의 Main 프레임 <br>
 * 사용자의 입력에 따라 {@link KeyListener}를 포함한다. <br>
 * 화면크기 변경은 불가
 * @author 이현성
 * 
 */

public class Main extends JFrame{

	public static PlayStatus now;
	/**
	 * Main프레임에  DrumPanel, PianoPanel, MusicPanel, Pic 객체 추가
	 */
	public Main() {
		super("Music");
		setSize(900, 650);
		addKeyListener(new BothKeyPress());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setFocusable(true);
		setResizable(false);
		new DrumPanel(this).setDrumPanel();
		new PianoPanel(this).setPianoPanel();
		new MusicPanel(this).setMusicPanel();
		new Pic(this).setPic();
		setFocusableWindowState(true);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}


}
