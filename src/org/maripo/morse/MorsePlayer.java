package org.maripo.morse;

import java.awt.Scrollbar;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JSlider;
import javax.swing.plaf.SliderUI;

import org.maripo.morse.MorseLetter.Signal;

public class MorsePlayer
{
	MorseDevice device = null;
	boolean debug = false;
	
	public MorsePlayer()
	{
	}

	public void play(String _message)
	{
		List<MorseLetter> letters = new ArrayList<MorseLetter>();
		String message = _message.toUpperCase();

		
		for (int i = 0; i < message.length(); i++)
		{
			char c = message.charAt(i);
			if (MorseLetter.MORSE.containsKey(c))
				letters.add(MorseLetter.MORSE.get(c));
			else
			{
				System.out.println("WARNING: Letter \"" + c + "\" is not supported.");
			}
		}
		
		device.start();
		
		int msecOffset = 0;
		for (MorseLetter letter : letters)
		{
			TimerTask task = new LetterTask(letter);
			Timer timer = new Timer();
			timer.schedule(task, TimeUnit.MILLISECONDS.toMillis(msecOffset));
			msecOffset += getLetterLength(letter);
		}
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				device.end();
			}
		}, msecOffset);
	}


	public void playLetter(MorseLetter letter)
	{
		int msecOffset = 0;
		Signal[] signals = letter.getSignals();
		if (debug)
			System.out.println(" ");
		for (Signal signal : signals)
		{
			if (Signal.SPACE==signal)
				continue;
			TimerTask task = new SignalTask(signal, device);
			Timer timer = new Timer();
			timer.schedule(task, TimeUnit.MILLISECONDS.toMillis(msecOffset));
			msecOffset += (signal == Signal.LONG) ? getLengthLong()
					: getLengthShort();
			timer.schedule(new TimerTask()
			{

				@Override
				public void run()
				{
					device.off();
				}
			}, msecOffset);
			msecOffset += getLengthBetweenLetters();
		}
	}

	public int getLetterLength(MorseLetter letter)
	{
		int length = 0;
		for (Signal signal : letter.getSignals())
		{
			if (Signal.SHORT == signal)
				length += getLengthShort();
			if (Signal.LONG == signal)
				length += getLengthLong();
			if (Signal.SPACE == signal)
				length += getLengthBetweenWords();
			length += getLengthBetweenLetters();
		}
		return length;
	}


	int getLengthShort()
	{
		return device.getBaseSignalLength();
	}

	int getLengthLong()
	{
		return device.getBaseSignalLength() * 3;
	}

	int getLengthBetweenSignals()
	{
		return device.getBaseSignalLength() * 1;
	}

	int getLengthBetweenLetters()
	{
		return device.getBaseSignalLength() * 3;
	}

	int getLengthBetweenWords()
	{
		return device.getBaseSignalLength() * 7;
	}
	class SignalTask extends TimerTask
	{
		private Signal signal;
		private MorseDevice device;

		public SignalTask(Signal signal, MorseDevice device)
		{
			this.signal = signal;
			this.device = device;
		}

		@Override
		public void run()
		{
			if (debug)
				System.out.print((signal == Signal.LONG) ? "_" : ".");
			device.on();

		}
	}

	class LetterTask extends TimerTask
	{
		MorseLetter letter;

		public LetterTask(MorseLetter letter)
		{
			this.letter = letter;
		}

		@Override
		public void run()
		{
			playLetter(letter);
		}

	}

	public MorseDevice getDevice()
	{
		return device;
	}

	public void setDevice(MorseDevice device)
	{
		this.device = device;
	}

	public boolean isDebug()
	{
		return debug;
	}

	public void setDebug(boolean debug)
	{
		this.debug = debug;
	}
}
