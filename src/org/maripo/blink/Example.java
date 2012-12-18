package org.maripo.blink;

import org.maripo.morse.MorsePlayer;

/**
 * Send Morse code with blink(1)
 * 
 * @author maripo
 * 
 */
class Example
{
	protected static final boolean DEBUG = false;

	public static void main(String[] args)
	{
		playMorse(args[0]);
	}

	public static void playMorse(String message)
	{
		MorsePlayer morsePlayer = new MorsePlayer();
		
		morsePlayer.setDevice(new Blink1MorseDevice()
			.setColor(255, 0, 0)
			.setBaseSignalLength(40));
		
		morsePlayer.play(message);
	}
}
