package miniproject;

import javax.swing.JFrame;

public class Main extends JFrame{

	public static PlayStatus now;

	public Main() {
		
		super("Music");
		
		setSize(900, 650);
		
		addKeyListener(new BothKeyPress());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setFocusable(true);
		
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
