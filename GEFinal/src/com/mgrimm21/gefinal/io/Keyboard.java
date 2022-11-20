package com.mgrimm21.gefinal.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	private static boolean[] keys = new boolean[512];
	private static boolean[] keysNew = new boolean[512];
	private static boolean[] released = new boolean[512];

	static {
		for (int i = 0; i < released.length; i++) released[i] = true;
	}
	
	public static boolean isKeyDown(int key) {
		return keys[key];
	}
	
	public static boolean isKeyDownOnce(int key) {
		if (keysNew[key]) {
			keysNew[key] = false;
			return true;
		}
		return false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (released[e.getKeyCode()]) {
			keys[e.getKeyCode()] = true;
			keysNew[e.getKeyCode()] = true;
		}
		released[e.getKeyCode()] = false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		keysNew[e.getKeyCode()] = false;
		released[e.getKeyCode()] = true;
	}

}
