package com.mgrimm21.gefinal;

import java.awt.Graphics;

public abstract class GameObject {

	protected float x, y, velX=0, velY=0;
	protected boolean isRendered = true;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public GameObject(float x, float y, boolean isRendered) {
		this.x = x;
		this.y = y;
		this.isRendered = isRendered;
	}
	
	public void tick() {
		x += velX;
		y += velY;
	}
	
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public boolean isRendered() {
		return isRendered;
	}

	public void setRendered(boolean isRendered) {
		this.isRendered = isRendered;
	}
	
	
	
}
