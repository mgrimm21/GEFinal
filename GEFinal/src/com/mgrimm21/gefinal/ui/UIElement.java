package com.mgrimm21.gefinal.ui;

import java.awt.Graphics;

public abstract class UIElement {

	protected int x, y;
	
	public UIElement(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
