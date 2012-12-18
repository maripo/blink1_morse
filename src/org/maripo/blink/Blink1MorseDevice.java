package org.maripo.blink;

import org.maripo.morse.MorseDevice;

import thingm.blink1.Blink1;

class Blink1MorseDevice extends MorseDevice {

	static final int DEFAULT_COLOR_R = 255;
	static final int DEFAULT_COLOR_G = 255;
	static final int DEFAULT_COLOR_B = 255;
	private int r = DEFAULT_COLOR_R;
	private int g = DEFAULT_COLOR_G;
	private int b = DEFAULT_COLOR_B;

	private static final int DEFAULT_BASE_SIGNAL_LENGTH = 50;
	private int baseSignalLength = DEFAULT_BASE_SIGNAL_LENGTH;
	
	Blink1 blink1 = new Blink1();
	@Override
	public void start()
	{

		blink1 = new Blink1();
		if (blink1.open() == -1)
		{
			System.out.println("No blink1 found.");
		}
	}

	@Override
	public void end()
	{
		blink1.close();
	}

	@Override
	public void on()
	{
		blink1.setRGB(r, g, b);
	}

	@Override
	public void off()
	{
		blink1.setRGB(0, 0, 0);
	}


	@Override
	public int getBaseSignalLength()
	{
		return baseSignalLength;
	}

	public Blink1MorseDevice setColor(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		return this;
	}
	
	public Blink1MorseDevice setBaseSignalLength (int baseSignalLength)
	{
		this.baseSignalLength = baseSignalLength;
		return this;
	}
}