package org.maripo.morse;

public abstract class MorseDevice
{

	public abstract void start();
	public abstract void end();
	public abstract void on();
	public abstract void off();
	public  abstract int getBaseSignalLength();

}
