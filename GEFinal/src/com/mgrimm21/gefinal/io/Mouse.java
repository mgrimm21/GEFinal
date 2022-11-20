package com.mgrimm21.gefinal.io;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{
	
	public static int mouseX = 0, mouseY = 0;
	
	private static boolean[] buttons = new boolean[35];
	
	public static boolean isDown(int button) {
		return buttons[button];
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
