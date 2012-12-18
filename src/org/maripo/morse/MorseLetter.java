package org.maripo.morse;

import java.util.HashMap;
import java.util.Map;

public class MorseLetter
{

	private Signal[] signals = new Signal[0];

	public MorseLetter()
	{
	}
	
	public MorseLetter(Signal[] signals)
	{
		this.signals = signals;
	}

	public Signal[] getSignals()
	{
		return this.signals;
	}

	// Morse Dictionary
	public static final Map<Character, MorseLetter> MORSE = new HashMap<Character, MorseLetter>();

	static enum Signal
	{
		SHORT, LONG, SPACE;
	}

	static
	{
		Signal S = Signal.SHORT;
		Signal L = Signal.LONG;
		MORSE.put(new Character('A'), new MorseLetter(new Signal[] { S, L }));
		MORSE.put(new Character('B'), new MorseLetter(
				new Signal[] { L, S, S, S }));
		MORSE.put(new Character('C'), new MorseLetter(
				new Signal[] { L, S, L, S }));
		MORSE.put(new Character('D'), new MorseLetter(new Signal[] { L, S, S }));
		MORSE.put(new Character('E'), new MorseLetter(new Signal[] { S }));
		MORSE.put(new Character('F'), new MorseLetter(
				new Signal[] { S, S, L, S }));
		MORSE.put(new Character('G'), new MorseLetter(new Signal[] { L, L, S }));
		MORSE.put(new Character('H'), new MorseLetter(
				new Signal[] { S, S, S, S }));
		MORSE.put(new Character('I'), new MorseLetter(new Signal[] { S, S, }));
		MORSE.put(new Character('J'), new MorseLetter(
				new Signal[] { S, L, L, L }));
		MORSE.put(new Character('K'), new MorseLetter(new Signal[] { L, S, L }));
		MORSE.put(new Character('L'), new MorseLetter(
				new Signal[] { S, L, S, S }));
		MORSE.put(new Character('M'), new MorseLetter(new Signal[] { L, L }));
		MORSE.put(new Character('N'), new MorseLetter(new Signal[] { L, S }));
		MORSE.put(new Character('O'), new MorseLetter(new Signal[] { L, L, L }));
		MORSE.put(new Character('P'), new MorseLetter(
				new Signal[] { S, L, L, S }));
		MORSE.put(new Character('Q'), new MorseLetter(
				new Signal[] { L, L, S, L }));
		MORSE.put(new Character('R'), new MorseLetter(new Signal[] { S, L, S }));
		MORSE.put(new Character('S'), new MorseLetter(new Signal[] { S, S, S }));
		MORSE.put(new Character('T'), new MorseLetter(new Signal[] { L }));
		MORSE.put(new Character('U'), new MorseLetter(new Signal[] { S, S, L }));
		MORSE.put(new Character('V'), new MorseLetter(
				new Signal[] { S, S, S, L }));
		MORSE.put(new Character('W'), new MorseLetter(new Signal[] { S, L, L }));
		MORSE.put(new Character('X'), new MorseLetter(
				new Signal[] { L, S, S, L }));
		MORSE.put(new Character('Y'), new MorseLetter(
				new Signal[] { L, S, L, L }));
		MORSE.put(new Character('Z'), new MorseLetter(
				new Signal[] { L, L, S, S }));
		
		//Numbers
		MORSE.put(new Character('1'), new MorseLetter(new Signal[]{S, L, L, L, L}));
		MORSE.put(new Character('2'), new MorseLetter(new Signal[]{S, S, L, L, L}));
		MORSE.put(new Character('3'), new MorseLetter(new Signal[]{S, S, S, L, L}));
		MORSE.put(new Character('4'), new MorseLetter(new Signal[]{S, S, S, S, L}));
		MORSE.put(new Character('5'), new MorseLetter(new Signal[]{S, S, S, S, S}));
		MORSE.put(new Character('6'), new MorseLetter(new Signal[]{L, S, S, S, S}));
		MORSE.put(new Character('7'), new MorseLetter(new Signal[]{L, L, S, S, S}));
		MORSE.put(new Character('8'), new MorseLetter(new Signal[]{L, L, L, S, S}));
		MORSE.put(new Character('9'), new MorseLetter(new Signal[]{L, L, L, L, S}));
		MORSE.put(new Character('0'), new MorseLetter(new Signal[]{L, L, L, L, L}));
		
		MORSE.put(new Character(' '), new MorseLetter(new Signal[]{Signal.SPACE}));
	}

}