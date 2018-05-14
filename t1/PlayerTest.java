package test.yubei.com.app.t1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.swt.SWT;

public class PlayerTest {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PlayerTest window = new PlayerTest();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(84, 29, 94, 34);
		btnNewButton.setText("\u64AD\u653E");
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("\u6682\u505C");
		button.setBounds(84, 79, 94, 34);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setText("\u505C\u6B62");
		button_1.setBounds(84, 127, 94, 34);

	}
	
	public static void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		AudioInputStream ais= AudioSystem.getAudioInputStream(new File("E:/KuGou/test1.wav"));
		AudioFormat af = ais.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, af);
		Clip clip=(Clip) AudioSystem.getLine(info);
		clip.open(ais);
		ais.close();
	}
}
