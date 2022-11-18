package com.mgrimm21.gefinal;

import java.awt.Graphics;

public class LogicObject extends GameObject{

	public LogicObject(float x, float y) {
		super(x, y);
		isRendered = false;
	}

	@Override
	public void tick() {
		
	}

	@Override
	@Deprecated
	public void render(Graphics g) {
		if (!isRendered) return;
	}

}
