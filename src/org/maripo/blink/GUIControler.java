package org.maripo.blink;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JSlider;

import org.maripo.morse.MorseDevice;
import org.maripo.morse.MorsePlayer;

public class GUIControler extends Applet
{
	Button button;
	TextField text;
	MorsePlayer morsePlayer;
	Blink1MorseDevice device;
	JSlider sliderR;
	JSlider sliderG;
	JSlider sliderB;
	JSlider sliderSpeed;
	public void init() 
	{
		device = new Blink1MorseDevice();
		morsePlayer = new MorsePlayer();
		morsePlayer.setDevice(device);
		text = new TextField(26);
		text.addKeyListener(new KeyListener ()
		{
			
			@Override
			public void keyTyped(KeyEvent event)
			{
				if (event.getKeyChar()=='\n')
					send();
			}
			
			@Override
			public void keyReleased(KeyEvent arg0)
			{
			}
			
			@Override
			public void keyPressed(KeyEvent arg0)
			{
			}
		});
		add(text);

		resize(480, 160);
		button = new Button("Send");
		button.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent event)
			{
				send();
			}
		});
		add(button);

		Panel panel = new Panel();
		panel.setLayout(new GridLayout(4, 2));
		sliderR = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
		sliderG = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
		sliderB = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
		sliderSpeed = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);
		panel.add(new Label("Red"));
		panel.add(sliderR);
		panel.add(new Label("Green"));
		panel.add(sliderG);
		panel.add(new Label("Blue"));
		panel.add(sliderB);
		panel.add(new Label("Speed"));
		panel.add(sliderSpeed);
		
		add(panel);
	}
	
	class SliderListener {
		
	}
	
	void send () {
		String message = text.getText();
		device.setColor(sliderR.getValue(), sliderG.getValue(), sliderB.getValue());
		device.setBaseSignalLength(4000/sliderSpeed.getValue());
		text.setText("");
		morsePlayer.play(message);
	}
}
