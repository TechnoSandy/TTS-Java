package demo1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTS {

	private JFrame frame;
	private final String VOICENAME_kevin = "kevin";
	private String text = "Hello World " ;  

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTS window = new TTS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TTS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton sayHello = new JButton("Say Hello !");
		sayHello.setFont(new Font("Tahoma", Font.PLAIN, 70));
		sayHello.setForeground(Color.ORANGE);
		sayHello.setBackground(Color.WHITE);
		sayHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				speak();
			}
		});
		sayHello.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(sayHello);
		
		 
	}
	
	public void speak() {
		  Voice voice;
		  VoiceManager voiceManager = VoiceManager.getInstance();
		  voice = voiceManager.getVoice(VOICENAME_kevin);
		  voice.allocate();
		  voice.speak(getText());
		 }
}
