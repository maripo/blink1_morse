package org.maripo.morse;

import java.util.HashMap;
import java.util.Map;

class MorseLetter
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
		
		MORSE.put('A', new MorseLetter(new Signal[] { S, L }));
		MORSE.put('B', new MorseLetter(new Signal[] { L, S, S, S }));
		MORSE.put('C', new MorseLetter(new Signal[] { L, S, L, S }));
		MORSE.put('D', new MorseLetter(new Signal[] { L, S, S }));
		MORSE.put('E', new MorseLetter(new Signal[] { S }));
		MORSE.put('F', new MorseLetter(new Signal[] { S, S, L, S }));
		MORSE.put('G', new MorseLetter(new Signal[] { L, L, S }));
		MORSE.put('H', new MorseLetter(new Signal[] { S, S, S, S }));
		MORSE.put('I', new MorseLetter(new Signal[] { S, S, }));
		MORSE.put('J', new MorseLetter(new Signal[] { S, L, L, L }));
		MORSE.put('K', new MorseLetter(new Signal[] { L, S, L }));
		MORSE.put('L', new MorseLetter(new Signal[] { S, L, S, S }));
		MORSE.put('M', new MorseLetter(new Signal[] { L, L }));
		MORSE.put('N', new MorseLetter(new Signal[] { L, S }));
		MORSE.put('O', new MorseLetter(new Signal[] { L, L, L }));
		MORSE.put('P', new MorseLetter(new Signal[] { S, L, L, S }));
		MORSE.put('Q', new MorseLetter(new Signal[] { L, L, S, L }));
		MORSE.put('R', new MorseLetter(new Signal[] { S, L, S }));
		MORSE.put('S', new MorseLetter(new Signal[] { S, S, S }));
		MORSE.put('T', new MorseLetter(new Signal[] { L }));
		MORSE.put('U', new MorseLetter(new Signal[] { S, S, L }));
		MORSE.put('V', new MorseLetter(new Signal[] { S, S, S, L }));
		MORSE.put('W', new MorseLetter(new Signal[] { S, L, L }));
		MORSE.put('X', new MorseLetter(new Signal[] { L, S, S, L }));
		MORSE.put('Y', new MorseLetter(new Signal[] { L, S, L, L }));
		MORSE.put('Z', new MorseLetter(new Signal[] { L, L, S, S }));
		
		// Numbers
		MORSE.put('1', new MorseLetter(new Signal[]{S, L, L, L, L}));
		MORSE.put('2', new MorseLetter(new Signal[]{S, S, L, L, L}));
		MORSE.put('3', new MorseLetter(new Signal[]{S, S, S, L, L}));
		MORSE.put('4', new MorseLetter(new Signal[]{S, S, S, S, L}));
		MORSE.put('5', new MorseLetter(new Signal[]{S, S, S, S, S}));
		MORSE.put('6', new MorseLetter(new Signal[]{L, S, S, S, S}));
		MORSE.put('7', new MorseLetter(new Signal[]{L, L, S, S, S}));
		MORSE.put('8', new MorseLetter(new Signal[]{L, L, L, S, S}));
		MORSE.put('9', new MorseLetter(new Signal[]{L, L, L, L, S}));
		MORSE.put('0', new MorseLetter(new Signal[]{L, L, L, L, L}));
		
		// Marks
		MORSE.put('.', new MorseLetter(new Signal[]{S,L,S,L,S,L}));
		MORSE.put(',', new MorseLetter(new Signal[]{L,L,S,S,L,L}));
		MORSE.put('?', new MorseLetter(new Signal[]{S,S,L,L,S,S}));
		MORSE.put('!', new MorseLetter(new Signal[]{L,S,L,S,L,L}));
		MORSE.put('-', new MorseLetter(new Signal[]{L,S,S,S,S,L}));
		MORSE.put('/', new MorseLetter(new Signal[]{L,S,S,L,S}));
		MORSE.put('@', new MorseLetter(new Signal[]{S,L,L,S,L,S}));
		MORSE.put('(', new MorseLetter(new Signal[]{L,S,L,L,S}));
		MORSE.put(')', new MorseLetter(new Signal[]{L,S,L,L,S,L}));
		
		MORSE.put(new Character(' '), new MorseLetter(new Signal[]{Signal.SPACE}));
	}

}